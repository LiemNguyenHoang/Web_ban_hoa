package liemnguyen.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sun.xml.internal.bind.CycleRecoverable.Context;

import liemnguyen.entity.LoaiSanPham;
import liemnguyen.entity.SanPham;
import liemnguyen.service.LoaiSanPhamService;
import liemnguyen.service.SanPhamService;

@Controller
public class DashboardThemSanPhamController {
	
	@Autowired
	SanPhamService sanPhamService;
	

	@Autowired
	LoaiSanPhamService loaiSanPhamService;
	
	@Autowired
	ServletContext context; 

	@RequestMapping(value="dashboardthemsanpham",method=RequestMethod.GET)
	public String index(Model model,HttpSession httpSession,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{		
		if(httpSession.getAttribute("user_name")!=null){
			String user = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user",user);
		}
		List<LoaiSanPham> listLoaiSanPham =loaiSanPhamService.listLoaiSanPham();
		model.addAttribute("danhmucsp",listLoaiSanPham);
		
//		List<SanPham> listSanPham = sanPhamService.layDanhSachSanPhamLimit(0);
//		model.addAttribute("listSanPham",listSanPham);
//		int page = 5; //listSanPham/(số sp mỗi page)
//		model.addAttribute("tongpage",page);
		
		model.addAttribute("danhmucsp",listLoaiSanPham);
		return "dashboard_themsanpham";
	}
	
	@RequestMapping(value="dashboardthemsanpham",method=RequestMethod.POST)
	public String index(@RequestParam("tensanpham")String tenSanPham,
						@RequestParam("danhmucsanpham")String loaiSanPham,
						@RequestParam("giasanpham")String giaSanPham,
						@RequestParam("motasanpham")String moTaSanPham,
						@RequestParam("hinhanhsanpham")MultipartFile hinhAnhSanPham)  {
		
		 if(hinhAnhSanPham.isEmpty()){
			 System.out.println("Không có file");
		 }else{
			 try{
				 String path = context.getRealPath("/resource/image/sanpham/"+hinhAnhSanPham.getOriginalFilename());
				 hinhAnhSanPham.transferTo(new File(path));
				 
				 
				 
				 LoaiSanPham loaiSanPham2 = loaiSanPhamService.layLoaiTheoMa(Integer.parseInt(loaiSanPham));
				 		
				 System.out.println(loaiSanPham2.getTenLoai());
				 SanPham sanPham = new SanPham(loaiSanPham2, tenSanPham, Integer.parseInt(giaSanPham), hinhAnhSanPham.getOriginalFilename(), moTaSanPham);
				 System.out.println("OK");
				 if(sanPhamService.themSanPham(sanPham)){
					 System.out.println("Thêm thành công");
				 }else{
					 System.out.println("Thêm thất bại");
				 }
				 
				 
			 }catch(Exception e){
				 System.out.println("Lỗi lưu file: "+e.getMessage());
			 }
		 }
		return "dashboard_themthanhcong";
	}
	
}












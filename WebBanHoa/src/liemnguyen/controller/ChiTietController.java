package liemnguyen.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import liemnguyen.entity.GioHangSP;
import liemnguyen.entity.LoaiSanPham;
import liemnguyen.entity.SanPham;
import liemnguyen.service.LoaiSanPhamService;
import liemnguyen.service.SanPhamService;

@Controller
@RequestMapping("/chitiet")
@SessionAttributes("gio_hang")
public class ChiTietController {
	@Autowired
	SanPhamService sanPhamService;
	@Autowired
	LoaiSanPhamService loaiSanPhamService;
	
	@RequestMapping(value = "/{masanpham}", method = RequestMethod.GET)
	public String index(@PathVariable int masanpham,ModelMap model,HttpSession httpSession) {
		if (httpSession.getAttribute("user_name") != null) {
			String user = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user", user);
		}
		
		int soluong = 0;
		if(httpSession.getAttribute("gio_hang")!=null){
			List<GioHangSP> listGioHang = (List<GioHangSP>) httpSession.getAttribute("gio_hang");
			if(listGioHang.size()!=0){
				model.addAttribute("soluonggh",listGioHang.size());
			}
			else{
				model.addAttribute("soluonggh",0);
			}
		}else{
			model.addAttribute("soluonggh",0);
		}
		model.addAttribute("soluong",soluong);
		
		
		SanPham sanPham =  sanPhamService.laySanPham(masanpham);
		model.addAttribute("sanpham",sanPham);
		
		List<LoaiSanPham> listLoaiSanPham = loaiSanPhamService.listLoaiSanPham();
		model.addAttribute("listloaisanpham",listLoaiSanPham);
		return "chitietsanpham";
	}
}



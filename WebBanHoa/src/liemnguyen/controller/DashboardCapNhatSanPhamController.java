package liemnguyen.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import liemnguyen.entity.LoaiSanPham;
import liemnguyen.entity.SanPham;
import liemnguyen.service.LoaiSanPhamService;
import liemnguyen.service.SanPhamService;

@Controller
public class DashboardCapNhatSanPhamController {
	@Autowired
	LoaiSanPhamService loaiSanPhamService;
	

	@Autowired
	SanPhamService sanPhamService;
	
	@RequestMapping(value="dashboardcapnhatsanpham",method=RequestMethod.GET)
	public String index(Model model,HttpSession httpSession) {
		if(httpSession.getAttribute("user_name")!=null){
			String user = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user",user);
		}
		
		List<SanPham> listSanPham = sanPhamService.layDanhSachSanPhamLimit(0);
		List<LoaiSanPham> listLoaiSanPham =loaiSanPhamService.listLoaiSanPham();
		model.addAttribute("listSanPham",listSanPham);
		
		int page = 5; //listSanPham/(số sp mỗi page)
		model.addAttribute("tongpage",page);
		
		model.addAttribute("danhmucsp",listLoaiSanPham);
		
		return "dashboard_capnhatsanpham";
	}
}

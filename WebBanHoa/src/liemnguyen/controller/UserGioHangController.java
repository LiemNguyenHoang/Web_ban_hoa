package liemnguyen.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import liemnguyen.entity.GioHangSP;
import liemnguyen.entity.LoaiSanPham;
import liemnguyen.entity.User;
import liemnguyen.service.DonHangService;
import liemnguyen.service.LoaiSanPhamService;
import liemnguyen.service.UserService;

@Controller
@RequestMapping("/")
public class UserGioHangController {
	@Autowired
	LoaiSanPhamService loaiSanPhamService;

	@Autowired
	DonHangService donHangService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="usergiohang",method=RequestMethod.GET)
	public String index(Model model,HttpSession httpSession){
		if(httpSession.getAttribute("user_name")!=null){
			String usr = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user",usr);
			
//			User user = userService.layUser(usr);
//			
//			model.addAttribute("tendangnhapuserdashboard", user.getTenDangNhap());
//			model.addAttribute("hotenuserdashboard", user.getHoTen());
//			model.addAttribute("sodienthoaiuserdashboard", user.getSdt());
//			model.addAttribute("diachiuserdashboard", user.getDiaChi());
			List<LoaiSanPham> listLoaiSanPham = loaiSanPhamService.listLoaiSanPham();
			model.addAttribute("listloaisanpham", listLoaiSanPham);

			if (httpSession.getAttribute("gio_hang") != null) {
				List<GioHangSP> listGioHang = (List<GioHangSP>) httpSession.getAttribute("gio_hang");
				if (listGioHang.size() != 0) {
					model.addAttribute("soluong", listGioHang.size());
					model.addAttribute("listgiohang", listGioHang);
				} else {
					model.addAttribute("soluong", 0);
				}

			} else {
				model.addAttribute("soluong", 0);
			}
			
			
		}
		return "user_giohang";
	}
}

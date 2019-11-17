package liemnguyen.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import liemnguyen.entity.User;
import liemnguyen.service.LoaiSanPhamService;
import liemnguyen.service.UserService;

@Controller
@RequestMapping("/")
public class UserCapNhatController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="usercapnhat",method=RequestMethod.GET)
	public String index(Model model,HttpSession httpSession){
		if(httpSession.getAttribute("user_name")!=null){
			String usr = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user",usr);
			
			User user = userService.layUser(usr);
			
			model.addAttribute("tendangnhapuserdashboard", user.getTenDangNhap());
			model.addAttribute("hotenuserdashboard", user.getHoTen());
			model.addAttribute("sodienthoaiuserdashboard", user.getSdt());
			model.addAttribute("diachiuserdashboard", user.getDiaChi());
			
			
			
		}
		return "user_capnhat";
	}
	
	@RequestMapping(value="usercapnhat",method=RequestMethod.POST)
	public String index1(Model model,HttpSession httpSession,
			@RequestParam("tendangnhap")String tenDangNhap,
			@RequestParam("hoten")String hoTen,
			@RequestParam("sodienthoai")String soDienThoai,
			@RequestParam("diachi")String diaChi){
		
		if(httpSession.getAttribute("user_name")!=null){
			String usr = (String) httpSession.getAttribute("user_name");
			
			User user = userService.layUser(usr);
			// cập nhật password
//			if(!matKhau.equals("") || !nhapLaiMatKhau.equals("")){
//
//				System.out.println("matKhau: "+matKhau);
//				System.out.println("nhapLaiMatKhau: "+nhapLaiMatKhau);
//			}
			user.setHoTen(hoTen);
			user.setSdt(soDienThoai);
			user.setDiaChi(diaChi);
			
			userService.capNhatUser(user);
			
		}
		return "user";
	}
}

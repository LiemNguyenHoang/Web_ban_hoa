package liemnguyen.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import liemnguyen.entity.ChiTietDonHang;
import liemnguyen.entity.DonHang;
import liemnguyen.entity.LoaiSanPham;
import liemnguyen.entity.SanPham;
import liemnguyen.entity.User;
import liemnguyen.service.LoaiSanPhamService;
import liemnguyen.service.SanPhamService;
import liemnguyen.service.UserService;

@Controller
public class DashboardUserController {

	int indexCurrent = 1;
	
	@Autowired
	LoaiSanPhamService loaiSanPhamService;

	@Autowired
	UserService userService;

	@Autowired
	ServletContext context;

	@RequestMapping(value = "dashboarduser", method = RequestMethod.GET)
	public String index(Model model, HttpSession httpSession) {
		if (httpSession.getAttribute("user_name") != null) {
			String user = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user", user);
		}
		model.addAttribute("indexs", 1);
		indexCurrent = 1;
		
		List<User> listUser = userService.layDanhSachSanPhamLimit(0);
		model.addAttribute("listUser", listUser);

		int page = 5; // listSanPham/(số sp mỗi page)
		model.addAttribute("tongpage", page);

			
		return "dashboard_user";
	}
	
	@RequestMapping(value = "dashboarduser", method = RequestMethod.GET,params="index-paging")
	public String index(Model model, HttpSession httpSession,@RequestParam("index-paging")String index) {
		if (httpSession.getAttribute("user_name") != null) {
			String user = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user", user);
		}
		model.addAttribute("indexs", index);
		indexCurrent = Integer.parseInt(index);
		
		List<User> listUser = userService.layDanhSachSanPhamLimit((Integer.parseInt(index)-1)*5);
		model.addAttribute("listUser", listUser);

		int page = 5; // listSanPham/(số sp mỗi page)
		model.addAttribute("tongpage", page);

		
		System.out.println("index: "+index);

		return "dashboard_user";
	}
	
	// Start:
	@RequestMapping(value = "dashboarduser", method = RequestMethod.POST)
	public String index1(Model model, 
						 HttpSession httpSession, 
						 @RequestParam("iduserdashboard") String iduser) {
		if (httpSession.getAttribute("user_name") != null) {
			String user = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user", user);
		}
		model.addAttribute("indexs", indexCurrent);
		
//		List<User> listUser = userService.layDanhSachSanPhamLimit((Integer.parseInt(index)-1)*5);
		List<User> listUser = userService.layDanhSachSanPhamLimit((indexCurrent-1)*5);
		model.addAttribute("listUser", listUser);
		
		int page = 5; // listSanPham/(số sp mỗi page)
		model.addAttribute("tongpage", page);


		User user = userService.layUser(iduser);

		model.addAttribute("iduserdashboard", user.getTenDangNhap());
		model.addAttribute("tenuserdashboard", user.getHoTen());
		model.addAttribute("sdtuserdashboard", user.getSdt());
		model.addAttribute("diachiuserdashboard",user.getDiaChi());
		List<DonHang> listDonHang = (List<DonHang>) user.getDonHangns();
		model.addAttribute("listDonHangUser",listDonHang);
		
		
		
		return "dashboard_user";
	}
	
	
}

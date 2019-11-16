package liemnguyen.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import liemnguyen.entity.DonHang;
import liemnguyen.entity.GioHang;
import liemnguyen.entity.GioHangSP;
import liemnguyen.entity.LoaiSanPham;
import liemnguyen.entity.User;
import liemnguyen.service.DonHangService;
import liemnguyen.service.LoaiSanPhamService;
import liemnguyen.service.UserService;

@Controller
public class GioHangController {
	@Autowired
	LoaiSanPhamService loaiSanPhamService;

	@Autowired
	DonHangService donHangService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/giohang", method = RequestMethod.GET)
	public String index(HttpSession httpSession, ModelMap model) {
		if (httpSession.getAttribute("user_name") != null) {
			String user = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user", user);
		}
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
		return "giohang";
	}

	@RequestMapping(value = "/giohang", method = RequestMethod.POST)
	public String index(@RequestParam String tennguoimua, @RequestParam String sodienthoai, @RequestParam String diachi,
			@RequestParam String ghichu, HttpSession httpSession) {
		
		
		if (httpSession.getAttribute("gio_hang") != null) {
			List<GioHangSP> listGioHang = (List<GioHangSP>) httpSession.getAttribute("gio_hang");

			GioHang gioHang = new GioHang(listGioHang, ghichu, tennguoimua, sodienthoai, diachi);
			
			User user = new User();
			if(httpSession.getAttribute("user_name")!= null){
				user = userService.layUser(httpSession.getAttribute("user_name").toString());
			}
			
			
			donHangService.themDonHang(gioHang,user);
			User user2 = userService.layUser("hoang_ky");
			List<DonHang> list = (List<DonHang>) user2.getDonHangns();
			
			
			// System.out.println(
			// "ten: "+tennguoimua+"\n"
			// + "sdt: "+sodienthoai+"\n"
			// + "diachi: "+diachi+"\n"
			// + "ghichu: "+ghichu);
			// System.out.println("=====");
			// for(int i = 0;i<listGioHang.size();i++){
			// System.out.println("id: "+listGioHang.get(i).getIdSanPham()+" SL:
			// "+listGioHang.get(i).getSoLuong());
			// }
			// System.out.println("*****");
		}

		return "giohang";
	}

}

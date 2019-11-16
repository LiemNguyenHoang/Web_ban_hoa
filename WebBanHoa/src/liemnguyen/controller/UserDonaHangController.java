package liemnguyen.controller;

import java.util.ArrayList;
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
import liemnguyen.entity.GioHangSP;
import liemnguyen.entity.LoaiSanPham;
import liemnguyen.entity.SanPham;
import liemnguyen.entity.Temp_DonHang;
import liemnguyen.entity.User;
import liemnguyen.service.DonHangService;
import liemnguyen.service.LoaiSanPhamService;
import liemnguyen.service.SanPhamService;
import liemnguyen.service.UserService;

@Controller
@RequestMapping("/")
public class UserDonaHangController {
	@Autowired
	LoaiSanPhamService loaiSanPhamService;
	
	@Autowired
	DonHangService donHangService;

	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	UserService userService;

	@Autowired
	ServletContext context;
	
	@RequestMapping(value = "userdonhang", method = RequestMethod.GET)
	public String index(Model model,HttpSession httpSession) {
		if(httpSession.getAttribute("user_name")!=null){
			String usr = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user",usr);
			
			User user = userService.layUser(usr);
			List<DonHang> listDonHang = (List<DonHang>) user.getDonHangns();
			model.addAttribute("listDonHang",listDonHang);
		}
		
		return "user_donhang";
	}
	
	@RequestMapping(value = "userdonhang", method = RequestMethod.POST)
	public String index(Model model, HttpSession httpSession, @RequestParam("iddonhangdashboard") Integer iddonhangsanpham) {
		if (httpSession.getAttribute("user_name") != null) {
			String usr = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user",usr);
			
			User user = userService.layUser(usr);
			List<DonHang> listDonHang = (List<DonHang>) user.getDonHangns();
			model.addAttribute("listDonHang",listDonHang);

		

			DonHang donHang = donHangService.layDonHang(iddonhangsanpham);

			
			model.addAttribute("iddonhangdashboard", donHang.getIdDonHang()+"");
			if(donHang.getUser()==null){
				model.addAttribute("tendangnhapdonhangdashboard", null);
			}else{
				model.addAttribute("tendangnhapdonhangdashboard", donHang.getUser().getTenDangNhap());
			}
			
			model.addAttribute("tennguoimuadonhangdashboard",donHang.getTenNguoiMua());
			model.addAttribute("ngaydonhangdashboard", donHang.getNgayMua());
			model.addAttribute("sodienthoaidonhangdashboard", donHang.getSdt());
			model.addAttribute("diachidonhangdashboard", donHang.getDiaChi());
			model.addAttribute("ghichudonhangdashboard", donHang.getGhiChu());

			List<ChiTietDonHang> listChiTietDonHang = (List<ChiTietDonHang>) donHang.getChiTietDonHangs();
			model.addAttribute("listChiTietDonHang", listChiTietDonHang);
			List<Temp_DonHang> temp_DonHangs = new ArrayList<Temp_DonHang>();
			int tien = 0;
			for(int i = 0;i<listChiTietDonHang.size();i++){
				SanPham sanPham = sanPhamService.laySanPham(listChiTietDonHang.get(i).getIdSanPham());
				Temp_DonHang temp_DonHang = new Temp_DonHang(sanPham.getIdSanPham(), sanPham.getTenSanPham(), listChiTietDonHang.get(i).getSoLuong(),sanPham.getGia());
				temp_DonHangs.add(temp_DonHang);
				tien+=sanPham.getGia()*listChiTietDonHang.get(i).getSoLuong();
			}
			for(int i = 0;i<temp_DonHangs.size();i++){
				System.out.println(temp_DonHangs.get(i).getTenSanPham());
			}
			model.addAttribute("listChiTietDonHang", temp_DonHangs);
			model.addAttribute("tongtiendonhangdashboard", tien);
		}
		
		
		return "user_donhang";
	}
}

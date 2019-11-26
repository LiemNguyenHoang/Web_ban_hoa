package liemnguyen.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import liemnguyen.entity.DonHang;
import liemnguyen.entity.ChiTietDonHang;
import liemnguyen.entity.GioHangSP;
import liemnguyen.entity.LoaiSanPham;
import liemnguyen.entity.SanPham;
import liemnguyen.entity.User;
import liemnguyen.service.LoaiSanPhamService;
import liemnguyen.service.SanPhamService;

@Controller
@RequestMapping("/")
public class TrangChuController {
	/*
	 * Thay đổi số lượng sản phẩm trong mỗi phân trang ở custom.js -> startSP
	 * Không load dc hình ảnh
	 */
	public static int LIMIT_SP = 5;
	
	@Autowired
	SessionFactory factory;
	
	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	LoaiSanPhamService loaisanPhamService;

	
	@RequestMapping(value="home",method=RequestMethod.GET)
	public String index(Model model,HttpSession httpSession) {
		List<LoaiSanPham> listLoaiSanPham = loaisanPhamService.listLoaiSanPham();
		model.addAttribute("listloaisanpham",listLoaiSanPham);
		
		if(httpSession.getAttribute("user_name")!=null){
			String user = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user",user);
		}
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
		List<SanPham> listSanPhams =  sanPhamService.layDanhSachSanPhamMoiNhat();
		model.addAttribute("listSanPham",listSanPhams);

		
		
		return "trangchu";
	}
	
	@RequestMapping(value="home",method=RequestMethod.POST)
	public String index(@RequestParam String email,@RequestParam String noidung) {
		
		
		return "trangchu";
	}
	
	@RequestMapping(value="dangxuat",method=RequestMethod.GET)
	public String logout(Model model,HttpSession httpSession) {
		httpSession.setAttribute("user_name",	null);
		httpSession.setAttribute("gio_hang",	null);
		return "redirect:home.htm";
	}
	
	@RequestMapping(value="quenmatkhau",method=RequestMethod.GET)
	public String logout1() {
		
		return "quenmatkhau";
	}
	
	@Autowired
	JavaMailSender mailer;
	
	@RequestMapping(value="quenmatkhau",method=RequestMethod.POST)
	public String logout2(Model model,
							@RequestParam("tenDangNhap") String tenDangNhap,
							@RequestParam("email")String email) {
		
		String from = email,//"liem.nguyenhoang127@gmail.com",
				to = "n16dccn083@student.ptithcm.edu.vn",
				subject="Quên mật khẩu",
				body="Email: "+email+"\nTên đăng nhập: "+tenDangNhap;
				
		try{
			MimeMessage mail = mailer.createMimeMessage();
			
			MimeMessageHelper helper =  new MimeMessageHelper(mail);
			helper.setFrom(from,from);
			helper.setTo(to);
			helper.setReplyTo(from,from);
			helper.setSubject(subject);
			helper.setText(body, true);
			
			mailer.send(mail);
			System.out.println("Gửi mail OK");
			
		}catch(Exception e){
			
		}
		
		return "xacnhanthanhcong";
	}
	
}


















package liemnguyen.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
		List<SanPham> listSanPhams =  sanPhamService.layDanhSachSanPham(0);
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
	
	public void themSanPham(){
		Session session = factory.getCurrentSession();
		SanPham sp1 = new SanPham();
		sp1.setTenSanPham("SP 1");

		String hql1 = "FROM LoaiSanPham"; // User trong hql khác với User1 trong sql
		Query query1 = session.createQuery(hql1);
		List<LoaiSanPham> listLoaiSP = query1.list();
		
		sp1.setLoaiSanPham(listLoaiSP.get(0));
		session.save(sp1);
	}
	
	public void themLoaiSanPham(){
		Session session = factory.getCurrentSession();
		Set<SanPham> sanPhams = new HashSet<>();

		
		LoaiSanPham loaiSanPham = new LoaiSanPham();
		loaiSanPham.setTenLoai("Loai SP 1");
		loaiSanPham.setSanPhams(sanPhams);


		session.save(loaiSanPham);
		
	}
	
	public void themSanPham_LoaiSP(){
		Session session = factory.getCurrentSession();
		// Start: thêm SanPham và LoaiSanPham
		Set<SanPham> sanPhams = new HashSet<>();
		SanPham sp1 = new SanPham();
		sp1.setTenSanPham("SP 1");
		sanPhams.add(sp1);
		SanPham sp2 = new SanPham();
		sp2.setTenSanPham("SP 2");
		sanPhams.add(sp2);
		SanPham sp3 = new SanPham();
		sp3.setTenSanPham("SP 3");
		sanPhams.add(sp3);
		
		LoaiSanPham loaiSanPham = new LoaiSanPham();
		loaiSanPham.setTenLoai("Loai SP 1");
		loaiSanPham.setSanPhams(sanPhams);

		
		sp1.setLoaiSanPham(loaiSanPham);
		sp2.setLoaiSanPham(loaiSanPham);
		sp3.setLoaiSanPham(loaiSanPham);

		session.save(loaiSanPham);
		session.save(sp1);
		session.save(sp2);
		session.save(sp3);
		
		// End
	}
}

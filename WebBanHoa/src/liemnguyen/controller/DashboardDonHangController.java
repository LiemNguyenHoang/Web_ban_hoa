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
import liemnguyen.entity.LoaiSanPham;
import liemnguyen.entity.SanPham;
import liemnguyen.entity.Temp_DonHang;
import liemnguyen.service.DonHangService;
import liemnguyen.service.LoaiSanPhamService;
import liemnguyen.service.SanPhamService;

@Controller
public class DashboardDonHangController {
	int indexCurrent = 1;
	
	@Autowired
	LoaiSanPhamService loaiSanPhamService;
	
	@Autowired
	DonHangService donHangService;

	@Autowired
	SanPhamService sanPhamService;

	@Autowired
	ServletContext context;
	
	@RequestMapping(value = "dashboarddonhang", method = RequestMethod.GET)
	public String index(Model model, HttpSession httpSession) {
		if (httpSession.getAttribute("user_name") != null) {
			String user = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user", user);
		}
		model.addAttribute("indexs", 1);
		
		List<DonHang> listDonHangs = donHangService.layDanhSachDonHangLimit(0);
		model.addAttribute("listDonHang", listDonHangs);
		
		int page = 5; // listSanPham/(số sp mỗi page)
		model.addAttribute("tongpage", page);

		return "dashboard_donhang";
	}
	
	@RequestMapping(value = "dashboarddonhang", method = RequestMethod.GET,params="index-paging")
	public String index(Model model, HttpSession httpSession,@RequestParam("index-paging")String index) {
		if (httpSession.getAttribute("user_name") != null) {
			String user = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user", user);
		}
		model.addAttribute("indexs", index);
		indexCurrent = Integer.parseInt(index);
		
		List<DonHang> listDonHangs = donHangService.layDanhSachDonHangLimit((Integer.parseInt(index)-1)*5);
		model.addAttribute("listDonHang", listDonHangs);

		int page = 5; // listSanPham/(số sp mỗi page)
		model.addAttribute("tongpage", page);

//		model.addAttribute("danhmucsp", listLoaiSanPham);

		return "dashboard_donhang";
	}
	
	@RequestMapping(value = "dashboarddonhang", method = RequestMethod.POST)
	public String index(Model model, HttpSession httpSession, @RequestParam("iddonhangdashboard") Integer iddonhangsanpham) {
		if (httpSession.getAttribute("user_name") != null) {
			String user = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user", user);
		}
		model.addAttribute("indexs", indexCurrent);
		
		List<DonHang> listDonHang = donHangService.layDanhSachDonHangLimit((indexCurrent-1)*5);
		model.addAttribute("listDonHang", listDonHang);

		int page = 5; // listSanPham/(số sp mỗi page)
		model.addAttribute("tongpage", page);

		DonHang donHang = donHangService.layDonHang(iddonhangsanpham);
//		SanPham sanPham = sanPhamService.laySanPham(idsanpham);
//		model.addAttribute("idsanphamdashboard", idsanpham);
//		model.addAttribute("tensanphamdashboard", sanPham.getTenSanPham());
//		int index = 0;
//		for (int i = 0; i < listLoaiSanPham.size(); i++) {
//			if (listLoaiSanPham.get(i).getId() == sanPham.getLoaiSanPham().getId()) {
//				index = i;
//				break;
//			}
//		}
		
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
		return "dashboard_donhang";
	}
	
	@RequestMapping(value = "dashboardcapnhatdonhang", method = RequestMethod.POST)
	public String index1(Model model, HttpSession httpSession, @RequestParam("iddonhang") Integer iddonhangsanpham) {
		if (httpSession.getAttribute("user_name") != null) {
			String user = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user", user);
		}
		model.addAttribute("indexs", indexCurrent);
		
		List<DonHang> listDonHang = donHangService.layDanhSachDonHangLimit((indexCurrent-1)*5);
		model.addAttribute("listDonHang", listDonHang);

		int page = 5; // listSanPham/(số sp mỗi page)
		model.addAttribute("tongpage", page);

		DonHang donHang = donHangService.layDonHang(iddonhangsanpham);
		donHang.setTinhTrang(true);
		if(donHangService.capNhatDonHang(donHang)){
			System.out.println("update donhang ok");
		}else{

			System.out.println("update donhang not ok");
		}

		return "redirect:dashboarddonhang.htm";
	}
}

package liemnguyen.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

	@Autowired
	ServletContext context;

	@RequestMapping(value = "dashboardcapnhatsanpham", method = RequestMethod.GET)
	public String index(Model model, HttpSession httpSession) {
		if (httpSession.getAttribute("user_name") != null) {
			String user = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user", user);
		}
		model.addAttribute("user", "sa");
		model.addAttribute("indexs", 1);
		
		List<SanPham> listSanPham = sanPhamService.layDanhSachSanPhamLimit(0);
		List<LoaiSanPham> listLoaiSanPham = loaiSanPhamService.listLoaiSanPham();
		model.addAttribute("listSanPham", listSanPham);

		int page = 5; // listSanPham/(số sp mỗi page)
		model.addAttribute("tongpage", page);

		model.addAttribute("danhmucsp", listLoaiSanPham);

		return "dashboard_capnhatsanpham";
	}
	
	@RequestMapping(value = "dashboardcapnhatsanpham", method = RequestMethod.GET,params="index-paging")
	public String index(Model model, HttpSession httpSession,@RequestParam("index-paging")String index) {
		if (httpSession.getAttribute("user_name") != null) {
			String user = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user", user);
		}
		model.addAttribute("user", "asd");
		model.addAttribute("indexs", index);
		
		List<SanPham> listSanPham = sanPhamService.layDanhSachSanPhamLimit((Integer.parseInt(index)-1)*5);
		List<LoaiSanPham> listLoaiSanPham = loaiSanPhamService.listLoaiSanPham();
		model.addAttribute("listSanPham", listSanPham);

		int page = 5; // listSanPham/(số sp mỗi page)
		model.addAttribute("tongpage", page);

		model.addAttribute("danhmucsp", listLoaiSanPham);
		
		System.out.println("index: "+index);

		return "dashboard_capnhatsanpham";
	}

	@RequestMapping(value = "dashboardcapnhatsanpham", method = RequestMethod.POST)
	public String index(Model model, HttpSession httpSession, @RequestParam("idsanphamdashboard") Integer idsanpham) {
		if (httpSession.getAttribute("user_name") != null) {
			String user = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user", user);
		}

		List<SanPham> listSanPham = sanPhamService.layDanhSachSanPhamLimit(0);
		List<LoaiSanPham> listLoaiSanPham = loaiSanPhamService.listLoaiSanPham();
		model.addAttribute("listSanPham", listSanPham);

		int page = 5; // listSanPham/(số sp mỗi page)
		model.addAttribute("tongpage", page);

		model.addAttribute("danhmucsp", listLoaiSanPham);

		SanPham sanPham = sanPhamService.laySanPham(idsanpham);
		model.addAttribute("idsanphamdashboard", idsanpham);
		model.addAttribute("tensanphamdashboard", sanPham.getTenSanPham());
		int index = 0;
		for (int i = 0; i < listLoaiSanPham.size(); i++) {
			if (listLoaiSanPham.get(i).getId() == sanPham.getLoaiSanPham().getId()) {
				index = i;
				break;
			}
		}
		model.addAttribute("loaisanphamdashboard", (index) + "");
		model.addAttribute("giasanphamdashboard", sanPham.getGia());
		model.addAttribute("motasanphamdashboard", sanPham.getMoTa());

		return "dashboard_capnhatsanpham";
	}

	@RequestMapping(value = "dashboardcapnhatsanphamthanhcong", method = RequestMethod.GET)
	public String index1(Model model, HttpSession httpSession) {
		if (httpSession.getAttribute("user_name") != null) {
			String user = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user", user);
		}

		return "dashboard_capnhatthanhcong";
	}

	@RequestMapping(value = "dashboardcapnhatsanphamthanhcong", method = RequestMethod.POST)
	public String index(Model model, HttpSession httpSession, @RequestParam("idsanpham") Integer idsanpham,
			@RequestParam("tensanpham") String tensanpham, @RequestParam("danhmucsanpham") String loaisanpham,
			@RequestParam("giasanpham") String giasanpham, @RequestParam("motasanpham") String motasanpham,
			@RequestParam("hinhanhsanpham") MultipartFile hinhAnhSanPham) {
		if (httpSession.getAttribute("user_name") != null) {
			String user = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user", user);
		}

		System.out.println("id: " + idsanpham);
		System.out.println("ten: " + tensanpham);
		System.out.println("loai: " + loaisanpham);
		System.out.println("gia: " + giasanpham);
		System.out.println("mota: " + motasanpham);

		SanPham sanPham = sanPhamService.laySanPham(idsanpham);
		if (tensanpham != null) {
			sanPham.setTenSanPham(tensanpham);
		}
		if (loaisanpham != null) {
			LoaiSanPham loaiSanPham2 = loaiSanPhamService.layLoaiTheoMa(Integer.parseInt(loaisanpham));
			sanPham.setLoaiSanPham(loaiSanPham2);
		}
		if (giasanpham != null) {
			sanPham.setGia(Integer.parseInt(giasanpham));
		}
		if (motasanpham != null) {
			sanPham.setMoTa(motasanpham);
		}
		if (hinhAnhSanPham.isEmpty()) {
			System.out.println("Không có file");

		} else {
			try {
				String path = context.getRealPath("/resource/image/sanpham/" + hinhAnhSanPham.getOriginalFilename());
				hinhAnhSanPham.transferTo(new File(path));

				sanPham.setHinhAnh(hinhAnhSanPham.getOriginalFilename());

			} catch (Exception e) {
				System.out.println("Lỗi lưu file: " + e.getMessage());
			}
		}
	

		if (sanPhamService.capNhatSanPham(sanPham)) {
			System.out.println("Cập nhật thành công");
		} else {
			System.out.println("Cập nhật thất bại");
		}
		return "dashboard_capnhatthanhcong";
	}

}

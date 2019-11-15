package liemnguyen.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import liemnguyen.entity.DonHang_SanPham;
import liemnguyen.entity.GioHangSP;
import liemnguyen.entity.LoaiSanPham;
import liemnguyen.entity.SanPham;
import liemnguyen.service.LoaiSanPhamService;
import liemnguyen.service.SanPhamService;
import liemnguyen.service.UserService;

@Controller
@RequestMapping("api/")
@SessionAttributes({ "user_name", "gio_hang" })
public class ApiController {
	@Autowired
	SanPhamService sanPhamService;
	@Autowired
	LoaiSanPhamService loaiSanPhamService;
	@Autowired
	UserService userService;

	@Autowired
	ServletContext context;

	@RequestMapping(value = "KiemTraDangNhap", method = RequestMethod.GET)
	@ResponseBody
	public String KiemTraDangNhap(@RequestParam("tendangnhap") String tenDangNhap,
			@RequestParam("matkhau") String matKhau, ModelMap modelMap) {

		int kiemTraDangNhap = userService.kiemTraDangNhap(tenDangNhap, matKhau);
		if(kiemTraDangNhap==2 || kiemTraDangNhap==3){
			modelMap.addAttribute("user_name", tenDangNhap);
		}
		return kiemTraDangNhap + "";
	}
	
	@RequestMapping(value = "KiemTraDangKy", method = RequestMethod.GET)
	@ResponseBody
	public String KiemTraDangKy(@RequestParam("tendangnhap") String tenDangNhap,
			@RequestParam("matkhau") String matKhau,@RequestParam("nhaplaimatkhau") String nhapLaiMatKhau, ModelMap modelMap) {

		int kiemTraDangKy = userService.kiemTraDangKy(tenDangNhap, matKhau, nhapLaiMatKhau);
		if(kiemTraDangKy==2){
			modelMap.addAttribute("user_name", tenDangNhap);
		}
		return kiemTraDangKy + "";
	}

	@RequestMapping(value = "ThemGioHang", method = RequestMethod.GET)
	@ResponseBody
	public String ThemGioHang(@RequestParam int id, @RequestParam int gia, @RequestParam String ten,
			@RequestParam String hinhanh, HttpSession httpSession, ModelMap model) {
		if (httpSession.getAttribute("gio_hang") == null) {
			List<GioHangSP> listGioHang = new ArrayList<>();
			GioHangSP gioHangSP = new GioHangSP(id, 1, gia, ten, hinhanh);

			listGioHang.add(gioHangSP);
			httpSession.setAttribute("gio_hang", listGioHang);
		} else {
			int index = kiemTraGioHang(httpSession, id);
			if (index == -1) {
				List<GioHangSP> listGioHang = (List<GioHangSP>) httpSession.getAttribute("gio_hang");
				GioHangSP gioHangSP = new GioHangSP(id, 1, gia, ten, hinhanh);

				listGioHang.add(gioHangSP);
			} else {
				List<GioHangSP> listGioHang = (List<GioHangSP>) httpSession.getAttribute("gio_hang");
				int soluong = listGioHang.get(index).getSoLuong() + 1;
				listGioHang.get(index).setSoLuong(soluong);
			}
		}

		System.out.println("=====");
		List<GioHangSP> listGioHangs = (List<GioHangSP>) httpSession.getAttribute("gio_hang");
		for (int i = 0; i < listGioHangs.size(); i++) {
			System.out.println(
					"Id: " + listGioHangs.get(i).getIdSanPham() + ":" + "SL: " + listGioHangs.get(i).getSoLuong());
		}

		return listGioHangs.size() + "";
	}

	public int kiemTraGioHang(HttpSession httpSession, int id) {
		List<GioHangSP> listGioHang = (List<GioHangSP>) httpSession.getAttribute("gio_hang");
		for (int i = 0; i < listGioHang.size(); i++) {
			if (id == listGioHang.get(i).getIdSanPham()) {
				return i;
			}
		}
		return -1;
	}

	@RequestMapping(value = "CapNhatGioHang", method = RequestMethod.GET)
	@ResponseBody
	public void capNhatGioHang(HttpSession httpSession, @RequestParam("id") int id,
			@RequestParam("soluongsp") int soluong) {
		// System.out.println(id+":"+soluong);
		if (httpSession.getAttribute("gio_hang") != null) {
			List<GioHangSP> listGioHang = (List<GioHangSP>) httpSession.getAttribute("gio_hang");
			int index = kiemTraGioHang(httpSession, id);
			listGioHang.get(index).setSoLuong(soluong);
		}
	}

	@RequestMapping(value = "XoaGioHang", method = RequestMethod.GET)
	@ResponseBody
	public String xoaGioHang(HttpSession httpSession, @RequestParam("id") int id) {
		if (httpSession.getAttribute("gio_hang") != null) {
			List<GioHangSP> listGioHang = (List<GioHangSP>) httpSession.getAttribute("gio_hang");
			int index = kiemTraGioHang(httpSession, id);
			listGioHang.remove(index);
			
			return listGioHang.size()+"";
		}
		return "0";
	}
	// @RequestMapping(value = "LaySoLuongGioHang", method = RequestMethod.GET)
	// @ResponseBody
	// public String soLuongSanPham(HttpSession httpSession) {
	// if(null!=httpSession.getAttribute("gio_hang")){
	// List<GioHang> listGioHang = (List<GioHang>)
	// httpSession.getAttribute("gio_hang");
	// return listGioHang.size()+"";
	// }
	// return null;
	// }

	// @RequestMapping(value = "LaySanPhamLimit", method =
	// RequestMethod.GET,produces="text/plain; charset=utf-8")
	@RequestMapping(value = "LaySanPhamLimit", method = RequestMethod.GET)
	@ResponseBody
	public String laySanPhamLimit(@RequestParam("spbatdau") int spbatdau) {
		List<SanPham> listSanPham = sanPhamService.layDanhSachSanPhamLimit(spbatdau);
		String html = "";
		for (SanPham sanPham : listSanPham) {
			html += "<tr>";
			html += "<td><div class='checkbox'><label><input type='checkbox' value='" + sanPham.getIdSanPham()
					+ "''></label></div></td>";
			html += "<td>" + sanPham.getTenSanPham() + "</td> ";
			html += "<td>" + sanPham.getLoaiSanPham().getTenLoai() + "</td> ";
			html += "<td>" + sanPham.getGia() + "</td> ";
			html += "</tr>";
		}
		return html;
	}

	@RequestMapping(value = "XoaSanPham", method = RequestMethod.GET)
	@ResponseBody
	public void xoaSanPhamTheoId(@RequestParam("masanpham") int idSP) {
		sanPhamService.xoaSanPhamTheoId(idSP);
	}

	@RequestMapping(value = "UploadFile", method = RequestMethod.POST)
	@ResponseBody
	public void uploadFile(MultipartHttpServletRequest request) {
		String path_file_save = context.getRealPath("/resource/image/sanpham/");
		Iterator<String> listNames = request.getFileNames();
		MultipartFile mpf = request.getFile(listNames.next());

		java.io.File file_save = new java.io.File(path_file_save + mpf.getOriginalFilename());
		try {
			mpf.transferTo(file_save);
			System.out.println(path_file_save);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "ThemSanPham", method = RequestMethod.GET)
	@ResponseBody
	public void themSanPham(@RequestParam("dataJson") String json) {
//		ObjectMapper objectMapper = new ObjectMapper();
//		JsonNode jsonObject;
//		try {
//			jsonObject = objectMapper.readTree(json);
//			String ten = jsonObject.get("tensanpham").toString();
//			int gia = jsonObject.get("giasanpham").asInt();
//			int loai_sp = jsonObject.get("danhmucsanpham").asInt();
//			String hinhAnh = "not image";
//			if (jsonObject.has("hinhanhsanpham")) {
//				hinhAnh = jsonObject.get("hinhanhsanpham").toString();
//			}
//			String moTa = jsonObject.get("motasanpham").toString();
//
//			SanPham sanPham = new SanPham();
//			LoaiSanPham loaiSanPham = new LoaiSanPham();
//			List<LoaiSanPham> listLoaiSanPham = loaiSanPhamService.listLoaiSanPham();
//			for (LoaiSanPham loai : listLoaiSanPham) {
//				if (loai.getId() == loai_sp) {
//					sanPham.setLoaiSanPham(loai);
//					break;
//				}
//			}
//
//			sanPham.setTenSanPham(ten);
//			sanPham.setGia(gia);
//			sanPham.setHinhAnh(hinhAnh);
//			sanPham.setMoTa(moTa);
//
//			// Start: thêm sản pham
//			boolean check = sanPhamService.themSanPham(sanPham);
//			System.out.println(check);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}


		}
//	@RequestMapping(value = "LaySanPhamTheoMa", method = RequestMethod.POST,produces="application/json; charset=utf-8")
	@RequestMapping(value = "LaySanPhamTheoMa",method = RequestMethod.POST)
	@ResponseBody
	public String laySanPham(@RequestParam("idSanPham") int idSanPham) {

		SanPham sanPham = sanPhamService.laySanPham(idSanPham);
		
		
		String json ="";
		json+="ten:"+sanPham.getTenSanPham();
		json+=" ,maloai:"+sanPham.getLoaiSanPham().getId();
		json+=",gia:"+sanPham.getGia();
		json+=",mota:"+sanPham.getMoTa();
		
		// Start:
		LoaiSanPham loaiSanPham = new LoaiSanPham(12, "Khai trương hồng phát");
		ObjectMapper mapper = new ObjectMapper();
		String jsonajax="";
	
			try {
				jsonajax= mapper.writeValueAsString(loaiSanPham);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		
		// End
		
		return json;
	}

}

package liemnguyen.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import liemnguyen.entity.GioHangSP;
import liemnguyen.entity.LoaiSanPham;
import liemnguyen.entity.SanPham;
import liemnguyen.service.LoaiSanPhamService;
import liemnguyen.service.SanPhamService;

@Controller
@RequestMapping("/danhmuc")
public class DanhMucController {
	@Autowired
	LoaiSanPhamService loaiSanPhamService;
	@Autowired
	SanPhamService sanPhamService;
	

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String index(HttpSession httpSession, ModelMap model,@PathVariable int id) {
		if (httpSession.getAttribute("user_name") != null) {
			String user = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user", user);
		}
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
		
		List<LoaiSanPham> listLoaiSanPham = loaiSanPhamService.listLoaiSanPham();
		model.addAttribute("listloaisanpham",listLoaiSanPham);
		
		
		List<SanPham> listSanPhamTheoLoai = sanPhamService.listSanPhamTheoLoai(id);
		model.addAttribute("listsanphamtheoloai",listSanPhamTheoLoai);
		return "danhmuc";
	}
	
}

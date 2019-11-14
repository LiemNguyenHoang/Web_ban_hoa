package liemnguyen.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import liemnguyen.entity.LoaiSanPham;
import liemnguyen.service.LoaiSanPhamService;
import liemnguyen.service.SanPhamService;
import liemnguyen.service.UserService;

@Controller
public class DangNhapController {
	@Autowired
	SanPhamService sanPhamService;

	@Autowired
	LoaiSanPhamService loaiSanPhamService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "dangnhap", method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<LoaiSanPham> listLoaiSanPham = loaiSanPhamService.listLoaiSanPham();
		model.addAttribute("listloaisanpham", listLoaiSanPham);

	

		return "dangnhap";
	}


}

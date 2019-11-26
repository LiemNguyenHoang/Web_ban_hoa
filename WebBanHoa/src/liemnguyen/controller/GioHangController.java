package liemnguyen.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
				return "giohangtrong";
			}

		} else {
			model.addAttribute("soluong", 0);
			return "giohangtrong";
		}
		return "giohang";
	}

	public void addModelGioHang(ModelMap model, GioHang gioHangMA) {
		model.addAttribute("tennguoimuadonhang", gioHangMA.getTenNguoiMua());
		model.addAttribute("sdtdonhang", gioHangMA.getSdt());
		model.addAttribute("diachidonhang", gioHangMA.getDiaChi());
		model.addAttribute("ghichudonhang", gioHangMA.getGhiChu());
	}

	@RequestMapping(value = "/giohang", method = RequestMethod.POST)
	public String index(@ModelAttribute("giohangMA") GioHang gioHangMA, HttpSession httpSession, ModelMap model,
			BindingResult errors) {

		if (httpSession.getAttribute("user_name") != null) {
			String user = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user", user);
		}

		if (httpSession.getAttribute("gio_hang") != null) {
			List<GioHangSP> listGioHang = (List<GioHangSP>) httpSession.getAttribute("gio_hang");
			if (listGioHang.size() != 0) {
				model.addAttribute("soluong", listGioHang.size());
				model.addAttribute("listgiohang", listGioHang);

				String parttern;
				Pattern regex;
				Matcher matcher;
				if (gioHangMA.getTenNguoiMua() == null || gioHangMA.getTenNguoiMua().length() == 0) {
					errors.rejectValue("tenNguoiMua", "giohang", "*Chưa nhập tên");
					addModelGioHang(model, gioHangMA);
				} else {
					System.out.println("Pattern tenNguoiMua: " + gioHangMA.getTenNguoiMua());
					// parttern = "^[a-z|A-Z|\\s]{1,}$";
					parttern = "^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ"
							+ "ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ"
							+ "ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$";
					regex = Pattern.compile(parttern, Pattern.UNICODE_CHARACTER_CLASS);
					matcher = regex.matcher(gioHangMA.getTenNguoiMua());
					if (!matcher.find()) {
						errors.rejectValue("tenNguoiMua", "giohang", "*Dùng chữ hoa, thường");
						addModelGioHang(model, gioHangMA);
					} else {
						errors.rejectValue("tenNguoiMua", "giohang", "");
						if (gioHangMA.getSdt() == null || gioHangMA.getSdt().trim().length() == 0) {
							errors.rejectValue("sdt", "giohang", "*Chưa nhập số điện thoại");
							addModelGioHang(model, gioHangMA);
						} else {
							parttern = "^[0-9]{1,11}$";
							regex = Pattern.compile(parttern);
							matcher = regex.matcher(gioHangMA.getSdt());
							if (!matcher.find()) {
								errors.rejectValue("sdt", "giohang", "Dùng số");
								addModelGioHang(model, gioHangMA);
							} else {
								errors.rejectValue("sdt", "giohang", "");
								if (gioHangMA.getDiaChi() == null || gioHangMA.getDiaChi().trim().length() == 0) {
									errors.rejectValue("diaChi", "giohang", "Chưa nhập địa chỉ");
									addModelGioHang(model, gioHangMA);
								} else {
									
										errors.rejectValue("diaChi", "giohang", "");
										System.out.println("Thêm đơn hàng OK");
										GioHang gioHang = new GioHang(listGioHang, gioHangMA.getGhiChu(),
												gioHangMA.getTenNguoiMua(), gioHangMA.getSdt(), gioHangMA.getDiaChi());

										User user = new User();
										if (httpSession.getAttribute("user_name") != null) {
											user = userService.layUser(httpSession.getAttribute("user_name").toString());
										}

										donHangService.themDonHang(gioHang, user);
										httpSession.setAttribute("gio_hang", null);
										model.addAttribute("soluong", 0);
										model.addAttribute("listgiohang", null);

										return "dathangthanhcong";
									
								}
							}
						}

						
					}

				}

			} else {
				model.addAttribute("soluong", 0);
				model.addAttribute("listgiohang", null);
				return "giohangtrong";
			}
		} else {
			model.addAttribute("soluong", 0);
			model.addAttribute("listgiohang", null);
			return "giohangtrong";
		}

		return "giohang";
	}

}

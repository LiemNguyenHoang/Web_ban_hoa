package liemnguyen.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import liemnguyen.entity.LoaiSanPham;
import liemnguyen.entity.SanPham;

@Controller
@RequestMapping("/")
public class UserController {
	
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String index(Model model, HttpSession httpSession) {
		if (httpSession.getAttribute("user_name") != null) {
			String user = (String) httpSession.getAttribute("user_name");
			
			
			
		}
		

		return "user";
	}
}

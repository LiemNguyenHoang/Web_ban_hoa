package liemnguyen.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import liemnguyen.entity.User;

@Controller
@RequestMapping("/")
public class UserThayDoiMatKhauController {
	@RequestMapping(value="userthaydoimatkhau",method=RequestMethod.GET)
	public String index(Model model,HttpSession httpSession){
		if(httpSession.getAttribute("user_name")!=null){
			String usr = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user",usr);
			

			
		}
		return "user_thaydoimatkhau";
	}
}

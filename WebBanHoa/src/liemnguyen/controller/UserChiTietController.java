package liemnguyen.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class UserChiTietController {
	
	@RequestMapping(value="userchitiet",method=RequestMethod.GET)
	public String index(Model model,HttpSession httpSession){
		if(httpSession.getAttribute("user_name")!=null){
			String user = (String) httpSession.getAttribute("user_name");
			model.addAttribute("user",user);
		}
		
		
		return "user_chitiet";
	}
}

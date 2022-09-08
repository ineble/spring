package com.seven.hotel.user.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.seven.hotel.user.dao.UserRepository;
import com.seven.hotel.user.domain.User;

@Controller
@RequestMapping("/hotel/users") //1차매핑
public class MainController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/list")
	public String showList(Model model) {
		List<User> users =  userRepository.findAll();
		model.addAttribute("memberList", users);
		return "main";
	}
}

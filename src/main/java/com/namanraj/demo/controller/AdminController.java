package com.namanraj.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.namanraj.demo.dao.LoginRepo;
import com.namanraj.demo.dao.StudentRepo;
import com.namanraj.demo.model.Student;
import com.namanraj.demo.model.User;
import com.namanraj.demo.service.Response;

@RestController
public class AdminController 
{
	@Autowired
	StudentRepo studentrepo;
	
	@Autowired
	LoginRepo loginrepo;
	
	@RequestMapping("/admin")
	public ModelAndView adminLogin()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminlogin.jsp");
		return mv;
	}
	
	@RequestMapping("/login-admin")
	public ModelAndView loginSac(@ModelAttribute User user , HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		if(loginrepo.findByUsernameAndPassword(user.getUsername(), user.getPassword()) != null) {
			session.setAttribute("username", user.getUsername());
			mv.setViewName("redirect:/welcomeadmin");
			return mv;
		}
		else {
			mv.setViewName("adminlogin.jsp");
			return mv;
		}
		
	}
	
	@GetMapping("/welcomeadmin")
	public ModelAndView wardenCompList(ModelAndView mv)
	{
		mv.setViewName("welcomeadmin.jsp");
		return mv;
	}
	
	@RequestMapping("/addStudent")
	public ModelAndView adminDashboard() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin.jsp");
		return mv;
	}
	
	@PostMapping("/saveStudent")
	public Response addStudent(@RequestBody Student student) {
		if(studentrepo.findByRoll(student.getRoll()) == null) {
			studentrepo.save(student);
			Response response = new Response("Done", student);
		    return response;
		}
		else {
			Response response = new Response("Failed", student);
		    return response;
		}
		
	}
	
	@GetMapping("/adminlogout")
	public void adminLogout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		response.sendRedirect("/admin");
	}

}

package com.namanraj.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.namanraj.demo.dao.CompliantRepo;
import com.namanraj.demo.dao.StudentRepo;
import com.namanraj.demo.model.Complaint;
import com.namanraj.demo.model.Student;
import com.namanraj.demo.service.NotificationService;

@RestController
public class StudentController 
{
	@Autowired
	StudentRepo studentrepo;
	
	@Autowired
	NotificationService notificationservice;
	
	@Autowired
	CompliantRepo comprepo;
	
	@RequestMapping("/register")
	public ModelAndView registerStudent() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register.jsp");
		return mv;
	}
	
	@RequestMapping("/register-success")
	public ModelAndView registerSuccess(Student student) {
		ModelAndView mv = new ModelAndView();
		String email = student.getEmail();
		if(email.endsWith("@iiitb.org")) {
			if(studentrepo.findByRollAndRoom(student.getRoll(), student.getRoom()) != null) {
				try{
					String password = notificationservice.sendNotification(student);
					studentrepo.updateStudent(password, student.getEmail() , student.getName() , student.getRoll());
					mv.setViewName("registrationsuccess.jsp");
					mv.addObject("roll" , student.getRoll());
				}
				catch(MailException e) {
					System.out.println(e);
				}
				return mv;
			}
			else{
				mv.setViewName("redirect:/register");
				return mv;
			}
		}
		else{
			mv.setViewName("redirect:/register");
			return mv;
		}
		
	}
	
	@RequestMapping("/change")
	public ModelAndView change() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/changepassword.jsp");
		return mv;
	}
	
	@RequestMapping("/changepassword")
	public ModelAndView changePassword(@RequestParam("roll") String roll , @RequestParam("oldpass") String oldpass,
								 @RequestParam("newpass") String newpass) {
		
		ModelAndView mv = new ModelAndView();
		Student student = studentrepo.findByRoll(roll);
		if(student.getPassword().equals(oldpass)) {
			studentrepo.updatePassword(newpass, roll);
			mv.setViewName("redirect:/");
			return mv;
		}
		else {
			mv.setViewName("redirect:/changepassword");
			return mv;
		}
		
	}
	
	@RequestMapping("/forgot")
	public ModelAndView forgot() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/forgotpassword.jsp");
		return mv;
	}
	
	@RequestMapping("/forgotpassword")
	public ModelAndView forgotPassword(@RequestParam("roll") String roll) {
		ModelAndView mv = new ModelAndView();
		if(studentrepo.findByRoll(roll) != null) {
			Student student = studentrepo.findByRoll(roll);
			try{
				String password = notificationservice.sendNotification(student);
				studentrepo.updatePassword(password, roll);
				mv.setViewName("registrationsuccess.jsp");
				mv.addObject("roll" , student.getRoll());
			}
			catch(MailException e) {
				System.out.println(e);
			}
			return mv;
		}
		else{
			mv.setViewName("redirect:/register");
			return mv;
		}
	}
	
	@RequestMapping("/studentlogin")
	public ModelAndView studentLogin()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("studentlogin.jsp");
		return mv;
	}
	
	@RequestMapping(value = "/login-student" , method = RequestMethod.POST)
	public ModelAndView loginStudent(@RequestParam("roll") String roll , @RequestParam("password") String password ,HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		if(studentrepo.findByRollAndPassword(roll, password) != null) {
			session.setAttribute("username", roll);
			mv.setViewName("redirect:/student/"+roll);
			return mv;
		}
		else {
			mv.setViewName("redirect:/studentlogin");
			return mv;
		}
		
	}
	
	
	@RequestMapping("/student/{roll}")
	public ModelAndView studentDashboard(@PathVariable("roll") String roll , HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		if((boolean)session.getAttribute("username").equals(roll)) {
			mv.setViewName("welcomestudent.jsp");
			List<Complaint> list = (List<Complaint>)comprepo.findByRoll(roll);
			System.out.println(list);
			mv.addObject("complaints" ,list);
			return mv;
		}
		else {
			mv.setViewName("redirect:/studentlogin");
			return mv;
		}
		
	}
	
	@GetMapping("/studentlogout")
	public void studentLogout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		response.sendRedirect("/studentlogin");
	}
}

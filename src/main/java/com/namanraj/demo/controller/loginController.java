package com.namanraj.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.namanraj.demo.dao.CompliantRepo;
import com.namanraj.demo.dao.LoginRepo;
import com.namanraj.demo.model.Complaint;
import com.namanraj.demo.model.User;

@RestController
public class loginController 
{
	@Autowired
	private LoginRepo loginrepo;
	
	@Autowired
	private CompliantRepo comprepo;
	
	// SAC Login
	
	@RequestMapping("/saclogin")
	public ModelAndView sac()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("saclogin.jsp");
		return mv;
	}
	
	@RequestMapping("/login-sac")
	public ModelAndView loginSac(@ModelAttribute User user , HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		if(loginrepo.findByUsernameAndPassword(user.getUsername(), user.getPassword()) != null) {
			session.setAttribute("username", user.getUsername());
			mv.setViewName("redirect:/saccomplist");
			return mv;
		}
		else {
			mv.setViewName("saclogin.jsp");
			return mv;
		}
		
	}
	
	@GetMapping("/saccomplist")
	public ModelAndView sacCompList(ModelAndView mv)
	{
		mv.setViewName("welcomesac.jsp");
		List<Complaint> list = (List<Complaint>) comprepo.findBySac();
		mv.addObject("complaints" , list);
		return mv;
	}
	
	// Food Commitee Login
	
	@RequestMapping("/fcomlogin")
	public ModelAndView foodcom()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("foodcomlogin.jsp");
		return mv;
	}
	
	@RequestMapping("/login-fcom")
	public ModelAndView loginFoodCom(@ModelAttribute User user , HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		if(loginrepo.findByUsernameAndPassword(user.getUsername(), user.getPassword()) != null) {
			session.setAttribute("username", user.getUsername());
			mv.setViewName("redirect:/fcomplist");
			return mv;
		}
		else {
			mv.setViewName("foodcomlogin.jsp");
			return mv;
		}
		
	}
	
	@GetMapping("/fcomplist")
	public ModelAndView foodCompList(ModelAndView mv)
	{
		mv.setViewName("welcomefcom.jsp");
		List<Complaint> list = (List<Complaint>) comprepo.findByFcom();
		mv.addObject("complaints" , list);
		return mv;
	}
	
	// Warden Login
	
	@RequestMapping("/wardenlogin")
	public ModelAndView warden()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("wardenlogin.jsp");
		return mv;
	}
	
	@RequestMapping("/login-warden")
	public ModelAndView loginWarden(@ModelAttribute User user  ,HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		if(loginrepo.findByUsernameAndPassword(user.getUsername(), user.getPassword()) != null) {
			session.setAttribute("username", user.getUsername());
			mv.setViewName("redirect:/wardencomplist");
			return mv;
		}
		else {
			mv.setViewName("wardenlogin.jsp");
			return mv;
		}
		
	}
	
	@GetMapping("/wardencomplist")
	public ModelAndView wardenCompList(ModelAndView mv)
	{
		mv.setViewName("welcomewarden.jsp");
		return mv;
	}
	
	@GetMapping("/bhaskaracomplist")
	public ModelAndView lilavatiCompList(ModelAndView mv)
	{
		mv.setViewName("bhaskara.jsp");
		List<Complaint> list = (List<Complaint>) comprepo.findByWardenAndMen();
		mv.addObject("complaints" , list);
		return mv;
	}
	
	@GetMapping("/lilavaticomplist")
	public ModelAndView bhaskaraCompList(ModelAndView mv)
	{
		mv.setViewName("lilavati.jsp");
		List<Complaint> list = (List<Complaint>) comprepo.findByWardenAndWomen();
		mv.addObject("complaints" , list);
		return mv;
	}
	

	// Sport Commitee Login

	
	@RequestMapping("/sportcomlogin")
	public ModelAndView sports()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sportcomlogin.jsp");
		return mv;
	}
	
	@RequestMapping("/login-sportscom")
	public ModelAndView loginSportcom(@ModelAttribute User user , HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		if(loginrepo.findByUsernameAndPassword(user.getUsername(), user.getPassword()) != null) {
			session.setAttribute("username", user.getUsername());
			mv.setViewName("redirect:/sportscomplist");
			return mv;
		}
		else {
			mv.setViewName("sportcomlogin.jsp");
			return mv;
		}
		
	}
	
	@GetMapping("/sportscomplist")
	public ModelAndView sportsCompList(ModelAndView mv)
	{
		mv.setViewName("welcomesportcom.jsp");
		List<Complaint> list = (List<Complaint>) comprepo.findByScom();
		mv.addObject("complaints" , list);
		return mv;
	}
	
	
	
	// Internet Commitee Login

	@RequestMapping("/netcomlogin")
	public ModelAndView internet()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("netcomlogin.jsp");
		return mv;
	}
	
	@RequestMapping("/login-netcom")
	public ModelAndView loginNetcom(@ModelAttribute User user , HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		if(loginrepo.findByUsernameAndPassword(user.getUsername(), user.getPassword()) != null) {
			session.setAttribute("username", user.getUsername());
			mv.setViewName("redirect:/netcomplist");
			return mv;
		}
		else {
			mv.setViewName("netcomlogin.jsp");
			return mv;
		}
		
	}
	
	@GetMapping("/netcomplist")
	public ModelAndView NetCompList(ModelAndView mv)
	{
		mv.setViewName("welcomeNetcom.jsp");
		List<Complaint> list = (List<Complaint>) comprepo.findByNetcom();
		mv.addObject("complaints" , list);
		return mv;
	}
	
	
	
	
/*------  Foodcom Logout -----*/
	
	@GetMapping("/fcomlogout")
	public void foodcomLogout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		response.sendRedirect("/fcomlogin");
	}
	
	/*------  Sac Logout -----*/
	
	@GetMapping("/saclogout")
	public void sacLogout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		response.sendRedirect("/saclogin");
	}
	
	/*------  Warden Logout -----*/
	
	@GetMapping("/wardenlogout")
	public void wardenLogout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		response.sendRedirect("/wardenlogin");
	}
	
	/*------  Sportscom Logout -----*/
	
	@GetMapping("/sportcomlogout")
	public void sportcomLogout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		response.sendRedirect("/sportcomlogin");
	}
	
	/*------  Netcom Logout -----*/
	
	@GetMapping("/netcomlogout")
	public void netcomLogout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		response.sendRedirect("/netcomlogin");
	}

	
	
	
	
	
	
	
	
	

	/*------  About Us   ----*/

	@RequestMapping("/aboutUs")
	public ModelAndView aboutUs()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aboutUs.jsp");
		return mv;
	}
	
	/*------  Feedback -----*/
	
	@RequestMapping("/feedback")
	public ModelAndView feedback()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("feedback.jsp");
		return mv;
	}


}

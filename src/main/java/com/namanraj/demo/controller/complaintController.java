package com.namanraj.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.namanraj.demo.dao.CompliantRepo;
import com.namanraj.demo.dao.StudentRepo;
import com.namanraj.demo.model.Complaint;
import com.namanraj.demo.model.Student;

@RestController
public class complaintController 
{
	@Autowired
	CompliantRepo repo;
	
	@Autowired
	StudentRepo studentrepo;
	
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.jsp");
		return mv;
	}
	
	@RequestMapping("/addComplaint")
	public ModelAndView complaint(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("complaint.jsp");
		return mv;
	}
	
	/* -------  Add Complaint -----------*/
	
	@PostMapping(value="/success" , consumes = {"application/x-www-form-urlencoded"})
	//@JsonFormat(shape=JsonFormat.Shape.ARRAY)

	public ModelAndView addComplaint(@RequestParam("ctype") String ctype ,
									@RequestParam("compbody") String compbody , HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String roll = (String) session.getAttribute("username");
		Student student = studentrepo.findByRoll(roll);
		Complaint complaint  = new Complaint(0, roll, student.getName(), student.getHostel(),
				student.getRoom(), ctype, compbody, "Pending", "No message", sdf.format(new Date(System.currentTimeMillis())));
		repo.save(complaint);	
		mv.setViewName("compconfirmation.jsp");
		mv.addObject("complaint" , complaint);
		return mv;
		
	}
	
	/*-------  Find All Complaints of a Student ------*/
	
//	@GetMapping(path="/complaints")
//	public ModelAndView complaints() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("complaints.jsp");
//		return mv;
//	}
//	
//	@RequestMapping(value="/getComplaints" , method = RequestMethod.POST)
//	public ModelAndView getComplaints(@RequestParam("roll") String roll , @RequestParam("password") String password) {
//		ModelAndView mv = new ModelAndView();
//		if(studentrepo.findByRollAndPassword(roll, password) != null) {
//			mv.setViewName("viewcomplaints.jsp");
//			List<Complaint> list = (List<Complaint>)repo.findByRoll(roll);
//			mv.addObject("complaints" , list);
//			return mv;
//		}
//		else {
//			mv.setViewName("redirect:/complaints");
//			return mv;
//		}
//	}
//	
	/*--------- View and add status in Food Complaint ---------------*/
	
	@GetMapping("/foodcomplaint/{compid}")
	//@ResponseBody
	public ModelAndView foodComplaint(@PathVariable("compid") int compid) {

		Complaint complaint = repo.findById(compid).orElse(null);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewComplaint.jsp");
		mv.addObject("complaint" , complaint);
		return mv;
	}
	
	@GetMapping("foodcomplaint/view/{compid}")
	//@ResponseBody
	public ModelAndView updateFoodComplaint(@PathVariable("compid") int compid , @RequestParam("status") String status ,
			@RequestParam("message") String message) {

		int id = repo.updateComplaint(status , message , compid);
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("redirect:/fcomplist");
		return mv;
	}
	
	/*--------- View and add status in Sac Complaint ---------------*/

	
	@GetMapping("/saccomplaint/{compid}")
	//@ResponseBody
	public ModelAndView sacComplaint(@PathVariable("compid") int compid) {

		Complaint complaint = repo.findById(compid).orElse(null);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sacComplaint.jsp");
		mv.addObject("complaint" , complaint);
		return mv;
	}
	
	@GetMapping("saccomplaint/view/{compid}")
	//@ResponseBody
	public ModelAndView updateSacComplaint(@PathVariable("compid") int compid , @RequestParam("status") String status ,
			@RequestParam("message") String message) {

		int id = repo.updateComplaint(status , message , compid);
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("redirect:/saccomplist");
		return mv;
	}
	
	/*--------- View and add status in Warden Complaint ---------------*/

	
	@GetMapping("/wardencomplaint/{compid}")
	//@ResponseBody
	public ModelAndView wardenComplaint(@PathVariable("compid") int compid) {

		Complaint complaint = repo.findById(compid).orElse(null);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("wardenComplaint.jsp");
		mv.addObject("complaint" , complaint);
		return mv;
	}
	
	@GetMapping("wardencomplaint/view/{compid}")
	//@ResponseBody
	public ModelAndView updateWardenComplaint(@PathVariable("compid") int compid , @RequestParam("status") String status ,
			@RequestParam("message") String message) {

		int id = repo.updateComplaint(status , message , compid);
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("redirect:/wardencomplist");
		return mv;
	}
	
	/*--------- View and add status in Sports Complaint ---------------*/

	
	@GetMapping("/sportcomplaint/{compid}")
	//@ResponseBody
	public ModelAndView sportComplaint(@PathVariable("compid") int compid) {

		Complaint complaint = repo.findById(compid).orElse(null);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sportComplaint.jsp");
		mv.addObject("complaint" , complaint);
		return mv;
	}
	
	@GetMapping("sportcomplaint/view/{compid}")
	//@ResponseBody
	public ModelAndView updateSportComplaint(@PathVariable("compid") int compid , @RequestParam("status") String status ,
			@RequestParam("message") String message) {

		int id = repo.updateComplaint(status , message , compid);
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("redirect:/sportscomplist");
		return mv;
	}
	
	
/*--------- View and add status in Internet Complaint ---------------*/

	
	@GetMapping("/netcomplaint/{compid}")
	public ModelAndView NetComplaint(@PathVariable("compid") int compid) {

		Complaint complaint = repo.findById(compid).orElse(null);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("netComplaint.jsp");
		mv.addObject("complaint" , complaint);
		return mv;
	}
	
	@GetMapping("netcomplaint/view/{compid}")
	public ModelAndView updateNetComplaint(@PathVariable("compid") int compid , @RequestParam("status") String status ,
			@RequestParam("message") String message) {

		int id = repo.updateComplaint(status , message , compid);
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("redirect:/netcomplist");
		return mv;
	}
	
	
	
	
	
	/*---------  Track Status  -------------*/
	@GetMapping("/trackstatus")
	public ModelAndView status() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("trackstatus.jsp");
		return mv;
	}
	
	@GetMapping("/status")
	public ModelAndView trackStatus(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		Complaint getStatus = repo.findById(id).orElse(null);
		if(getStatus == null) {
			mv.setViewName("error.jsp");
			String error = "Id Not found";
			mv.addObject("error" , error);
			return mv;
		}
		else {
			mv.setViewName("viewstatus.jsp");
			mv.addObject("getStatus" , getStatus);
			return mv;
		}
		
		
	}
	
	
	
}	

	
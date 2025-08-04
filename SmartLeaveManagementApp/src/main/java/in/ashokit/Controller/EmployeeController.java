package in.ashokit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.ashokit.Lservice.LeaveService;
import in.ashokit.Service.EmployeeService;
import in.ashokit.entity.Employee;
import in.ashokit.entity.LeaveRequest;

@Controller
@SessionAttributes("loggedUser")
public class EmployeeController {

	 @Autowired
	    private EmployeeService empService;

	    @Autowired
	    private LeaveService leaveService;
	    
	    @GetMapping("/register")
	    public String showRegister(Model model) {
	        model.addAttribute("emp", new Employee());
	        return "register";
	    }
	    
	    
	    @PostMapping("/register")
	    public String register(@ModelAttribute Employee emp, RedirectAttributes ra) {
	        if (empService.registerEmployee(emp)) {
	            ra.addFlashAttribute("msg", "Registration successful!");
	            return "redirect:/login";
	        } else {
	            ra.addFlashAttribute("msg", "Email already exists.");
	            return "redirect:/register";
	        }
	    }
	    
	    @GetMapping("/login")
	    public String showLogin(Model model) {
	        model.addAttribute("emp", new Employee());
	        return "login";
	    }
	    
	    @PostMapping("/login")
	    public String login(@ModelAttribute Employee emp, Model model) {
	        Employee user = empService.login(emp.getEmail(), emp.getPassword());
	        if (user != null) {
	            model.addAttribute("loggedUser", user);
	            if (user.getRole().equals("ADMIN"))
	                return "redirect:/admin";
	            else
	                return "redirect:/dashboard";
	        }
	        model.addAttribute("msg", "Invalid credentials");
	        return "login";
	    }
	    @GetMapping("/dashboard")
	    public String dashboard(@ModelAttribute("loggedUser") Employee emp, Model model) {
	        List<LeaveRequest> list = leaveService.getLeavesByEmployee(emp);
	        model.addAttribute("leaves", list);
	        return "dashboard";
	    }
	    @GetMapping("/admin")
	    public String adminPanel(Model model) {
	        List<LeaveRequest> list = leaveService.getAllLeaves();
	        model.addAttribute("leaves", list);
	        return "admin_panel";
	    }
	    
	    @GetMapping("/update-status")
	    public String updateStatus(@RequestParam Integer id, @RequestParam String status) {
	        leaveService.updateStatus(id, status);
	        return "redirect:/admin";
	    }
	    
	    @GetMapping("/apply")
	    public String applyForm(Model model) {
	        model.addAttribute("leave", new LeaveRequest());
	        return "apply_leave";  
	    }
	    @PostMapping("/apply")
	    public String applyLeave(@ModelAttribute LeaveRequest leave,
	                             @ModelAttribute("loggedUser") Employee emp) {
	        leave.setEmployee(emp);
	        leaveService.applyLeave(leave);
	        return "redirect:/dashboard";
	    }


	    
	
}


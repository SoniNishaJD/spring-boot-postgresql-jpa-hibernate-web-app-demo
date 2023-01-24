package comCustomerManagementSystems.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import comCustomerManagementSystems.cms.entity.Customer;
import comCustomerManagementSystems.cms.service.CustomerService;


@Controller
public class CustomerController {
	@Autowired
	CustomerService service;
	
	@GetMapping("/")
	public String viewHomePage(Model m) {
		m.addAttribute("listCustomer", service.getAllCustomer());
		return "index";
	}
	
	@GetMapping("/showNewCustomerForm")
	public String showNewCustomerForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer" , customer);
		return "entry";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute ("customer") Customer customer){
		service.saveCustomer(customer);
		return "redirect:/";
	}
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id")Integer id, Model model) {
		Customer customer = service.getCustomerById(id);
		model.addAttribute("customer", customer);
		return "edit";
	}
	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable(value = "id")Integer id) {
		this.service.deleteCustomerById(id);
		return "redirect:/";
	}
}

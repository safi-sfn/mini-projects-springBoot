package in.inxod.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.inxod.crm.model.Customer;
import in.inxod.crm.service.CustomerServiceImpl;



/**
 * Controller class for handling customer-related operations in the CRM application.
 */
@Controller
public class CustomerController {

	@Autowired
	private CustomerServiceImpl service;
	
	
	 /**
     * Displays all customers available in the DataBase.
     *
     * @param model Spring MVC model object used to pass data to the view
     * @return the name of the JSP page (customerInfo.jsp) that lists customers in UI
     */
	@GetMapping("/cx-info")
	public String getCxData(Model model) {
		List<Customer> customers = service.getCoustomerInfo();
		model.addAttribute("customer", customers);
		return "customerInfo";
	}
	
	
	

    /**
     * Shows the form for adding a new customer.
     *
     * @param model Spring MVC model to hold the new empty customer object
     * @return the JSP page (showform.jsp) containing the customer registration form
     *         for adding new Customer
     */
	@GetMapping("/show-form")
	public String showForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "showform";
	}
	
	
	
	 /**
     * Handles submission of the customer registration form.
     * It saves a new customer OR updates an existing customer.
     *
     * @param customer the customer object captured from the form
     * @param model    Spring MVC model (not used here but can be helpful for messages)
     * @return redirect to the list of customers page (redirect:/cx-info)
     */
	@PostMapping("/cx-registration")
	public String cxtmerRegistration(@ModelAttribute("customer")Customer customer, Model model) {
		service.registerCustomer(customer);
		return "redirect:/cx-info";
	}
	
	
	
	  /**
     * Fetches a customer by ID and pre-fills the update form with existing data.
     *
     * @param id    the ID of the customer to update
     * @param model Spring MVC model to hold the fetched customer
     * @return the JSP page (updateform.jsp) containing the pre-filled update form
     */
	@GetMapping("/update-data")
	public String updateCxtmer(@RequestParam("cxid")Integer id, Model model) {
		
		Customer cx = service.fetchCustomerById(id);
		model.addAttribute("customer", cx);
		return "updateform";
	}
	
	
	
	 /**
     * Deletes a customer record from the database by ID.
     *
     * @param id the ID of the customer to be deleted
     * @return redirect to the customer list page (redirect:/cx-info)
     */
	@GetMapping("/delete-data")
	public String deleteCxtmer(@RequestParam("cxid")Integer id) {
		service.deleteCustomerReocrd(id);
		
		return "redirect:/cx-info";
	}
	
	
}








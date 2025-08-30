package in.inxod.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.inxod.crm.model.Customer;
import in.inxod.crm.repository.ICustomerRepo;


/**
 * Service implementation for ICustomerService operations.
 * 
 * This class acts as the middle layer between the Controller and Repository.
 * It handles the business logic and communicates with the repository
 * to perform database operations.
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

	// Repository that talks to the database
	private ICustomerRepo repo;

	/**
	 * Setter-based dependency injection for the repository.
	 * Spring will automatically inject the correct implementation at runtime.
	 */
	@Autowired
	public void setRepo(ICustomerRepo repo) {
		this.repo = repo;
	}

	
	/**
	 * Fetch all customer records from the database.
	 * @return List of Customer objects
	 */
	@Override
	public List<Customer> getCoustomerInfo() {
		
		return (List<Customer>)repo.findAll();
	}

	
	
	/**
	 * Save a new customer OR update an existing one in the database.
	 * @param customer the Customer object to be saved/updated
	 */
	@Override
	public void registerCustomer(Customer customer) {
		repo.save(customer);  // save() works for both insert and update

	}
	
	
	

	/**
	 * Fetch a single customer by their ID.
	 *
	 * @param id the customer ID
	 * @return the Customer object if found
	 */
	@Override
	public Customer fetchCustomerById(Integer id) {
		 Optional<Customer> optional = repo.findById(id);
		return optional.get();
		
	}

	
	/**
	 * Delete a customer record by their ID.
	 * @param id the customer ID to delete
	 */
	@Override
	public void deleteCustomerReocrd(Integer id) {
		repo.deleteById(id);
	}

}

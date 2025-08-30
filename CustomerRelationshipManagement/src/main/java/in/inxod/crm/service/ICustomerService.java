package in.inxod.crm.service;

import java.util.List;

import in.inxod.crm.model.Customer;

/**
 * Service layer interface for managing Customer-related operations.
 * 
 * Acts as a contract — implementing classes will provide the actual
 * business logic for these operations.
 */
public interface ICustomerService {
	
	
	 /**
     * Fetch all customer records from the database.
     * @return List of Customer objects
     */
	List<Customer> getCoustomerInfo();
	
	
	/**
     * Save a new customer OR update an existing customer in the database.
     * @param customer the Customer object to be saved/updated
     */
	void registerCustomer(Customer customer);
	
	
	/**
     * Fetch a single customer by their unique ID.
     * 
     * @param id the ID of the customer to fetch
     * @return Customer object if found, otherwise null
     */
	Customer fetchCustomerById(Integer id);
	
	
	/**
     * Delete a customer record from the database using their ID.
     * 
     * @param id the ID of the customer to delete
     */
	void deleteCustomerReocrd(Integer id);
}

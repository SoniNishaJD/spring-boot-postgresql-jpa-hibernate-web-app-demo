package comCustomerManagementSystems.cms.service;

import java.util.List;

import comCustomerManagementSystems.cms.entity.Customer;


public interface CustomerService {

	List<Customer> getAllCustomer();

	void saveCustomer(Customer customer);

	Customer getCustomerById(Integer id);

	void deleteCustomerById(Integer id);

}

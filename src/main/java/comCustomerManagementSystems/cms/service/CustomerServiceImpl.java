package comCustomerManagementSystems.cms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;



import comCustomerManagementSystems.cms.entity.Customer;
import comCustomerManagementSystems.cms.repository.CustomerRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository repositery;
	
	@Override
	public List<Customer> getAllCustomer() {
		return repositery.findAll();
	}

	@Override
	public void saveCustomer(Customer customer) {
		this.repositery.save(customer);
		
	}

	@Override
	public Customer getCustomerById(Integer id) {
		Optional<Customer> optional = repositery.findById(id);
		Customer customer = null;
		if (optional.isPresent()) {
			customer = optional.get();
		} else {
			throw new RuntimeException("Customer not Found for id:: " + id);
		}
		return customer;
	}

	@Override
	public void deleteCustomerById(Integer id) {
		this.repositery.deleteById(id);
		
	}

	

	
}

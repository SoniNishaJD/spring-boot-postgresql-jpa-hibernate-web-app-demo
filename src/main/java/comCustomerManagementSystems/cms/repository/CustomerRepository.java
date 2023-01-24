package comCustomerManagementSystems.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import comCustomerManagementSystems.cms.entity.Customer;




public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}

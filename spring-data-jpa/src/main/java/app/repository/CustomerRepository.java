package app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import app.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}

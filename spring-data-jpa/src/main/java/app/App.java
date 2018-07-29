package app;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import app.entity.Customer;
import app.entity.UserEntity;
import app.repository.CustomerRepository;
import app.repository.UserRepository;

/*
 *	reference : 
 * 		Accessing Data with JPA : https://spring.io/guides/gs/accessing-data-jpa/
 * 		Spring 커맨드라인 기반 예제 from Toby : http://redutan.github.io/2015/09/23/spring-commandline-example
 */
@SpringBootApplication
public class App implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
	@Autowired
	private UserRepository repository;

	@Autowired
	CustomerRepository customerRepository;
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("postConstruct");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("preDestroy");
	}
	
	public static void main(String[] args) {
		System.out.println("START");
		SpringApplication.run(App.class);
		System.out.println("END");
	}
	
	@Override
	public void run(String... args) throws Exception {
		// save a couple of customers
		customerRepository.save(new Customer("Jack", "Bauer"));
		customerRepository.save(new Customer("Chloe", "O'Brian"));
		customerRepository.save(new Customer("Kim", "Bauer"));
		customerRepository.save(new Customer("David", "Palmer"));
		customerRepository.save(new Customer("Michelle", "Dessler"));

		// fetch all customers
		logger.info("Customers found with findAll():");
		logger.info("-------------------------------");
		for (Customer customer : customerRepository.findAll()) {
			logger.info(customer.toString());
		}
		logger.info("");

		// fetch an individual customer by ID
		customerRepository.findById(1L)
			.ifPresent(customer -> {
				logger.info("Customer found with findById(1L):");
				logger.info("--------------------------------");
				logger.info(customer.toString());
				logger.info("");
			});

		// fetch customers by last name
		logger.info("Customer found with findByLastName('Bauer'):");
		logger.info("--------------------------------------------");
		customerRepository.findByLastName("Bauer").forEach(bauer -> {
			logger.info(bauer.toString());
		});

		logger.info("");
	}
	
	public int exec() {
		System.out.println("hello world");
		List<UserEntity> entities = repository.findByLastName("kim");
		return 0;
	}
	
}

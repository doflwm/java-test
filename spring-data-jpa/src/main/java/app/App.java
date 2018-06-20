package app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import app.entity.UserEntity;
import app.repository.UserRepository;

public class App {
	private static final Logger log = LoggerFactory.getLogger(App.class);
	
	@Autowired
	private UserRepository repository;
	
	public int exec() {
		System.out.println("hello world");
		List<UserEntity> entities = repository.findByLastName("kim");
		return 0;
	}
	
	public static void main(String[] args) {
		App app = new App();
		app.exec();
	}

}

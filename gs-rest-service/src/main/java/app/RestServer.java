package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestServer {
    private static final Logger logger = LoggerFactory.getLogger(RestServer.class);

	public static void main(String[] args) {
		logger.debug("START SERVER");
		logger.info("START SERVER");
		logger.trace("START SERVER");
		logger.error("START SERVER");
		
		SpringApplication.run(RestServer.class, args);

	}

}

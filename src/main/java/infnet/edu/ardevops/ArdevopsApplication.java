package infnet.edu.ardevops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ArdevopsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArdevopsApplication.class, args);
	}

}

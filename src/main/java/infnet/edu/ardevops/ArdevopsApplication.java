package infnet.edu.ardevops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import infnet.edu.ardevops.Config.DatabaseInitializer;

@SpringBootApplication
@EnableDiscoveryClient
@Import({ DatabaseInitializer.class })
public class ArdevopsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArdevopsApplication.class, args);
	}

}

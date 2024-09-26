package infnet.edu.ardevops;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import infnet.edu.ardevops.WebClient.WebClientOps;
import reactor.test.StepVerifier;

@SpringBootTest
public class WebClientTests {

    @Test
	void Should_Call_Weather_Api_Through_WebClient() throws InterruptedException
	{
		WebClientOps ops = new WebClientOps();
		WebClient client = ops.CreateWebClient();

		var result = ops.MakeWeatherRequest(client);
		StepVerifier.create(result)
		.consumeNextWith(x -> {
			System.out.println(x);
		})
		.verifyComplete();
		
	}
}

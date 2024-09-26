package infnet.edu.ardevops.WebClient;

import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class WebClientOps {


    public WebClient CreateWebClient() {
        WebClient client = WebClient.builder()
                .baseUrl("https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&hourly=temperature_2m")
                .build();

        return client;
    }

    public Mono<String> MakeWeatherRequest(WebClient client) throws InterruptedException {
            
        return client.get().retrieve().bodyToMono(String.class);
    }
}

package bux.tradingbot.service;


import bux.tradingbot.domain.ProductQuoteEvent;
import bux.tradingbot.main.BuxTradingBotServiceSelfHostApp;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
@SpringBootTest(classes = BuxTradingBotServiceSelfHostApp.class)
@ActiveProfiles("localhost")
public class ProductQuoteIntegrationTest {


    @Disabled
    @Test
    public void givenStreamAPI_whenItsCalled_thenConsumeDataInStream() throws InterruptedException {

        Flux<ProductQuoteEvent> productQuoteEventFlux = WebClient.builder()
                .baseUrl("http://localhost:1000/v1/product-quote/stream")
                .build()
                .get()
                .retrieve()
                .bodyToFlux(ProductQuoteEvent.class);

        productQuoteEventFlux.delayElements(Duration.ofSeconds(2)).subscribe(response -> {
            log.info("response: {}", response);
        });
    }
}

package infnet.edu.ardevops;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import infnet.edu.ardevops.Controllers.VeiculosController;
import reactor.test.StepVerifier;

@SpringBootTest
public class VeiculosControllerTests {

    @Autowired
    private VeiculosController controller;

    @Test
    void Should_Retrieve_List_Of_Veiculo_from_GetAll_Endpoint()
    {
         StepVerifier
        .create(controller.getAll().collectList())
        .consumeNextWith(produtos -> {
            assertTrue(produtos.size() > 0);
        })
        .verifyComplete();
    }
}

package infnet.edu.ardevops;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import infnet.edu.ardevops.Contracts.CreateVeiculoRequest;
import infnet.edu.ardevops.Controllers.VeiculosController;
import infnet.edu.ardevops.Infrastructure.VeiculoRepository;
import infnet.edu.ardevops.Models.Veiculo;
import infnet.edu.ardevops.Models.VeiculoDTO;
import reactor.test.StepVerifier;

@SpringBootTest
public class VeiculosControllerTests {

    @Autowired
    private VeiculosController controller;

    @Autowired 
    private VeiculoRepository _repository;


    @Test
    void Should_Create_Veiculo_And_Insert_On_Database()
    {
        CreateVeiculoRequest veiculo = new CreateVeiculoRequest();
        veiculo.setName("Teste");
        veiculo.setPrice(20000);
        veiculo.setType(2);

        StepVerifier
        .create(controller.create(veiculo))
        .expectNextCount(1)
        .verifyComplete();

    }

    
    @Test
    void Should_Retrieve_Vewiculo_By_Id_From_Database()
    {
        CreateVeiculoRequest veiculo = new CreateVeiculoRequest();
        veiculo.setName("Teste");
        veiculo.setPrice(20000);
        veiculo.setType(2);

        var saved = _repository.save(VeiculoDTO.MapToVeiculoDTO(Veiculo.MapToVeiculo(veiculo)))
        .block();

        StepVerifier
        .create(controller.get(saved.getId()))
        .expectNextCount(1)
        .verifyComplete();

    }

    @Test
    void Should_Retrieve_List_Of_Veiculo_from_GetAll_Endpoint()
    {
         StepVerifier
        .create(controller.getAll().collectList())
        .consumeNextWith(list -> {
            System.out.println(list);
        })
        .verifyComplete();
    }

    @Test
    void Should_Update_Veiculo_On_Database()
    {
        String updatedName = "updated";

        CreateVeiculoRequest veiculo = new CreateVeiculoRequest();
        veiculo.setName("Teste");
        veiculo.setPrice(20000);
        veiculo.setType(2);

        var saved = _repository.save(VeiculoDTO.MapToVeiculoDTO(Veiculo.MapToVeiculo(veiculo)))
        .block();

        saved.setName(updatedName);

        StepVerifier.create(_repository.save(saved))
        .consumeNextWith(x -> assertTrue(x.getName() == updatedName))
        .verifyComplete();

    }

    @Test
    void Should_Delete_Veiculo_On_Database()
    {
        CreateVeiculoRequest veiculo = new CreateVeiculoRequest();
        veiculo.setName("Teste");
        veiculo.setPrice(20000);
        veiculo.setType(2);

        var saved = _repository.save(VeiculoDTO.MapToVeiculoDTO(Veiculo.MapToVeiculo(veiculo)))
        .block();
        
        StepVerifier.create(controller.Delete(saved.getId()))
        .verifyComplete();

    }
}

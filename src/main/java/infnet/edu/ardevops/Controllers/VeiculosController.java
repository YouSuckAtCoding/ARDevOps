package infnet.edu.ardevops.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import infnet.edu.ardevops.Contracts.CreateVeiculoRequest;
import infnet.edu.ardevops.Contracts.UpdateVeiculoRequest;
import infnet.edu.ardevops.Infrastructure.VeiculoRepository;
import infnet.edu.ardevops.Models.Veiculo;
import infnet.edu.ardevops.Models.VeiculoDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class VeiculosController {

    private final static String Status = "/status";
    private final static String Base = "api/";
    private final static String GetAll = Base + "getall";
    private final static String Get = Base + "get";
    private final static String Create = Base + "create";
    private final static String Delete = Base + "delete";
    private final static String Update = Base + "update";

    @GetMapping(Status)
    public ResponseEntity<String> Check() {
        return new ResponseEntity<String>("Serviço ativo", HttpStatus.OK);
    }

    @Autowired
    private VeiculoRepository _VeiculoRepository;

    @GetMapping(GetAll)
    public Flux<VeiculoDTO> getAll() {
        
        return _VeiculoRepository.findAll();
    }
    @GetMapping(Get)
    public Mono<VeiculoDTO> get(@RequestParam Long id) {
        
        return _VeiculoRepository.findById(id);
    }

    @PostMapping(Create)
    public Mono<VeiculoDTO> create(@RequestBody CreateVeiculoRequest request) {

        Veiculo prod = Veiculo.MapToVeiculo(request);
        return _VeiculoRepository.save(VeiculoDTO.MapToVeiculoDTO(prod));
    }

    @DeleteMapping(Delete)
    public Mono<Void> Delete(@RequestParam long id) {
        return _VeiculoRepository.deleteById(id);
    }

    @PutMapping(Update)
    public Mono<VeiculoDTO> Update(@RequestBody UpdateVeiculoRequest request) {

        Veiculo prod = Veiculo.MapToVeiculo(request);
        return _VeiculoRepository.save(VeiculoDTO.MapToVeiculoDTO(prod));
    }
}

package infnet.edu.ardevops.Infrastructure;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import infnet.edu.ardevops.Models.Veiculo;

@Repository
public interface VeiculoRepository extends ReactiveCrudRepository<Veiculo, Long>{

}

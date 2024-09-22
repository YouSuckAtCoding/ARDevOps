package infnet.edu.ardevops.Infrastructure;


import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import infnet.edu.ardevops.Models.VeiculoDTO;

@Repository
public interface VeiculoRepository extends R2dbcRepository<VeiculoDTO, Long>{

}

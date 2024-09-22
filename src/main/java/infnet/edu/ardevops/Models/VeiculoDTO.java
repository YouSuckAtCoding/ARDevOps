package infnet.edu.ardevops.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "veiculo")
public class VeiculoDTO {
   
    @Id    
    private Long id;
    private String name;
    private int type;
    private double price;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public static VeiculoDTO MapToVeiculoDTO(Veiculo request) {
        VeiculoDTO result = new VeiculoDTO();
        result.setId(request.getId());
        result.setName(request.getName());
        result.setPrice(request.getPrice());
        result.setType(request.getType().getValue());

        return result;
    }
}

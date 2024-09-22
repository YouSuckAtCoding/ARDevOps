package infnet.edu.ardevops.Models;

import infnet.edu.ardevops.Contracts.CreateVeiculoRequest;
import infnet.edu.ardevops.Contracts.UpdateVeiculoRequest;
import infnet.edu.ardevops.Enum.VType;


public class Veiculo {

    private int id;
    private String name;
    private VType type;
    private double price;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public VType getType() {
        return type;
    }
    public void setType(VType type) {
        this.type = type;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public static Veiculo MapToVeiculo(CreateVeiculoRequest request) {
        Veiculo result = new Veiculo();
        result.setName(request.getName());
        result.setPrice(request.getPrice());
        result.setType(VType.valueOf(request.getType()));

        return result;
    
    }

    public static Veiculo MapToVeiculo(UpdateVeiculoRequest request) {
        Veiculo result = new Veiculo();
        result.setId(request.getId());
        result.setName(request.getName());
        result.setPrice(request.getPrice());
        result.setType(VType.valueOf(request.getType()));

        return result;
    }
     
}

package infnet.edu.ardevops.Contracts;

public class CreateVeiculoRequest {
    
    private String name;
    private int type;
    private double price;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
  
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

}

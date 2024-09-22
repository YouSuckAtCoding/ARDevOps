package infnet.edu.ardevops.Enum;

import java.util.HashMap;
import java.util.Map;

public enum VType {

    Carro(1),
    Moto(2),
    Caminhao(3),
    Onibus(4);

    private int value;
    private static Map map = new HashMap<>();
    
    private VType(int value) {
            this.value = value;
    }

    public int getValue() {
            return value;
    }

    static {
            for (VType VType : VType.values()) {
                    map.put(VType.value, VType);
            }
    }

    public static VType valueOf(int VType) {
            return (VType) map.get(VType);
    }
}

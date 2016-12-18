package L3;

/**
 * Created by Ivan on 16.12.2016.
 */
public enum FuelType{
    DIESEL("L"),
    PETROL("L"),
    ELECTRIC("kW/h");
    private final String value;
    private FuelType(String s){
        value = s;
    }
}
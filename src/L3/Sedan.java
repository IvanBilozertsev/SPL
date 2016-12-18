package L3;

/**
 * Created by Ivan on 16.12.2016.
 */
public class Sedan extends Car {

    private int trunkVolume;

    public Sedan(String name,FuelType fuelType, int fuelCapacity, int seats, int trunkVolume, int consumption,  int pollution){
        super(name,fuelType,fuelCapacity,seats,consumption, pollution);
        this.trunkVolume = trunkVolume;
    }

    public Sedan(String name,FuelType fuelType, int fuelCapacity, int seats, int trunkVolume, int consumption, int pollution, int kilometerDriven){
        super(name,fuelType,fuelCapacity,seats,consumption, pollution,kilometerDriven);
        this.trunkVolume = trunkVolume;
    }

    public int getTrunkVolume(){return trunkVolume;}
}

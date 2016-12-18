package L3;

/**
 * Created by Ivan on 16.12.2016.
 */
public class Lorry extends Car{

    private int cargoVolume;
    private int maxCargo;
    private boolean isLoaded;

    public Lorry(String name,FuelType fuelType, int fuelCapacity, int seats, int consumption, int maxCargo,  int pollution){
        super(name,fuelType,fuelCapacity,seats,consumption, pollution);
        this.maxCargo = maxCargo;
        isLoaded = false;
    }

    public Lorry(String name,FuelType fuelType, int fuelCapacity, int seats, int consumption, int maxCargo, int pollution, int kilometerDriven){
        super(name,fuelType,fuelCapacity,seats,consumption, pollution,kilometerDriven);
        this.maxCargo = maxCargo;
        isLoaded = false;
    }

    public Lorry(String name,FuelType fuelType, int fuelCapacity, int seats, int consumption, int maxCargo, int pollution, int kilometerDriven, int cargoVolume){
        super(name,fuelType,fuelCapacity,seats,consumption, pollution,kilometerDriven);
        this.maxCargo = maxCargo;
        this.cargoVolume = cargoVolume;
        isLoaded = true;
    }

    public void loadCargo(int cargoVolume){
        this.cargoVolume = cargoVolume;
        isLoaded = true;
    }

    public void unloadCargo(){
        cargoVolume = 0;
        isLoaded = false;
    }

    public boolean isLoaded(){return isLoaded;}

}

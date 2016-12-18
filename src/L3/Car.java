package L3;

/**
 * Created by Ivan on 16.12.2016.
 */
public abstract class Car {

    private String name;
    private FuelType fuelType;
    private int fuelCapacity;
    private int seats;
    private int consumption;
    private int pollution;

    private int currentFuel;
    private int kilometersDriven;

    public Car(String name,FuelType fuelType, int fuelCapacity, int seats, int consumption,  int pollution){
        this.name = name;
        this.fuelType = fuelType;
        this.fuelCapacity = fuelCapacity;
        this.seats = seats;
        this.consumption = consumption;
        this.pollution = pollution;

        currentFuel = 0;
        kilometersDriven = 0;
    }

    public Car(String name,FuelType fuelType, int fuelCapacity, int seats, int consumption,  int pollution, int kilometersDriven){
        this.name = name;
        this.fuelType = fuelType;
        this.fuelCapacity = fuelCapacity;
        this.seats = seats;
        this.consumption = consumption;
        this.pollution = pollution;
        this.kilometersDriven = kilometersDriven;

        currentFuel = 0;
    }

    public String getName(){
        return name;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public int getConsumption() {
        return consumption;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public int getPollution() {
        return pollution;
    }

    public int getSeats() {
        return seats;
    }

    public void refuel(int ammount){
        currentFuel = (currentFuel + ammount) % fuelCapacity;
    }

    public void driveSomewhere(int distance){
        int i = 0;
        while(i < distance & currentFuel > consumption){
            kilometersDriven++;
            currentFuel -= consumption;
            i++;
        }
    }
}

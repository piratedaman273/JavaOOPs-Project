//This class is following Encapsulation OOP criteria because everything a car object represents is under one class
//We won't be needing to add anything related to car class anywhere else except initialisation.
public class Car {
    private String carID;
    private String carModel;
    private String carBrand;
    private double carbasePricePerDay;
    private boolean isAvilable;
    Car(String carID,String carBrand,String carModel, double carbasePricePerDay){
        this.carID = carID;
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.carbasePricePerDay = carbasePricePerDay;
        this.isAvilable = true;
    }
    public String getCarID(){
        return carID;
    }
    public String getCarModel(){
        return carModel;
    }
    public String getCarBrand(){
        return carBrand;
    }
    public double getCarbasePricePerDay(){
        return carbasePricePerDay;
    }
    public boolean getCarAvilability(){
        return isAvilable;
    }

    //In case we rent a car we need to change its avilability to false

    public void RentCar(){
        isAvilable = false;
    }
    //in case a car is returned back so inventory must say its avilable.
    public void ReturnCar(){
        isAvilable = true;
    }

    //We need to calculate rental price for a car based on number of days it has been on rent
    public double CalculateCarRentalPrice(int numberOfDays){
        return carbasePricePerDay*numberOfDays;
    }
}

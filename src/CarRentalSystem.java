//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem(){
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }
    public void AddCar(Car car){
        cars.add(car);
    }
    public void AddCustomer(Customer customer){
        customers.add(customer);
    }
    public void RentCar(Car car, Customer customer,int days){
        if (car.getCarAvilability()){
            car.RentCar();
            rentals.add(new Rental(car,customer,days));
        }
    }
    public void ReturnCar(Car car){
        car.ReturnCar();
        Rental RentalToRemove = null;
        for (Rental rental: rentals){
            if (rental.getCar()==car){
                RentalToRemove = rental;
                break;
            }
        }
        if (RentalToRemove != null){
            rentals.remove(RentalToRemove);
            System.out.println("Car Returned Successfully!!");
        }else{
            System.out.println("No Such Car Has Been Rented Out!!");
        }
    }
    public void MainMenuPage(){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("======Rent a car======");
            System.out.println("1. Rent a car");
            System.out.println("2. Return a car");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1){
                System.out.println("Enter your name: ");
                String CustomerName = sc.nextLine();
                System.out.println("List of available cars: ");
                for (Car car : cars){
                    if (car.getCarAvilability()){
                        System.out.println(car.getCarID()+" "+car.getCarBrand() + " " + car.getCarModel());
                    }
                }
                System.out.println("Enter your CAR ID: ");
                String carID = sc.nextLine();
                System.out.println("Enter no of days for rental ");
                int noOfRentalDays = sc.nextInt();

                Customer custmomer = new Customer(("Cus: "+customers.size()),CustomerName);
                AddCustomer(custmomer);
                Car selectedCar = null;
                for (Car car: cars){
                    if (car.getCarID().equals(carID) && car.getCarAvilability()){
                        selectedCar = car;
                        break;
                    }
                }
                if (selectedCar!=null){
                    //We will calculate car price as per number of days.
                    double totalPrice = selectedCar.CalculateCarRentalPrice(noOfRentalDays);
                    System.out.println("\n========Rental Information========\n");
                    System.out.println("Customer Name: "+ custmomer.GetCustomerName());
                    System.out.println("Car Brand " + selectedCar.getCarBrand());
                    System.out.println("Car Model" + selectedCar.getCarModel());
                    System.out.println("No of rental days " + noOfRentalDays);
                    System.out.println("Price for " + noOfRentalDays + " is "+ totalPrice);

                    System.out.println("Proceed with rent? Y/N ");
                    sc.nextLine();
                    String descision = sc.nextLine();
                    if (descision.equalsIgnoreCase("Y")){
                        RentCar(selectedCar,custmomer,noOfRentalDays);
                        System.out.println("\n Car Rented Successfully");
                    }else{
                        System.out.println("Rental cancelled");
                    }
                }else{
                    System.out.println("Selected car is either not available or wrong choice");
                }
            }
            if(choice == 2){
                System.out.println("========Enter the carID to return ========");
                String carIdToReturn = sc.nextLine();
                Car carToReturn = null;
                for (Car car : cars){
                    if(car.getCarID().equals(carIdToReturn)){
                        carToReturn = car;
                        break;
                    }
                }
                if(carToReturn!=null){
                    Customer customer = null;
                    for (Rental rental:rentals){
                        if (rental.getCar().getCarID().equals(carIdToReturn)){
                            customer = rental.getCustomer();
                            break;
                        }
                    }
                    if (customer!=null){
                        ReturnCar(carToReturn);
                        System.out.println("Your car has been returned successfully: "+customer.GetCustomerName());
                    }else {
                        System.out.println("No such customer exist.");
                    }
                }else{
                    System.out.println("No car has been rented by this car ID: "+carIdToReturn);
                }
            }
            else if (choice==3){
                break;
            }
            else {
                System.out.println("Please enter correct choice");
            }
        }
    }
}
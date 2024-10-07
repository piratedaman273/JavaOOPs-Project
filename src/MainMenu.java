import java.util.List;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        CarRentalSystem crs = new CarRentalSystem();
        Car car1 = new Car("1", "Toyota", "Innova", 1200);
        Car car2 = new Car("2", "Honda", "Civic", 1300);
        Car car3 = new Car("3", "Ford", "Mustang", 1500);
        Car car4 = new Car("4", "BMW", "X5", 1800);
        Car car5 = new Car("5", "Audi", "A4", 1400);
        Car car6 = new Car("6", "Mercedes", "C-Class", 1600);
        Car car7 = new Car("7", "Hyundai", "Creta", 1250);
        Car car8 = new Car("8", "Kia", "Seltos", 1300);
        Car car9 = new Car("9", "Tesla", "Model S", 2000);
        Car car10 = new Car("10", "Nissan", "Altima", 1350);
        Car car11 = new Car("11", "Chevrolet", "Camaro", 1550);
        Car car12 = new Car("12", "Volkswagen", "Passat", 1400);
        Car car13 = new Car("13", "Lexus", "RX 350", 1700);
        Car car14 = new Car("14", "Jaguar", "XF", 1650);
        Car car15 = new Car("15", "Volvo", "XC90", 1900);
        crs.AddCar(car1);
        crs.AddCar(car2);
        crs.AddCar(car3);
        crs.AddCar(car4);
        crs.AddCar(car5);
        crs.AddCar(car6);
        crs.AddCar(car7);
        crs.AddCar(car8);
        crs.AddCar(car9);
        crs.AddCar(car10);
        crs.AddCar(car11);
        crs.AddCar(car12);
        crs.AddCar(car13);
        crs.AddCar(car14);
        crs.AddCar(car15);

        crs.MainMenuPage();
    }
}

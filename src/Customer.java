public class Customer {
    private String CustomerID;
    private String CustomerName;

    Customer(String CustomerID,String CustomerName){
        this.CustomerID = CustomerID;
        this.CustomerName = CustomerName;
    }

    public String GetCustomerId(){
        return CustomerID;
    }
    public String GetCustomerName(){
        return CustomerName;
    }
}

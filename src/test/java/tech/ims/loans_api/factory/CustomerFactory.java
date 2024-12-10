package tech.ims.loans_api.factory;

import tech.ims.loans_api.domain.Customer;

public class CustomerFactory {

    public static Customer build(){
        return new Customer(25, "123.456.789-01", "Teste", 5000.00, "SP");
    }

    public static Customer build(int age){
        return new Customer(age, "123.456.789-01", "Teste", 5000.00, "SP");
    }

    public static Customer build(String location){
        return new Customer(25, "123.456.789-01", "Teste", 5000.00, location);
    }

    public static Customer build(Double income){
        return new Customer(25, "123.456.789-01", "Teste", income, "SP");
    }
}

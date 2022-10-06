import entities.Customer;
import entities.DeliveryCompany;
import entities.Load;
import entities.Order;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Load load = new Load(12,5,4,2);
        Order order1 = new Order(123,load);
        Order order2 = new Order( 12,load);
        Order order3 = new Order(43,load);
        Order order4 = new Order(54,load);
        Order order5 = new Order( 26,load);
        Order order6 = new Order(83,load);
        List<Order> orders1 = new ArrayList<>();
        orders1.add(order1);
        orders1.add(order2);
        orders1.add(order3);
        List<Order> orders2 = new ArrayList<>();
        orders2.add(order4);
        orders2.add(order5);
        orders2.add(order6);
        Customer customer1 = new Customer("Jazgul",orders1);
        Customer customer2 = new Customer("Nurkyz",orders2);
        List<Customer> customers1 = new ArrayList<>();
        customers1.add(customer1);
        customers1.add(customer2);
        DeliveryCompany deliveryCompany1 = new DeliveryCompany("Peaksoft",customers1);
        System.out.println(deliveryCompany1);
    }
}
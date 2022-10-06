package Service;

import entities.Customer;
import entities.DeliveryCompany;
import entities.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class DeliveryCompanyService {
    private List<DeliveryCompany> deliveryCompanies;// = new ArrayList<>();


    public void acceptOrder(String deliveryCompanyName, String customerName, Order order) {
        Optional<DeliveryCompany> optionalDeliveryCompany = deliveryCompanies.stream().filter(x -> x.equals(deliveryCompanyName)).findFirst();
        if (order.getLoad().getHeight() * order.getLoad().getWeight() > DeliveryCompany.MAX_CAPACITY_PER_SQUARE_SANTIMETER) {
            optionalDeliveryCompany.flatMap(x -> x.getCustomers().stream().filter(y -> y.getCustomerName().equals(customerName)).findFirst()).ifPresent(z -> z.setOrder((List<Order>) order));

    public void acceptOrder(String deliveryCompanyName, String customerName, Order order){
        Optional<DeliveryCompany> optionalDeliveryCompany = deliveryCompanies.stream().filter(x-> x.equals(deliveryCompanyName)).findFirst();
        if (order.getLoad().getHeight() * order.getLoad().getLength() * order.getLoad().getWidth() < DeliveryCompany.MAX_CAPACITY_PER_SQUARE_SANTIMETER){
            optionalDeliveryCompany.flatMap(x -> x.getCustomers().stream().filter(y -> y.getCustomerName().equals(customerName)).findFirst()).ifPresent(z -> z.addOrder(order));


        } else {
            System.out.println("Limit exceeded!");

        }
    }

    public void createDeliveryCompany() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of company:");
        deliveryCompanies.add(new DeliveryCompany(scanner.nextLine()));
        System.out.println("This is company that you create:\n" + deliveryCompanies);
    }

    public void getTotalFee( List<Customer> customers ) {
        int count = 0;
        int allTotalFee = 0;
        for (Order order : customers.get(count).getOrder()) {
            allTotalFee += order.getOrderFee();
            count++;
        }
        System.out.println("This is all money's of order:"+allTotalFee);
    }

    public void getCompanyProfit(String company) {
        double d = 0.0;
        for (DeliveryCompany deliveryCompany : deliveryCompanies) {
            if (company.equals(deliveryCompany.getDeliveryCompanyName())) {
                for (Customer customer : deliveryCompany.getCustomers()) {
                    d += customer.getOrder().stream().map(c -> c.getOrderFee()).reduce(0.0, Double::sum);
                }
            }
        }
        System.out.println("This is all profit for company:\n"+d);
    }
}
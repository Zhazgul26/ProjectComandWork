package Service;

import entities.DeliveryCompany;
import entities.Order;

import java.util.List;
import java.util.Optional;


public class DeliveryCompanyService {
    private List<DeliveryCompany> deliveryCompanies;

    public void acceptOrder(String deliveryCompanyName, String customerName, Order order){
        Optional<DeliveryCompany> optionalDeliveryCompany = deliveryCompanies.stream().filter(x-> x.equals(deliveryCompanyName)).findFirst();
        if (order.getLoad().getHeight() * order.getLoad().getWeight() > DeliveryCompany.MAX_CAPACITY_PER_SQUARE_SANTIMETER){
            optionalDeliveryCompany.flatMap(x -> x.getCustomers().stream().filter(y -> y.getCustomerName().equals(customerName)).findFirst()).ifPresent(z -> z.getOrder().stream().filter(w -> w.getLoad().equals(order)).findFirst());
        }
        else {
            System.out.println("Limit exceeded!");
        }
    }
}

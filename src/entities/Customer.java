package entities;

import java.util.List;

public class Customer {
    private String customerName;
    private List<Order> order ;

    public Customer(String customerName, List<Order> order) {
        this.customerName = customerName;
        this.order = order;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

}


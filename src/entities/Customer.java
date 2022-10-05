package entities;

import java.util.List;

public class Customer {
    private double customerName;
    private List<Order> order ;

    public Customer(double customerName, List<Order> order) {
        this.customerName = customerName;
        this.order = order;
    }

    public double getCustomerName() {
        return customerName;
    }

    public void setCustomerName(double customerName) {
        this.customerName = customerName;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }
}


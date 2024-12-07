package com.devsuperior.services;

import com.devsuperior.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private ShippingService shippingService;
    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }
    public double total(Order order){
        double discount = order.getDiscount() / 100.0;
        double totalDiscount = order.getBasic() - (order.getBasic() * discount) ;
        return  totalDiscount + shippingService.shipment(order);
    }
}

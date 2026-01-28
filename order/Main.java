package order;

import order.entities.Order;
import order.repo.OrderManagementSystem;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {


    public static void main(String [] args){
        OrderManagementSystem orderService = OrderManagementSystem.getInstance();
        orderService.addOrder("Yashas", LocalDateTime.now().plus(10, ChronoUnit.DAYS));
        orderService.addOrder("satheesh", LocalDateTime.now().plus(4, ChronoUnit.DAYS));
        orderService.addOrder("Arun", LocalDateTime.now().plus(7, ChronoUnit.DAYS));

        List<Order> allOrders = orderService.getAllOrders();
        for(Order order : allOrders) {
            System.out.println("master " +order.toString());
            if(order.getName().equals("Arun")){
                orderService.updateOrder(order.getId(), null, LocalDateTime.now().plus(6, ChronoUnit.DAYS));
            }
        }


        System.out.println("--------------------------");

        List<Order> allOrders2 = orderService.getAllOrders().stream().sorted(Comparator.comparing(Order::getDeliveryDate)).collect(Collectors.toList());
        for(Order order : allOrders2) {
            System.out.println("" +order.toString());

        }

    }

}

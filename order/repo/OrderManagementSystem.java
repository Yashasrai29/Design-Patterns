package order.repo;

import order.entities.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class OrderManagementSystem {
    private Map<UUID, Order> orders;

    private static OrderManagementSystem instance;

    private OrderManagementSystem(){
        this.orders = new ConcurrentHashMap<>();
    }

    public static synchronized OrderManagementSystem getInstance(){
        if(instance == null){
            synchronized (OrderManagementSystem.class){
                if(instance == null){
                    instance = new OrderManagementSystem();
                }
            }
        }
        return instance;
    }
//  @PostMapping("/order")
    public Boolean addOrder(String name, LocalDateTime deliveryDate){
//        validation if required

        Order order = new Order(name, deliveryDate);
        orders.put(order.getId(), order);
        return true;
    }


//  @PutMapping("/order")
    public Boolean updateOrder(UUID id, String name, LocalDateTime deliveryDate){
        if(orders.containsKey(id)){
            Order order = orders.get(id);
            if(name != null){
                order.setName(name);
            }
            if(deliveryDate != null){
                order.setDeliveryDate(deliveryDate);
            }
        }
        else {
            throw new RuntimeException("Order not found");
        }
        return false;
    }


    //  @GetMapping("/order/{order_id}")
    public Order getOrder(UUID id){
        if(orders.containsKey(id)) {
            return orders.get(id);
        }
        else {
            throw new RuntimeException("Order not found");
        }
    }

    //  @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return new ArrayList<>(orders.values());
    }

    public void deleteOrder(UUID id){
        if(orders.containsKey(id)) {
            orders.remove(id);
        }
        else {
            throw new RuntimeException("Order not found");
        }
    }


}

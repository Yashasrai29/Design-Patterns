package order.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Order {
    private UUID id;

    private String name;

    private LocalDateTime orderAt;

    private LocalDateTime deliveryDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getOrderAt() {
        return orderAt;
    }

    public void setOrderAt(LocalDateTime orderAt) {
        this.orderAt = orderAt;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orderAt=" + orderAt +
                ", deliveryDate=" + deliveryDate +
                '}';
    }

    public Order(String name, LocalDateTime deliveryDate) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.orderAt = LocalDateTime.now();
        this.deliveryDate = deliveryDate;
    }


}

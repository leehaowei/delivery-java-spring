package github.com.leehaowei.deliveryapp.order;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Order {

    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private Long id;
    private Long cartValue;
    private Long deliveryDistance;
    private Long numberOfItems;
    private LocalDate time;

    public Order() {
    }

    public Order(Long id,
                 Long cartValue,
                 Long deliveryDistance,
                 Long numberOfItems,
                 LocalDate time) {
        this.id = id;
        this.cartValue = cartValue;
        this.deliveryDistance = deliveryDistance;
        this.numberOfItems = numberOfItems;
        this.time = time;
    }

    public Order(Long cartValue,
                 Long deliveryDistance,
                 Long numberOfItems,
                 LocalDate time) {
        this.cartValue = cartValue;
        this.deliveryDistance = deliveryDistance;
        this.numberOfItems = numberOfItems;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCartValue() {
        return cartValue;
    }

    public void setCartValue(Long cartValue) {
        this.cartValue = cartValue;
    }

    public Long getDeliveryDistance() {
        return deliveryDistance;
    }

    public void setDeliveryDistance(Long deliveryDistance) {
        this.deliveryDistance = deliveryDistance;
    }

    public Long getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Long numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", cartValue=" + cartValue +
                ", deliveryDistance=" + deliveryDistance +
                ", numberOfItems=" + numberOfItems +
                ", time=" + time +
                '}';
    }
}
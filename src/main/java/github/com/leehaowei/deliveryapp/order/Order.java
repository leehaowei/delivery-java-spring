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
    private Integer cartValue;
    private Integer deliveryDistance;
    private Integer numberOfItems;
    private LocalDate time;
    @Transient
    private int fee;

    public Order() {
    }

    public Order(Long id,
                 Integer cartValue,
                 Integer deliveryDistance,
                 Integer numberOfItems,
                 LocalDate time) {
        this.id = id;
        this.cartValue = cartValue;
        this.deliveryDistance = deliveryDistance;
        this.numberOfItems = numberOfItems;
        this.time = time;
    }

    public Order(Integer cartValue,
                 Integer deliveryDistance,
                 Integer numberOfItems,
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

    public Integer getCartValue() {
        return cartValue;
    }

    public void setCartValue(Integer cartValue) {
        this.cartValue = cartValue;
    }

    public Integer getDeliveryDistance() {
        return deliveryDistance;
    }

    public void setDeliveryDistance(Integer deliveryDistance) {
        this.deliveryDistance = deliveryDistance;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public int getFee() {
        int baseDeliveryFee = 200;
        int surchargeCartValue = cartValueSurcharge(this.cartValue);
        int extraDeliveryAmount = extraDeliveryFee(this.deliveryDistance);
        int surchargeItems = itemSurcharge(this.numberOfItems);
        return baseDeliveryFee + surchargeCartValue + extraDeliveryAmount + surchargeItems;
    }


    private int cartValueSurcharge(Integer cartValue) {
        int surchargeCartValue = 0;
        if (cartValue < 1000) {
            surchargeCartValue = 1000 - cartValue;
        }
        return surchargeCartValue;
    }

    private int extraDeliveryFee(Integer deliveryDistance) {
        int extraDeliveryAmount = 0;
        if (deliveryDistance > 1000) {
            int extraDistance = deliveryDistance - 1000;
            int extraUnit = (int) Math.floor(extraDistance / 500) + 1;
            extraDeliveryAmount = extraUnit * 100;
        }
        return extraDeliveryAmount;
    }

    private int itemSurcharge(Integer numberOfItems) {
        int surchargeItems = 0;
        if (numberOfItems > 4) {
            int extraItems = numberOfItems - 4;
            surchargeItems = extraItems * 500;
        }
        return surchargeItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", cartValue=" + cartValue +
                ", deliveryDistance=" + deliveryDistance +
                ", numberOfItems=" + numberOfItems +
                ", time=" + time +
                ", fee=" + fee +
                '}';
    }

    





}
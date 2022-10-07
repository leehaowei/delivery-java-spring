package github.com.leehaowei.deliveryapp.order;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// Implement business logic
@Service
public class OrderService {

    public List<Order> getOrders() {
        return List.of(
                new Order(
                        1L,
                        790L,
                        2230L,
                        4L,
                        LocalDate.of(2022, Month.OCTOBER, 6)
                )
        );
    }
}

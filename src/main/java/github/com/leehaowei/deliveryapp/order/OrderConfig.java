package github.com.leehaowei.deliveryapp.order;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class OrderConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            OrderRepository orderRepository) {
        return args -> {
            Order orderOne = new Order(
                    790,
                    2230,
                    4,
                    LocalDate.of(2022, Month.OCTOBER, 6)
            );

            Order orderSecond = new Order(
                    880,
                    2580,
                    6,
                    LocalDate.of(2021, Month.AUGUST, 17)
            );

            orderRepository.saveAll(
                    List.of(orderOne, orderSecond)
            );
        };
    }
}

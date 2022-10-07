package github.com.leehaowei.deliveryapp;

import github.com.leehaowei.deliveryapp.order.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class DeliveryApp {

	public static void main(String[] args) {

		SpringApplication.run(DeliveryApp.class, args);
	}

	@GetMapping
	public List<Order> hello() {
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

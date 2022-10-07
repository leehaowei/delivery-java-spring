package github.com.leehaowei.deliveryapp.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ORM Layer
@Repository
public interface OrderRepository
        extends JpaRepository<Order, Long> {
}

package sg.edu.nus.iss.ssf_pizza.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.ssf_pizza.model.Order;

@Repository
public class PizzaRepository {
    //when to use qualifier?
    @Autowired
    @Qualifier("pizza")
    private RedisTemplate<String, Object> template;

    public void save(Order o){
        template.opsForValue().set(o.getId(),o.toJSON().toString());
    }

    //retrieve the order by the orderId string. optional as there might be wrong orderid and null.
    public Optional<Order> get(String orderId){
        String json = (String) template.opsForValue().get(orderId);
        if (null==json||json.trim().length()<=0){
            System.out.println("REPOSITORY GETTING EMPTY");
            System.out.println("REPOSITORY GETTING EMPTY");
            System.out.println("REPOSITORY GETTING EMPTY");
            System.out.println("REPOSITORY GETTING EMPTY");
            return Optional.empty();
        }
        //use the create order object from string method in the Order class
        System.out.println("REPOSITORY HAS SOMETHING");
        return Optional.of(Order.create(json));
    }

}

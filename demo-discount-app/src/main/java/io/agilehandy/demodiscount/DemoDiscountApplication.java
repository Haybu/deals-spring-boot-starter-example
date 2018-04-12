package io.agilehandy.demodiscount;

import io.agilehandy.discounts.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * By: Haytham Mohamed
 */

@SpringBootApplication
public class DemoDiscountApplication {

    @Autowired
    Discount discount;

    public static void main(String[] args) {
        SpringApplication.run(DemoDiscountApplication.class, args);
    }

    @Bean
    public CommandLineRunner clr()  {
        return args -> {
            System.out.println(discount.printDiscountTicket());
        };

    }
}

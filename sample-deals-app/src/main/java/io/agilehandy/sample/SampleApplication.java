package io.agilehandy.sample;

import io.agilehandy.deals.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * By: Haytham Mohamed
 */

@SpringBootApplication
public class SampleApplication {

    @Autowired
    Discount discount;

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }

    @Bean
    public CommandLineRunner clr()  {
        return args -> {
            System.out.println(discount.printDiscountTicket());
        };

    }
}

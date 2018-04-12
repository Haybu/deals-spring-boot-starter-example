package io.agilehandy.discountapp;

import io.agilehandy.discounts.Category;
import io.agilehandy.discounts.Discount;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * By: Haytham Mohamed
 */

@Configuration
@ConditionalOnClass(Discount.class)
@ConditionalOnProperty(name = "daily.discount.category.name")
@EnableConfigurationProperties(DailyDiscountProperties.class)
public class DailyDiscountAutoConfiguration {

    DailyDiscountProperties properties;

    public DailyDiscountAutoConfiguration(DailyDiscountProperties props) {
        properties = props;
    }

   @Bean
   @ConditionalOnMissingBean
    public Discount discount() {
       Category category = new Category(properties.getName());
       return new Discount(category);
   }

}

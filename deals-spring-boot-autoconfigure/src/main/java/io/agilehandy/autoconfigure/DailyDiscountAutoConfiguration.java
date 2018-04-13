package io.agilehandy.autoconfigure;

import io.agilehandy.deals.Category;
import io.agilehandy.deals.Discount;

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
@ConditionalOnProperty(name = "deals.category.name")
@EnableConfigurationProperties(DailyDiscountProperties.class)
public class DailyDiscountAutoConfiguration {

	private final DailyDiscountProperties properties;

	public DailyDiscountAutoConfiguration(DailyDiscountProperties properties) {
		this.properties = properties;
	}

	@Bean
	@ConditionalOnMissingBean
	public Discount discount() {
		Category category = new Category(properties.getName());
		return new Discount(category);
	}

}

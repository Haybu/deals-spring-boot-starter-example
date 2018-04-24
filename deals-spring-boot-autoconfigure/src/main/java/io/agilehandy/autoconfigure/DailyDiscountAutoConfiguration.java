package io.agilehandy.autoconfigure;

import io.agilehandy.deals.Category;
import io.agilehandy.deals.Discount;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.bind.UnboundConfigurationPropertiesException;
import org.springframework.boot.context.properties.source.ConfigurationProperty;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author: Haytham Mohamed
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

	@PostConstruct
	private void validateCategoryNameProperty() {
		if (null == properties.getName()) {
			ConfigurationProperty property =
					new ConfigurationProperty (
							ConfigurationPropertyName.of("deals.category.name")
							, null, null);
			throw new UnboundConfigurationPropertiesException(
					new HashSet<>(Arrays.asList(property)));
		}
	}

}

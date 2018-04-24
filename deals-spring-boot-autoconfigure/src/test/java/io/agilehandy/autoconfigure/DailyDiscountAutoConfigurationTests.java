package io.agilehandy.autoconfigure;

import io.agilehandy.deals.Category;
import io.agilehandy.deals.Discount;
import org.junit.Test;

import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link DailyDiscountAutoConfiguration}.
 * 
 * @author Stephane Nicoll
 */
public class DailyDiscountAutoConfigurationTests {

	private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
			.withConfiguration(AutoConfigurations.of(
					DailyDiscountAutoConfiguration.class));

	@Test
	public void discountIsAutoConfiguredWithProperty() {
		this.contextRunner.withPropertyValues("deals.category.name=some-value")
				.run((context) -> {
					assertThat(context).hasSingleBean(Discount.class);
					assertThat(context.getBean(Discount.class).printDiscountTicket())
							.contains("some-value");
				});
	}

	@Test
	public void discountIsNotAutoConfiguredWithPropertyMissing() {
		this.contextRunner.run((context) -> {
			assertThat(context).doesNotHaveBean(Discount.class);
		});
	}

	@Test
	public void discountAutoConfigurationBacksOffWithUserDefinedDiscount() {
		contextRunner.withUserConfiguration(DiscountConfiguration.class)
				.withPropertyValues("deals.category.name=should-be-ignored")
				.run((context) -> {
					assertThat(context).hasSingleBean(Discount.class);
					assertThat(context.getBean(Discount.class)).isSameAs(
							context.getBean(DiscountConfiguration.class).myDiscount());
				});
	}

	@Configuration
	static class DiscountConfiguration {

		@Bean
		public Discount myDiscount() {

			return new Discount(new Category("test"));
		}

	}

}

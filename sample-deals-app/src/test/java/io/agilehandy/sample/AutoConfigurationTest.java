package io.agilehandy.sample;

import io.agilehandy.autoconfigure.DailyDiscountAutoConfiguration;
import io.agilehandy.deals.Discount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AutoConfigurationTest {


    @Test
    public void defaultServiceBacksOff() {
        ApplicationContextRunner contextRunner = new ApplicationContextRunner()
                .withConfiguration(AutoConfigurations.of(DailyDiscountAutoConfiguration.class));

        contextRunner.withUserConfiguration(DiscountConfiguration.class)
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
            return new Discount(null);
        }

    }
}

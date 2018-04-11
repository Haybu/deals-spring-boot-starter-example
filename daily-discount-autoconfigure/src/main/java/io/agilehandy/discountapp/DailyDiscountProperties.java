package io.agilehandy.discountapp;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * By: Haytham Mohamed
 */

@ConfigurationProperties (prefix = "daily.discount.category")
public class DailyDiscountProperties {
    String name;

    public DailyDiscountProperties() {}

    public DailyDiscountProperties(String n) {name = n;}

    public String getName() { return name;}
    public void setName(String n) {name = n;}
}

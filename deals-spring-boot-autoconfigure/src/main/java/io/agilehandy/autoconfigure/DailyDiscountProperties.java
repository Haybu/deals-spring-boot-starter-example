package io.agilehandy.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * By: Haytham Mohamed
 */

@ConfigurationProperties (prefix = "deals.category")
public class DailyDiscountProperties {

    /**
     * Category name to which a discount will be applied.
     */
    String name;

    public DailyDiscountProperties() {}

    public DailyDiscountProperties(String n) {name = n;}

    public String getName() { return name;}
    public void setName(String n) {name = n;}
}

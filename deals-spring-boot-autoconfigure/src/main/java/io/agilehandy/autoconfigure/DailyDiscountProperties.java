package io.agilehandy.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * By: Haytham Mohamed
 */

@ConfigurationProperties(prefix = "deals.category")
public class DailyDiscountProperties {

	/**
	 * Category name to which a discount will be applied.
	 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	private WebDriver driver;
    private By productName = By.cssSelector(".inventory_item_name");
    private By cartButton = By.id("shopping_cart_container");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public void clickCartButton() {
        driver.findElement(cartButton).click();
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	private WebDriver driver;
    private By productTitle = By.cssSelector(".inventory_item_name");
    private By cartButton = By.id("shopping_cart_container");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductTitle() {
        return driver.findElement(productTitle).getText();
    }

    public void clickCartButton() {
        driver.findElement(cartButton).click();
    }
}

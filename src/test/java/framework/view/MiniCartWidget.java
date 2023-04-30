package framework.view;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MiniCartWidget {

    private SelenideElement checkoutButton = $(".top-cart-btn-checkout");
    private SelenideElement miniCartContent = $(".minicart-items");
    private ElementsCollection productItems = miniCartContent.$$(".product-item");
    private By productItemName = By.cssSelector(".product-item-name");
    private By deleteProductItem = By.cssSelector(".action.delete");

    public MiniCartWidget deleteProductFromCartByName(String name) {
        productItems.find(text(name)).find(deleteProductItem).click();
        $(".action-accept").click();
        return this;
    }

    public boolean checkIfProductInCart(String name) {
        int count = productItems.filter(text(name)).size();
        return count == 1;
    }
}

package framework.view;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ProductCardGridView {

    private SelenideElement productsTable = $(By.xpath("//ol[contains(@class,'product-items')]"));
    private ElementsCollection productCards = productsTable.$$(By.xpath(".//div[@class='product-item-info']"));

    private SelenideElement productCard;
    private By productName = By.xpath(".//strong");
    private By productPrice = By.xpath(".//span[@class='price']");
    private By productSizes = By.xpath(".//div[contains(@id,'option-label-size-')]");
    private By productColors = By.xpath(".//div[contains(@id,'option-label-color-')]");
    private By addToCardButton = By.xpath(".//button[@title='Add to Cart']");

    public ProductCardGridView getCardByName(String productName) {
        productCard = productCards.find(text(productName));

        productCard
                .scrollTo()
                .shouldNotBe(empty);
        return this;
    }

    public ProductCardGridView selectProductSize(String size) {
        productCard.$$(productSizes)
                .find(exactText(size))
                .shouldNotBe(empty)
                .click();
        return this;
    }

    public ProductCardGridView selectProductColor(String color) {
        productCard.$$(productColors)
                .find(match(String.format("Couldn't find the appropriate color section - %s", color), el -> el.getAttribute("aria-label")
                        .equals(color)))
                .click();
        return this;
    }

    public ProductCardGridView clickAddCardToButton() {
        productCard.hover().$(addToCardButton).click();
        return this;
    }

    public ProductCardGridView AddClothesToCart(String productName, String productSize, String productColor) {
        getCardByName(productName);
        selectProductSize(productSize);
        selectProductColor(productColor);
        clickAddCardToButton();
        return this;
    }
}

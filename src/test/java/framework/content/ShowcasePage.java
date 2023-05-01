package framework.content;

import framework.view.HeaderView;
import framework.view.ProductCardGridView;
import io.qameta.allure.Step;

public class ShowcasePage extends BaseContent {
    private ProductCardGridView productCardGridView;

    public ShowcasePage() {
        this.productCardGridView = new ProductCardGridView();
    }

    @Step("Find item by name - {0}")
    public ShowcasePage getCardByName(String productName) {
        productCardGridView
                .getCardByName(productName);
        return this;
    }

    @Step("Add clothes - {0} to cart with size - {1} and color - {2}")
    public ShowcasePage AddClothesToCart(String productName, String productSize, String productColor) {
        productCardGridView
                .getCardByName(productName)
                .selectProductSize(productSize)
                .selectProductColor(productColor)
                .clickAddCardToButton();
        return this;
    }

    @Step("Add clothes size - {0}")
    public ShowcasePage selectProductSize(String size) {
        productCardGridView
                .selectProductSize(size);
        return this;
    }

    @Step("Add clothes color - {0}")
    public ShowcasePage selectProductColor(String color) {
        productCardGridView
                .selectProductColor(color);
        return this;
    }

    @Step("Add clothe to cart")
    public ShowcasePage clickAddCardToButton() {
        productCardGridView
                .clickAddCardToButton();
        return this;
    }
}

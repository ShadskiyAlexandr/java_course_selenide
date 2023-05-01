package test;

import framework.content.BaseContent;
import framework.view.HeaderView;
import framework.view.ProductCardGridView;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Add to cart tests")
@Feature("Cart")
public class CartTest extends BaseTest {

    @BeforeEach
    void addProductToCard() {
        new BaseContent()
                .openMainPage()
                .clickHeaderNavigationButton(HeaderView.Tab.Men)
                .clickLeftNavigationButton("Hoodies & Sweatshirts");

        new ProductCardGridView()
                .getCardByName("Frankie Sweatshirt")
                .selectProductSize("S")
                .selectProductColor("Green")
                .clickAddCardToButton();
    }

    @Test
    @DisplayName("Value of counter label - add a one item")
    void CounterLabelTest() {
        new BaseContent()
                .checkSuccessMessage()
                .checkCounterLabelValue("1");
    }

    @Test
    @DisplayName("Value of counter label - add a few item")
    void CounterLabelTestSeveralItem() {
        new BaseContent()
            .clickHeaderNavigationButton(HeaderView.Tab.Men)
            .clickLeftNavigationButton("Jackets");

        new ProductCardGridView()
                .AddClothesToCart("Montana Wind Jacket", "M", "Red");

        new BaseContent()
                .checkCounterLabelValue("2");
    }

    @Test
    @DisplayName("Delete product from card")
    void DeleteFromCartTest() {
        new BaseContent()
                .clickHeaderNavigationButton(HeaderView.Tab.Gear)
                .clickLeftNavigationButton("Watches");

        new ProductCardGridView()
                .getCardByName("Clamber Watch")
                .clickAddCardToButton();

        new BaseContent()
                .openMiniCartWidget()
                .deleteProductFromMiniCartByName("Clamber Watch")
                .checkCounterLabelValue("1");
    }
}

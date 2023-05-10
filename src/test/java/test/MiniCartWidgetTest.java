package test;

import framework.content.BaseContent;
import framework.content.ShowcasePage;
import framework.view.HeaderView;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Mini cart widget tests")
@Feature("Cart")
public class MiniCartWidgetTest extends BaseTest {

    @BeforeEach
    void addProductToCard() {
        new ShowcasePage()
                .openMainPage()
                .clickHeaderNavigationButton(HeaderView.Tab.Men)
                .clickLeftNavigationButton("Hoodies & Sweatshirts");

        new ShowcasePage()
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
    void CounterLabelSeveralItemTest() {
        new ShowcasePage()
            .clickHeaderNavigationButton(HeaderView.Tab.Men)
            .clickLeftNavigationButton("Jackets");

        new ShowcasePage()
                .AddClothesToCart(
                        "Montana Wind Jacket",
                        "M",
                        "Red")
                .checkCounterLabelValue("2");
    }

    @Test
    @DisplayName("Delete product from card")
    void DeleteFromCartTest() {
        new ShowcasePage()
                .clickHeaderNavigationButton(HeaderView.Tab.Gear)
                .clickLeftNavigationButton("Watches");

        new ShowcasePage()
                .getCardByName("Clamber Watch")
                .clickAddCardToButton()
                .openMiniCartWidget()
                .deleteProductFromMiniCartByName("Clamber Watch")
                .checkCounterLabelValue("1");
    }
}

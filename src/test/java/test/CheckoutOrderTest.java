package test;

import framework.content.*;
import framework.view.HeaderView;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Proceed to checkout tests")
@Feature("Order")
public class CheckoutOrderTest extends BaseTest{

    @BeforeEach
    void addProductToCard() {
        new BaseContent()
                .openMainPage()
                .clickHeaderNavigationButton(HeaderView.Tab.Men)
                .clickLeftNavigationButton("Hoodies & Sweatshirts");

        new ShowcasePage()
                .AddClothesToCart(
                        "Frankie Sweatshirt",
                        "S",
                        "Green")
                .checkCounterLabelValue("1")
                .openMiniCartWidget()
                .clickProceedToCheckout();
    }

    @Test
    @DisplayName("Complete the order")
    void completeOrderTest() {
        new ShippingAddressPage()
                .sendFormWithRandomData();

        new PaymentMethodPage()
                .clickPlaceOrderButton();

        new FinishPurchasePage()
                .checkTitlePage("Thank you for your purchase!");
    }
}

package framework.view;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class PaymentMethodView {

    private SelenideElement placeOrderButton = $(".actions-toolbar .checkout");

    public PaymentMethodView clickPlaceOrderButton() {
        placeOrderButton
                .shouldBe(Condition.visible, Duration.ofSeconds(5))
                .shouldBe(Condition.enabled, Duration.ofSeconds(5))
                .click();
        return this;
    }
}

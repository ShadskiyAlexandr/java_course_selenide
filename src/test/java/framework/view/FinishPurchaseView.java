package framework.view;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FinishPurchaseView {

    private SelenideElement pageTitle = $("[data-ui-id='page-title-wrapper']");

    public FinishPurchaseView checkTitlePage(String text) {
        pageTitle
                .shouldBe(visible)
                .shouldHave(text(text));
        return this;
    }
}

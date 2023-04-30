package framework.content;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import framework.view.HeaderView;
import framework.view.LeftNavigationView;
import framework.view.MiniCartWidget;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseContent {

    private LeftNavigationView leftNavigation;
    private HeaderView header;
    private MiniCartWidget miniCartWidget;

    public BaseContent() {
        this.leftNavigation = new LeftNavigationView();
        this.header = new HeaderView();
        this.miniCartWidget = new MiniCartWidget();
    }

    private SelenideElement pageHeader = $("[data-ui-id='page-title-wrapper']");

    @Step("Open the Main page")
    public BaseContent openMainPage() {
        open("");
        return this;
    }

    @Step("Click by {0} button into the header navigation panel")
    public BaseContent clickHeaderNavigationButton(HeaderView.Tab tab) {
        header.clickButton(tab);
        return this;
    }

    @Step("Click by {0} button into the left navigation panel")
    public BaseContent clickLeftNavigationButton(String categoryName) {
        leftNavigation.clickLeftNavLink(categoryName);
        return this;
    }

    @Step("Open mini cart widget")
    public BaseContent openMiniCartWidget() {
        header.openMiniCart();
        return this;
    }

    @Step("Check counter label")
    public BaseContent checkCounterLabelValue(String value) {
        header.checkCounterLabelValue(value);
        return this;
    }

    @Step("Check page name")
    public BaseContent checkPageName(String expectedName) {
        pageHeader.shouldBe(Condition.visible);
        pageHeader.shouldHave(text(expectedName));
        return this;
    }

    @Step("Delete item from mini cart")
    public BaseContent deleteProductFromMiniCartByName(String productName) {
        boolean deleted = miniCartWidget
                .deleteProductFromCartByName(productName)
                .checkIfProductInCart(productName);

        assertTrue(deleted, String.format("The product %s wasn't deleted", productName));
        return this;
    }

}
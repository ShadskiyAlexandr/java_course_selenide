package framework.view;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HeaderView {

    private SelenideElement navigationPanel = $(By.xpath("//nav/ul"));

    private SelenideElement counterLabel = $(".counter-number");
    private SelenideElement counterLoader = $("._block-content-loading");

    public HeaderView openMiniCart() {
        counterLabel.click();
        return this;
    }

    public HeaderView checkCounterLabelValue(String value) {
        counterLoader.shouldNot(visible, Duration.ofSeconds(2));
        counterLabel.shouldHave(text(value));
        return this;
    }

    public HeaderView clickButton(Tab tab) {
        getButton(tab).click();
        return this;
    }

    private SelenideElement getButton(Tab tab) {
        int order = tab.ordinal() + 1;
        String xPath = String.format("li[%d]", order);

        return navigationPanel.$(By.xpath(xPath));
    }

    @Getter
    @AllArgsConstructor
    public enum Tab {
        News("What's New"),
        Women("Women"),
        Men("Men"),
        Gear("Gear"),
        Training("Training"),
        Sale("Sale");

        private String btnName;
    }
}

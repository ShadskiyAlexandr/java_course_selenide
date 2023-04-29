package framework.view;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HeaderNavView {

    private SelenideElement navigationPanel = $(By.xpath("//nav/ul"));


    public HeaderNavView clickButton(Tab tab) {
        getButton(tab).click();
        return this;
    }

    public HeaderNavView openMainPae() {
        open("");
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

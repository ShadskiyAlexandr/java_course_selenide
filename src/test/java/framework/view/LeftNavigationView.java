package framework.view;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LeftNavigationView {

    private SelenideElement navigationPanel = $(By.xpath("//div[@class='categories-menu']"));
    private ElementsCollection navigationLinks = navigationPanel.$$(By.xpath("//li"));
    private ElementsCollection navigationTitles = navigationPanel.$$(By.xpath("//strong"));

    public void clickLeftNavLink (String linkName) {
        getNavLinkByName(linkName).click();
    }

    private SelenideElement getNavLinkByName (String linkName) {
        return navigationPanel.$(By.xpath(String.format(".//a[text()='%s']", linkName)));
    }
}

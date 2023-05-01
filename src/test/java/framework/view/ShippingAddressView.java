package framework.view;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import models.ShippingAddressModel;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class ShippingAddressView {

    private SelenideElement loader = $(".loader");
    private SelenideElement checkoutForm = $("#checkout");
    private SelenideElement emailAddress = $("#customer-email");
    private SelenideElement state = $("[name='region_id']");
    private SelenideElement country = $("[name='country_id']");
    private SelenideElement shippingMethodForm = $("#co-shipping-method-form");
    private ElementsCollection shippingMethodRadios = shippingMethodForm.$$("input");

    private SelenideElement nextButton = $(".button");

    public ShippingAddressView fillOutFormWithRandomData(ShippingAddressModel data) {
        checkoutForm.shouldBe(Condition.visible, Duration.ofSeconds(10));

        country.selectOption(1);

        emailAddress.setValue(data.getEmailAddress());

        for(formTextFields field : formTextFields.values()) {
            switch (field) {
                case postcode:
                    getTextFieldElement(field).setValue(data.getPostcode());
                    break;
                case firstName:
                    getTextFieldElement(field).setValue(data.getFirstName());
                    break;
                case lastName:
                    getTextFieldElement(field).setValue(data.getLastName());
                    break;
                case company:
                    getTextFieldElement(field).setValue(data.getCompany());
                    break;
                case street:
                    getTextFieldElement(field).setValue(data.getStreet());
                    break;
                case houseNumber:
                    getTextFieldElement(field).setValue(data.getHouseNumber());
                    break;
                case apartmentNumber:
                    getTextFieldElement(field).setValue(data.getApartmentNumber());
                    break;
                case city:
                    getTextFieldElement(field).setValue(data.getCity());
                    break;
                case phone:
                    getTextFieldElement(field).setValue(data.getPhone());
                    break;
            }
        }

        loader.shouldBe(Condition.visible, Duration.ofSeconds(5));
        loader.shouldNotBe(Condition.visible, Duration.ofSeconds(5));
        shippingMethodRadios.first().click();
        return this;
    }

    public ShippingAddressView clickNextButton() {
        nextButton
                .shouldBe(Condition.enabled, Duration.ofSeconds(10))
                .click();
        return this;
    }

    private SelenideElement getTextFieldElement (formTextFields field) {
        String selector = String.format("//div[@name='shippingAddress%s']//input", field.getSelector());
        return $(By.xpath(selector));
    }

    @Getter
    @AllArgsConstructor
    enum formTextFields {
        city(".city"),
        postcode(".postcode"),
        firstName(".firstname"),
        lastName(".lastname"),
        company(".company"),
        street(".street.0"),
        houseNumber(".street.1"),
        apartmentNumber(".street.2"),
        phone(".telephone");

        private String selector;
    }

}

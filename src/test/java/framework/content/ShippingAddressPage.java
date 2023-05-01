package framework.content;

import framework.view.ShippingAddressView;
import helpers.RandomShippingAddress;
import io.qameta.allure.Step;

public class ShippingAddressPage extends BaseContent{

    private ShippingAddressView shippingAddressView;

    public ShippingAddressPage() {
        this.shippingAddressView = new ShippingAddressView();
    }

    @Step("Fill out address from with Random data")
    public ShippingAddressPage sendFormWithRandomData() {
        shippingAddressView
                .fillOutFormWithRandomData(
                        RandomShippingAddress.getRandomAddressData())
                .clickNextButton();
        return this;
    }
}

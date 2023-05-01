package framework.content;

import framework.view.PaymentMethodView;

public class PaymentMethodPage {

    private PaymentMethodView paymentMethodView;

    public PaymentMethodPage() {
        this.paymentMethodView = new PaymentMethodView();
    }

    public PaymentMethodPage clickPlaceOrderButton() {
        paymentMethodView.clickPlaceOrderButton();
        return this;
    }
}

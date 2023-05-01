package framework.content;

import framework.view.FinishPurchaseView;
import io.qameta.allure.Step;

public class FinishPurchasePage {

    private FinishPurchaseView finishPurchaseView;

    public FinishPurchasePage() {
        this.finishPurchaseView = new FinishPurchaseView();
    }

    @Step("Check page title. Title should be - {0}")
    public FinishPurchasePage checkTitlePage(String text) {
        finishPurchaseView.checkTitlePage(text);
        return this;
    }
}

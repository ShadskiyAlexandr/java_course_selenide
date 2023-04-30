package test;

import framework.content.BaseContent;
import framework.view.HeaderView;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Header navigation tests")
@Feature("Navigation")
public class NavigationTest extends BaseTest{

    static HeaderView.Tab[] tabProvider() {
        return HeaderView.Tab.values();
    }

    @ParameterizedTest(name = "{index} -> Open {0} page")
    @MethodSource("tabProvider")
    @DisplayName("Click header navigation panel")
    void checkNavigation(HeaderView.Tab tab){
        new BaseContent()
                .openMainPage()
                .clickHeaderNavigationButton(tab)
                .checkPageName(tab.getBtnName());
    }
}

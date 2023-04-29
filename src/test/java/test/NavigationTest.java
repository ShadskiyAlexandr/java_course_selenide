package test;

import framework.view.HeaderNavView;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Check header navigation")
@Feature("Navigation")
public class NavigationTest extends BaseTest{

    static HeaderNavView.Tab[] tabProvider() {
        return HeaderNavView.Tab.values();
    }

    @ParameterizedTest(name = "{index} -> Open {0} page")
    @MethodSource("tabProvider")
    @DisplayName("Click header navigation panel")
    void checkNavigation(HeaderNavView.Tab tab){
        new HeaderNavView()
                .openMainPae()
                .clickButton(tab);
    }
}

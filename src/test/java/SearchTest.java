import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Keys;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SearchTest {
    @Owner("vakavava")
    @Feature("Отправка почты")
    @MethodSource("incorrectCredentials")
    @ParameterizedTest(name = "{0}")
    @DisplayName("Отправка почты")
    public void shouldNotSendEmail(String type, String searchData){
        step("Открыть главную страницу", () -> {
            open("http://automationpractice.com/index.php");
        });
        step("Ввести в поле ввода данные и нажать enter", () -> {
            TestPages.emailPage.inputEmail()
                    .sendKeys(searchData + Keys.ENTER);
        });
        step("Проверить, что на странице появилось уведомление о невалидности почты", () -> {
            TestPages.emailPage.alertWrongEmail()
                    .shouldBe(visible);
        });

    }
    static Stream<Arguments> incorrectCredentials() {
        return Stream.of(
                arguments(
                        "неверного формата",
                        "bkevr"
                ),

                arguments(
                        "пустой",
                        " "
                )
        );
    }
}

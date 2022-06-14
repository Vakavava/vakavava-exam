import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

public class CardTest {

    @Owner("vakavava")
    @Feature("Быстрая корзина")
    @Story("Успешное добавление товара в корзину через быструю корзину")
    @Test
    @DisplayName("Добавление товара через быструю корзину")
    public void shouldAddProductFromFastCard(){
        step("Открыть cтраницу с товарами", () -> {
            open("http://automationpractice.com/index.php");
        });
        step("Навести курсор на название товара", () -> {
            TestPages.cardPage.nameOfProduct()
                    .hover();
        });
        step("Нажать на кнопку добавления в корзину", () -> {
            TestPages.cardPage.buttonAddFastCart()
                    .click();
        });
        sleep(3000);
        step("Проверить, что появился попап об успешном добавлении товара", () -> {
            TestPages.cardPage.popupSuccessAddToCart()
                    .shouldBe(Condition.visible);
        });
    }
}

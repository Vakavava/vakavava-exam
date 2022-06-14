package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CardPage {
    public SelenideElement buttonAddFastCart() {
        return $(byText("Add to cart")).as("кнопка быстрой корзины");
    }
    public SelenideElement nameOfProduct() {
        return $(byText("Faded Short Sleeve T-shirts")).as("название товара");
    }
    public SelenideElement popupSuccessAddToCart() {
        return $(".icon-ok").as("Поп ап об успешном добавлении товара");
    }
}

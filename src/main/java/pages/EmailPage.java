package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class EmailPage {
    public SelenideElement inputEmail() {
        return $("#newsletter-input").as("Поле ввода почты");
    }
    public SelenideElement alertWrongEmail() {
        return $(".alert.alert-danger").as("Уведомление о неправильной почте");
    }
}

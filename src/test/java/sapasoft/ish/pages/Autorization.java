package sapasoft.ish.pages;

import io.qameta.allure.Step;
import sapasoft.ish.testconfigs.Base;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Autorization extends Base {
    @Step("Авторизация в системе")
    public Autorization logIn( String login, String password){
        closeWebDriver();
        open("/");
        $(By.xpath("//span[text()=\"Войти через SSO\"]")).click();
        $(By.xpath("//input[@id=\"username\"]")).setValue(login);
        $(By.xpath("//input[@class ='btn-login-page']")).click();
        $(By.xpath("//button[@id=\"proceed-button\"]")).click();
        $(By.xpath("//input[@name=\"password\"]")).setValue(password);
        $(By.xpath("//input[@id=\"kc-login\"]")).click();
        $(By.xpath("//button[@id=\"proceed-button\"]")).click();
        $(By.xpath("//div/h3")).shouldBe(text("Администрирование интеграционной шины"));
        return this;
    }

    @Step("Выход из системы")
    public Autorization logOut(){
        $(By.xpath("//span[text()=\"Выйти\"]")).click();
       // $(By.xpath("//form/div[@class = \"makeStyles-title-7\"]")).shouldBe(text("Авторизация"));
        return this;
    }
}

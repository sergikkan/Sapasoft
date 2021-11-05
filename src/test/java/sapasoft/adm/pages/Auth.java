package sapasoft.adm.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import sapasoft.adm.testconfigs.BaseSetings;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class Auth extends BaseSetings {

    public Auth logIn(String login, String password){
        closeWebDriver();
        open("/");
        $(By.xpath("//span[text()=\"Авторизация Keycloak\"]")).click();
        $(By.xpath("//input[@id=\"username\"]")).setValue(login);
        $(By.xpath("//input[@class ='btn-login-page']")).click();
        $(By.xpath("//input[@name=\"password\"]")).setValue(password);
        $(By.xpath("//input[@id=\"kc-login\"]")).click();
        refresh();
        $(By.xpath("//div/span[text()=\"Admin\"]")).shouldBe(Condition.visible);
        $(By.xpath("//div[text()=\"Администрирование и мониторинг\"]")).click();
        $(By.xpath("//div/h1")).shouldHave(Condition.text("Администрирование и мониторинг"));
        return this;
    }

    public Auth logOut(){
        $(By.xpath("//a/span[text()=\"Выйти из профиля\"]")).click();
        $(By.xpath("//a[text()=\"Да\"]")).click();
        $(By.xpath("//p[text()=\"Вход по логину и паролю\"]")).shouldBe(Condition.visible);
        return this;
    }
}

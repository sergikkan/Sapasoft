package sapasoft.adm.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class UsersManagmentPage {

    public void open(){
        $(By.xpath("//div[@class='antd-pro-components-menu-page-index-items']/a[4]")).click();
        $(By.xpath("//div/h1")).shouldHave(text("Управление пользователями"));
    }

    // Открыть данные пользователя
    public void openUser(){
        $(By.xpath("//tbody/tr[2]")).click();
        $(By.xpath("//div[text()=\"Редактировать пользователя\"]")).shouldBe(visible);
    }
}

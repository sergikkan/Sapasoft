package sapasoft.adm.pages;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
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

    @Step("Поиск по ФИО")
    public void searchUser(String searchText){
        $(By.xpath("//input[@name=\"searchValue\"]")).setValue(searchText);
        $(By.xpath("//tbody/tr[2]")).shouldHave(text(searchText));

    }

    //Кнопка Расширенный поиск
    @Step("Кнопка расширенный поиск")
    public void extendedSearchUser(){
        $(By.xpath("//div[@class=\"filter\"]")).click();
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Применить\"]")).shouldBe(visible);
    }
}

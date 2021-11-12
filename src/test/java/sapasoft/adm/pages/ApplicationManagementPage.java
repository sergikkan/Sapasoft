package sapasoft.adm.pages;


import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ApplicationManagementPage {
    @DisplayName("Открываем раздел \"Управление заявками\"")
    public void open(){
        $(By.xpath("//div[@class='antd-pro-components-menu-page-index-items']/a[5]")).click();
         $(By.xpath("//div/h1")).shouldHave(text("Управление заявками"));
    }

    @Step("Открыть заявку для просмотра")
    public void openApplication(){
        $(By.xpath("//tbody/tr[1]")).click();
        $(By.xpath("//div[@class=\"ant-modal-body\"]//div[@class=\"ant-col ant-col-24 administration-modal__label\"]")).shouldHave(text("Заявка на создание учетной записи"));
    }

    @Step("Нажать на кнопку отмена")
    public void cancelButton(){
        $(By.xpath("//div[@class=\"ant-modal-body\"]//button/span[text()=\"Отмена\"]")).click();
        $(By.xpath("//div[@class=\"ant-modal-body\"]")).shouldNotBe(visible);
    }

    @Step("Ввести значение в строку поиска")
    public void searchLine(String searchLine){
        $(By.xpath("//input[@placeholder=\"Поиск по ФИО или ИИН\"]")).setValue(searchLine);
        $(By.xpath("//tbody/tr[1]")).shouldHave(text(searchLine));

    }

    //Кнопка Расширенный поиск
    @Step("Кнопка расширенный поиск")
    public void extendedSearch(){
        $(By.xpath("//div[@class=\"filter\"]")).click();
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Применить\"]")).shouldBe(visible);
    }

    // Кнопка Применить
    @Step("Нажать кнопку применить в поиске")
    public void applySearch(){
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Применить\"]")).click();
    }

    // Кнопка Сбросить
    @Step("Нажать кнопку сбросить в поиске")
    public void resetSearch(){
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Сбросить\"]")).click();
    }

    @Step("Выбрать тип заявки")
    public void typeOfApplication(String type) {
        $(By.xpath("//label[@title=\"Тип заявки\"]/../../div[2]//input")).click();
        $(By.xpath("//div[@title=\"Регистрация аудитора\"]")).click();
    }

    @Step("Выбрать статус")
    public void status(String status) {
    }

    @Step("Выбрать период создания")
    public void periodOfCreation(String period) {
    }
    @Step("Выбрать период создания")
    public void periodOfCreation(String period) {
    }

    @Step("Выбрать подсистему/модуль")
    public void module(String module) {
    }

    public void ogd(String ogd) {
    }

    public void subdivision(String subdivision) {
    }


    public void position(String position) {
    }
}

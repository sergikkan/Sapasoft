package sapasoft.ish.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Groups {

   //Действия
    @Step("Открыть раздел группы")
    public void open(){
        $(By.xpath("//div/ul/li[3]")).click();
    }

    @Step("Добавить новую группу")
    public void add() {
        $(By.xpath("//button[@title=\"Добавить\"]")).click();
    }

    @Step("Редактировать группу")
    public void edit() {
        $(By.xpath("//tbody/tr[1]/td[3]/div/button[1] ")).click();
    }

    @Step("Удалить группу")
    public void delete(String group) {
        //$(By.xpath("//tbody/tr[1]/td[1]")).shouldHave(value(group));
        $(By.xpath("//tbody/tr[1]/td[3]/div/button[2]")).click();
        confirm();
    }

    @Step("Сохранить изменения")
    public void save() {
        $(By.xpath("//span[text()=\"Сохранить\"]")).click();
    }

    @Step("Отменить изменения")
    public void cancel() {
        $(By.xpath("//span[text()=\"Отмена\"]")).click();
    }


    @Step("Заполнить поле код группы")
    public void fillCodeOfGroup(String code){
        $(By.xpath("//textarea[@name=\"code\"]")).setValue(code);
    }


    @Step ("Ввести новое зачение в поле код")
    public void fillNewCode(String newcode){
        $(By.xpath("//textarea[@name=\"code\"]")).setValue(newcode);
    }

    @Step ("Очистить поле код")
    public void clearFieldGroup(){
        $(By.xpath("//textarea[@name=\"code\"]")).sendKeys(Keys.CONTROL + "a");
        $(By.xpath("//textarea[@name=\"code\"]")).sendKeys(Keys.BACK_SPACE);
    }

    @Step("Очистить поле поиска")
    public void clearSearchField() {
        $(By.xpath("//input[@name=\"search\"]")).sendKeys(Keys.CONTROL + "a");
        $(By.xpath("//input[@name=\"search\"]")).sendKeys(Keys.BACK_SPACE);
    }



    @Step("Проверка, что группа с таким кодом уже сущетсвует в системе")
    public void checkGroupExist() {
        $(By.xpath("//form[@action=\"#\"]//p")).shouldBe(text("Группа с таким кодом уже существует в системе"));
    }

    @Step("Проверка, что нельзя создать группу с пустым полем код")
    public void checkThatFieldIsEmpty(){
        $(By.xpath("//form[@action=\"#\"]//p")).shouldBe(text("Поле обязательно для заполнения"));
    }

    @Step("Поиск группы по коду")
    public void search(String code) {
        $(By.xpath("//input[@name=\"search\"]")).setValue(code);
        $(By.xpath("//tbody/tr[1]")).shouldHave(text(code));
    }


    @Step("Проверка, что группа не существует")
    public void checkGroupNotExist(String code) {
        $(By.xpath("//input[@name=\"search\"]")).setValue(code);
        $(By.xpath("//tbody/tr[1]")).shouldHave(text("Нет данных"));
    }
    @Step("Проверка что группа использется во взаимодействии")
    public void checkThatGroupInInteger(String intcode) {
        confirm();
        $(byText(intcode)).shouldBe(visible);
    }

    public void clearSerchLine(){
        $(By.xpath("//div[@class=\"MuiFormControl-root MuiTextField-root\"]/div/div[2]/button")).click();
    }

}

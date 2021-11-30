package sapasoft.ish.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Groups {

   //Действия
    public void open(){
        $(By.xpath("//div/ul/li[3]")).click();
    }

    public void add() {
        $(By.xpath("//button[@title=\"Добавить\"]")).click();
    }

    public void edit() {
        $(By.xpath("//tbody/tr[1]/td[3]/div/button[1] ")).click();
    }

    public void delete() {
        $(By.xpath("//tbody/tr[1]/td[3]/div/button[2]")).shouldBe(exist);
        String t = $(By.xpath("//tbody/tr[1]/td[1]")).getText();
        $(By.xpath("//tbody/tr[1]/td[3]/div/button[2]")).click();
        confirm();
        $$(By.xpath("//tbody")).findBy(text(t)).shouldNotBe(visible);

    }

    public void save() {
        $(By.xpath("//span[text()=\"Сохранить\"]")).click();
    }

    public void cancel() {
        $(By.xpath("//span[text()=\"Отмена\"]")).click();
    }


    public void deleteInteger(String intcode) {

        $(byText(intcode)).closest("tr/td[3]/div/button[2]").click();
        confirm();
        Selenide.switchTo().alert().getText().equals("Удаление группы невозможно. Группа исtttпользуется во взаимодействии");
        confirm();
        $(byText(intcode)).shouldBe(visible);
    }

    public void fillCodeOfGroup(String code){
        $(By.xpath("//textarea[@name=\"code\"]")).setValue(code);
    }

    public void fillExistCode() {
        $(By.xpath("//tbody/tr[2]/td[1]")).shouldBe(exist);

        $(By.xpath("//textarea[@name=\"code\"]")).setValue($(By.xpath("//tbody/tr[2]/td[1]")).getText());
    }

    public void fillNewCode(String newcode){
        $(By.xpath("//textarea[@name=\"code\"]")).setValue(newcode);
    }

    public void clearFieldGroup(){
        $(By.xpath("//textarea[@name=\"code\"]")).sendKeys(Keys.CONTROL + "a");
        $(By.xpath("//textarea[@name=\"code\"]")).sendKeys(Keys.BACK_SPACE);
    }

    public void searchExistResult(String result) {
        $(By.xpath("//input[@name=\"search\"]")).setValue(result);
        $(By.xpath("//tbody/tr[1]")).shouldHave(text(result));
    }

    public void searchWrongResult() {
        String wrong = "wrongcode"+ System.currentTimeMillis();
        $(By.xpath("//input[@name=\"search\"]")).setValue(wrong);
        $(By.xpath("//tbody/tr[1]")).shouldHave(text("Нет данных"));
    }

    public void clearSearchField() {
        $(By.xpath("//input[@name=\"search\"]")).sendKeys(Keys.CONTROL + "a");
        $(By.xpath("//input[@name=\"search\"]")).sendKeys(Keys.BACK_SPACE);
    }


    // ПРОВЕРКИ
    public void checkGroupWasCreated(String code) {
        $$(By.xpath("//tbody/tr[1]/td[1]")).shouldHave(CollectionCondition.texts(code));
    }

    public void checkGroupExist() {
        $(By.xpath("//form[@action=\"#\"]//p")).shouldBe(text("Группа с таким кодом уже существует в системе"));
    }

    public void checkThatFieldIsEmpty(){
        $(By.xpath("//form[@action=\"#\"]//p")).shouldBe(text("Поле обязательно для заполнения"));
    }

    public void checkGroupWasChanged(String code) {
        $(byText(code)).shouldBe(visible);
    }

}

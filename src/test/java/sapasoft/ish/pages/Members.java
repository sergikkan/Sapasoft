package sapasoft.ish.pages;

import com.codeborne.selenide.CollectionCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Members {

    // Кнопки

    public void open(){
        $(By.xpath("//div/ul/li[2]")).click();
    }

    public void add() {
        $(By.xpath("//button[@title=\"Добавить\"]")).click();
    }

    public void edit() {
        $$(By.xpath("//td/div/button")).first().click();
    }

    public void delete() {
        $(By.xpath("//tbody/tr[1]/td[5]")).shouldBe(exist);
        String t = $(By.xpath("//tbody/tr[1]/td[1]")).getText();
        $(By.xpath("//tbody/tr[1]/td[5]/div/button[2]")).click();
        confirm();
        $$(By.xpath("//tbody")).findBy(text(t)).shouldNotBe(visible);
    }

    public void save() {
        $(By.xpath("//button[@type=\"submit\"]")).click();

    }

    public void cancel() {
        $(By.xpath("//span[text()=\"Отмена\"]")).click();
    }


    //Заполнение полей
    public void fillCodeOfMember(String code){
        $(By.xpath("//textarea[@name=\"code\"]")).setValue(code);
    }
    public void fillNameOfMember(String name){
        $(By.xpath("//textarea[@name=\"name\"]")).setValue(name);
    }
    public void fillUsernameOfMember(String username){
        $(By.xpath("//textarea[@name=\"username\"]")).setValue(username);
    }

    public void fillPasswordOfMember(String password) {
        $(By.xpath("//input[@name=\"password\"]")).setValue(password);
    }

    public void chooseGroup(String group){
        $(By.xpath("//button[@title=\"Open\"]")).click();
        $(byText(group)).click();
    }

    public void checkMemberWasCreated(String name) {
        $(By.xpath("//tbody")).shouldBe(visible);
        $$(By.xpath("//tbody/tr[1]/td[1]")).shouldHave(CollectionCondition.texts(name));
    }

    public void checkRequiredFields() {
        $(By.xpath("//textarea[@name=\"code\"]/../../p")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("//textarea[@name=\"name\"]/../../p")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("//textarea[@name=\"username\"]/../../p")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("//input[@name=\"password\"]/../../p")).shouldHave(text("Поле обязательно для заполнения"));
    }

    public void checkRequiredFieldsEdit() {
        $(By.xpath("//textarea[@name=\"code\"]/../../p")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("//textarea[@name=\"name\"]/../../p")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("//textarea[@name=\"username\"]/../../p")).shouldHave(text("Поле обязательно для заполнения"));
        $(byText("Минимальное количество 1 символа")).shouldBe(visible);
    }

    public void clearAllFields() {
        $(By.xpath("//textarea[@name=\"code\"]")).sendKeys(Keys.CONTROL + "a");
        $(By.xpath("//textarea[@name=\"code\"]")).sendKeys(Keys.BACK_SPACE);
        $(By.xpath("//textarea[@name=\"name\"]")).sendKeys(Keys.CONTROL + "a");
        $(By.xpath("//textarea[@name=\"name\"]")).sendKeys(Keys.BACK_SPACE);
        $(By.xpath("//textarea[@name=\"username\"]")).sendKeys(Keys.CONTROL + "a");
        $(By.xpath("//textarea[@name=\"username\"]")).sendKeys(Keys.BACK_SPACE);
        $(By.xpath("//button[@title=\"Open\"]")).click();
        $(By.xpath("//button[@title=\"Clear\"]")).click();
    }

    public void clearCodeField(){
        $(By.xpath("//textarea[@name=\"code\"]")).sendKeys(Keys.CONTROL + "a");
        $(By.xpath("//textarea[@name=\"code\"]")).sendKeys(Keys.BACK_SPACE);
    }

    public void clearNameField(){
        $(By.xpath("//textarea[@name=\"name\"]")).sendKeys(Keys.CONTROL + "a");
        $(By.xpath("//textarea[@name=\"name\"]")).sendKeys(Keys.BACK_SPACE);
    }

    public void clearUsernameField(){
        $(By.xpath("//textarea[@name=\"username\"]")).sendKeys(Keys.CONTROL + "a");
        $(By.xpath("//textarea[@name=\"username\"]")).sendKeys(Keys.BACK_SPACE);
    }


    public void fillExistCode() {
        String code = $(By.xpath("//tbody/tr[1]/td[2]")).getText();
        $(By.xpath("//textarea[@name=\"code\"]")).setValue(code);
    }
    public void fillExistName() {
        String name = $(By.xpath("//tbody/tr[1]/td[1]")).getText();
        $(By.xpath("//textarea[@name=\"name\"]")).setValue(name);
    }
    public void fillExistUsername() {
        String username = $(By.xpath("//tbody/tr[1]/td[3]")).getText();
        $(By.xpath("//textarea[@name=\"username\"]")).setValue(username);
    }

    public void checkUniqueCode(){
        $(By.xpath("//textarea[@name=\"code\"]/../../p")).shouldHave(text("Участник с таким кодом уже существует в системе"));
    }
    public void checkUniqueName(){
        $(By.xpath("//textarea[@name=\"name\"]/../../p")).shouldHave(text("Участник с таким наименованием уже существует в системе"));
    }
    public void checkUniqueUsername(){
        $(By.xpath("//textarea[@name=\"username\"]/../../p")).shouldHave(text("Участник с таким именем пользователя уже существует в системе"));
    }

    public void searchWrongMember() {
        String wrong = "wrongmember"+ System.currentTimeMillis();
        $(By.xpath("//input[@name=\"search\"]")).setValue(wrong);
        $(By.xpath("//tbody/tr[1]")).shouldHave(text("Нет данных"));
    }

    public void clearSearchField() {
        $(By.xpath("//input[@name=\"search\"]")).sendKeys(Keys.CONTROL + "a");
        $(By.xpath("//input[@name=\"search\"]")).sendKeys(Keys.BACK_SPACE);
    }

    public void searchExistMember(String existMember) {
        $(By.xpath("//input[@name=\"search\"]")).setValue(existMember);
        $(By.xpath("//tbody/tr[1]")).shouldHave(text(existMember));
    }
}

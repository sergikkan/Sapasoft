package sapasoft.ish.pages;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Members {

    // Кнопки
    @Step("Открыть раздел участники")
    public void open(){
        $(By.xpath("//div/ul/li[4]")).click();
    }

    @Step("Добавить нового участника")
    public void add() {
        $(By.xpath("//button[@title=\"Добавить\"]")).click();
    }

    @Step("Нажать на кнопку редактировать")
    public void edit() {
        $$(By.xpath("//td/div/button")).first().click();
    }

    @Step("Нажать на кнопку удалить")
    public void delete() {
        $(By.xpath("//tbody/tr[1]/td[5]")).shouldBe(exist);
        $(By.xpath("//tbody/tr[1]/td[5]/div/button[2]")).click();
        confirm();
    }

    @Step("Нажать кнопку сохранить")
    public void save() {
        $(By.xpath("//button[@type=\"submit\"]")).click();

    }

    @Step("Нажать кнопку отменить")
    public void cancel() {
        $(By.xpath("//span[text()=\"Отмена\"]")).click();
    }


    //Заполнение полей
    @Step("Заполнить поле код")
    public void fillCode(String code){
        $(By.xpath("//textarea[@name=\"code\"]")).sendKeys(Keys.CONTROL + "a");
        $(By.xpath("//textarea[@name=\"code\"]")).sendKeys(Keys.BACK_SPACE);
        $(By.xpath("//textarea[@name=\"code\"]")).setValue(code);
    }
    @Step("Заполнить поле наименование")
    public void fillName(String name){
        $(By.xpath("//textarea[@name=\"name\"]")).sendKeys(Keys.CONTROL + "a");
        $(By.xpath("//textarea[@name=\"name\"]")).sendKeys(Keys.BACK_SPACE);
        $(By.xpath("//textarea[@name=\"name\"]")).setValue(name);
    }
    @Step("Заполнить поле имя пользователя")
    public void fillUsername(String username){
        $(By.xpath("//textarea[@name=\"username\"]")).sendKeys(Keys.CONTROL + "a");
        $(By.xpath("//textarea[@name=\"username\"]")).sendKeys(Keys.BACK_SPACE);
        $(By.xpath("//textarea[@name=\"username\"]")).setValue(username);
    }

    @Step("Заполнить поле пароль")
    public void fillPasswordOfMember(String password) {
        $(By.xpath("//input[@name=\"password\"]")).setValue(password);
    }

    @Step("Выбрать группу")
    public void chooseGroup(String group){
        $(By.xpath("//button[@title=\"Open\"]")).click();
        $(byText(group)).click();
        sleep(2000);
    }

    @Step("Проверка, что пользователь создан")
    public void checkMemberNotExist(String name) {
        $(By.xpath("//input[@name=\"search\"]")).setValue(name);
        $(By.xpath("//tbody/tr[1]")).shouldHave(text("Нет данных"));
    }

    @Step("Проверка обязательных полей")
    public void checkRequiredFields() {
        $(By.xpath("//textarea[@name=\"code\"]/../../p")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("//textarea[@name=\"name\"]/../../p")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("//textarea[@name=\"username\"]/../../p")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("//input[@name=\"password\"]/../../p")).shouldHave(text("Поле обязательно для заполнения"));
    }

    @Step("Проверка обязательных полей для заполнения")
    public void checkRequiredFieldsEdit() {
        $(By.xpath("//textarea[@name=\"code\"]/../../p")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("//textarea[@name=\"name\"]/../../p")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("//textarea[@name=\"username\"]/../../p")).shouldHave(text("Поле обязательно для заполнения"));
        $(byText("Минимальное количество 1 символа")).shouldBe(visible);
    }
    @Step("Очистить поле выбора группы")
    public void clearfieldGroup() {
        $(By.xpath("//button[@title=\"Open\"]")).click();
        $(By.xpath("//button[@title=\"Clear\"]")).click();
    }

    @Step("Очистить поле код")
    public void clearFieldCode(){
        $(By.xpath("//textarea[@name=\"code\"]")).sendKeys(Keys.CONTROL + "a");
        $(By.xpath("//textarea[@name=\"code\"]")).sendKeys(Keys.BACK_SPACE);
    }

    @Step("Очистить поле наименование")
    public void clearFieldName(){
        $(By.xpath("//textarea[@name=\"name\"]")).sendKeys(Keys.CONTROL + "a");
        $(By.xpath("//textarea[@name=\"name\"]")).sendKeys(Keys.BACK_SPACE);
    }

    @Step("Очистить поле имя пользователя")
    public void clearFieldUsername(){
        $(By.xpath("//textarea[@name=\"username\"]")).sendKeys(Keys.CONTROL + "a");
        $(By.xpath("//textarea[@name=\"username\"]")).sendKeys(Keys.BACK_SPACE);
    }



    @Step("Заполнить существующее значение код")
    public void fillExistCode() {
        String code = $(By.xpath("//tbody/tr[1]/td[2]")).getText();
        $(By.xpath("//textarea[@name=\"code\"]")).sendKeys(Keys.CONTROL + "a");
        $(By.xpath("//textarea[@name=\"code\"]")).sendKeys(Keys.BACK_SPACE);
        $(By.xpath("//textarea[@name=\"code\"]")).setValue(code);
    }

    @Step("Заполнить существующее значение наименование")
    public void fillExistName() {
        String name = $(By.xpath("//tbody/tr[1]/td[1]")).getText();
        $(By.xpath("//textarea[@name=\"name\"]")).sendKeys(Keys.CONTROL + "a");
        $(By.xpath("//textarea[@name=\"name\"]")).sendKeys(Keys.BACK_SPACE);
        $(By.xpath("//textarea[@name=\"name\"]")).setValue(name);
    }

    @Step("Заполнить существующее значение имя пользователя")
    public void fillExistUsername() {
        String username = $(By.xpath("//tbody/tr[1]/td[3]")).getText();
        $(By.xpath("//textarea[@name=\"username\"]")).sendKeys(Keys.CONTROL + "a");
        $(By.xpath("//textarea[@name=\"username\"]")).sendKeys(Keys.BACK_SPACE);
        $(By.xpath("//textarea[@name=\"username\"]")).setValue(username);
    }

    @Step("Проверка уникальности кода")
    public void checkUniqueCode(){
        $(By.xpath("//textarea[@name=\"code\"]/../../p")).shouldHave(text("Участник с таким кодом уже существует в системе"));
    }

    @Step("Проверка уникальности наименования")
    public void checkUniqueName(){
        $(By.xpath("//textarea[@name=\"name\"]/../../p")).shouldHave(text("Участник с таким наименованием уже существует в системе"));
    }

    @Step("Проверка уникальности имени пользователя")
    public void checkUniqueUsername(){
        $(By.xpath("//textarea[@name=\"username\"]/../../p")).shouldHave(text("Участник с таким именем пользователя уже существует в системе"));
    }

    @Step("Проверка, что участника не существует")
    public void searchMemberNotExist(String member) {
        $(By.xpath("//input[@name=\"search\"]")).setValue(member);
        $(By.xpath("//tbody/tr[1]")).shouldHave(text("Нет данных"));
    }

    @Step("Очистить поле поиска")
    public void clearSearchField() {
        $(By.xpath("//input[@name=\"search\"]")).sendKeys(Keys.CONTROL + "a");
        $(By.xpath("//input[@name=\"search\"]")).sendKeys(Keys.BACK_SPACE);
    }

    @Step("Поиск участника")
    public void searchMember(String existMember) {
        $(By.xpath("//input[@name=\"search\"]")).setValue(existMember);
        $(By.xpath("//tbody/tr[1]")).shouldHave(text(existMember));
    }
}

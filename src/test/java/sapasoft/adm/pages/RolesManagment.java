package sapasoft.adm.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;

public class RolesManagment extends BasePage {

    private final SelenideElement rolesManagment = element(Selectors.byXpath("//div[@class='antd-pro-components-menu-page-index-items']/a[2]"));
    private final SelenideElement createRole = element(Selectors.byXpath("//button/span[text()=\"Создать новую роль\"]"));
    private final SelenideElement roleCode = element(Selectors.byXpath("//input[@placeholder=\"Введите код роли\"]"));


    private final SelenideElement chooseLevel = element(Selectors.byXpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Уровень\"]/../..//input/../.."));
    private final SelenideElement chooseSearchLevel = element(Selectors.byXpath("//label[text()=\"Уровень\"]/../..//input/../.."));
    private final SelenideElement chooseDateFrom = element(Selectors.byXpath("//div[@class=\"ant-modal-body\"]//input[@placeholder=\"С\"]"));
    private final SelenideElement chooseDateTo = element(Selectors.byXpath("//div[@class=\"ant-modal-body\"]//input[@placeholder=\"По\"]"));

    @Step("Открываем раздел \"Управление ролями\"")
    public void open() {
        rolesManagment.click();
        headerName.shouldHave(text("Управление ролями"));
    }

    @Step("Нажать на кнопку Создать новую роль")
    public void createNewRole() {
        createRole.click();
        modalWindow.shouldBe(visible);
    }

    @Step("Заполнить поля наименования на русском, казахском, казахском (латиница)")
    public void fillNames(String rus, String kaz, String kzLat, String eng) {
        clearAndType(rusName, rus);
        clearAndType(kzName, kaz);
        clearAndType(kzNameLatinica, kzLat);
        clearAndType(engName, eng);
    }

    @Step("Заполнить поле код")
    public void fillCode(String code) {
        roleCode.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        roleCode.setValue(code);
    }

    @Step("Выбрать уровень")
    public void chooseLevel(String level) {
        chooseLevel.click();
        $(By.xpath("//div[@title=\"" + level + "\"]")).click();
        $(By.xpath("//span[@title=\"" + level + "\"]")).shouldBe(visible);
    }

    @Step("Выбрать дату С периода действия")
    public void chooseDate(String dateFrom) {
        chooseDateFrom.click();
        chooseDateFrom.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        chooseDateFrom.sendKeys(dateFrom);
        chooseDateFrom.pressEnter();
        chooseDateTo.pressEnter();
    }

    @Step("Выбрать первое право из списка прав")
    public void chooseRights() {
        $(By.xpath("//ul[@class=\"ant-list-items\"]/div[1]//span[@class=\"ant-checkbox\"]")).click();
        $(By.xpath("//div[@class=\"ant-row\"]/div/button")).click();
        $(By.xpath("//div[text()=\"Выбранные права\"]/parent::div//ul/div")).shouldBe(visible);
    }

//    @Step("Кнопка создать")
//    public void create() {
//        createButton.shouldNotBe(disabled);
//        createButton.click();
//    }

//    @Step("Кнопка отмена")
//    public void cancel() {
//        cancelButton.click();
//    }

    @Step("Проверка, что роль создалась")
    public void checkRoleWasCreated(String rusName) {
        $(byText("Роль успешно создана")).shouldBe(visible);
        modalWindow.shouldNotBe(visible);
        $(By.xpath("//tbody/tr[2]/td[2]")).shouldHave(text(rusName));
    }

    @Step("Открыть роль")
    public void openRole() {
        $(By.xpath("//tbody/tr[2]")).click();
        $(By.xpath("//div[text()=\"Общая информация\"]")).shouldBe(visible);
    }

//    @Step("Кнопка редактировать роль")
//    public void editButton() {
//        editButton.click();
//    }

    @Step("Кнопка Применить в редактировании роли")
    public void editRoleApply() {
        applyButton.click();
        $(byText("Роль успешно изменена")).shouldBe(visible);
    }

    @Step("Нажать на кнопку деактивировать роль")
    public void deactivateRole() {
        deactivationButton.click();
        confirmAction.click();
    }

    @Step("Проверить, что роль деактивирована")
    public void checkThatRoleDeactivated() {
        $(byText("Роль успешно деактивирована")).shouldBe(visible);
    }

    @Step("Нажать на кнопку активировать роль")
    public void activateRole() {
        activationButton.click();
        confirmAction.click();
    }

    @Step("Проверить, что роль активирована")
    public void checkThatRoleActivated() {

        $(byText("Роль успешно активирована")).shouldBe(visible);
    }

    @Step("Открыть пункт Пользователи в карточке пользователя")
    public void openRoleUsers() {
        $(By.xpath("//div[text()=\"Пользователи\"]")).click();
        $(By.xpath("//div[@class=\"ant-modal-body\"]//tr/th")).shouldBe(visible);
    }

    @Step("Открыть пункт Служебная информация в карточке пользователя")
    public void openRoleServiceInfo() {
        $(By.xpath("//div[text()=\"Служебная информация\"]")).click();
        $(By.xpath("//label[text()=\"Кем зарегестрирован\"]")).shouldBe(visible);
    }

    @Step("Кнопка закрыть роль (крестик в правом верхнем углу)")
    public void closeRole() {
        closeModalWindow.click();
        modalWindow.shouldNotBe(visible);
    }

    @Step("Проверка что уровень соответствует заданому параметру")
    public void checkLevel(String level) {
        if (level == "УГД") {
            $(By.xpath("//tbody/tr[2]/td[4]")).shouldHave(text("UGD"));
        }
        if (level == "КГД") {
            $(By.xpath("//tbody/tr[2]/td[4]")).shouldHave(text("KGD"));
        }
        if (level == "ДГД") {
            $(By.xpath("//tbody/tr[2]/td[4]")).shouldHave(text("DGD"));
        }
    }

    @Step("Проверка что код уже зарегистрирован в системе")
    public void checkThatCodeExist() {
        modalWindow.shouldBe(visible);
        $(byText("Роль с таким кодом уже существует в системе")).shouldBe(visible);
    }

    @Step("Проверка того, что такое наименование уже существует в системе")
    public void checkThatNamesExist() {
        modalWindow.shouldBe(visible);
        $(byText("Роль с таким названием уже существует в системе")).shouldBe(visible);
    }

    @Step("Проверка, что кнопка Создать неактивна")
    public void checkThatButtonDisabled() {
        createButton.shouldBe(disabled);
    }

    @Step("Поиск роли по коду или наименованию")
    public void searchRole(String searchText) {
        clearAndType(searchInput, searchText);
        $(By.xpath("//tbody/tr[2]")).shouldHave(text(searchText));
    }

    @Step("Нажать на кнопку Расширенный поиск роли")
    public void extendedSearch() {
        extendedSearch.click();
        applySearch.shouldBe(visible);
    }


    @Step("Выбрать значение уровня в поиске")
    public void chooseSearchLevel(String searchlevel) {
       chooseSearchLevel.click();
        $(By.xpath("//div[@title=\"" + searchlevel + "\"]")).click();
    }

    @Step("Нажать на кнопку применить в поиске")
    public void applySearch() {
        applySearch.click();
    }

    @Step("Нажать на кнопку сбросить в поиске")
    public void resetSearch() {
        resetSearch.click();
    }

    @Step("Проверка, что статус соотвествует значению в поиске")
    public void checkSearchStatus(String searchStatus) {
        $(By.xpath("//tbody/tr[2]/td[7]")).shouldHave(exactText(searchStatus));
    }

    @Step("Проверка, что значение модуля соответствует значению в поиске")
    public void checkSearchModule(String searchModule) {
        $(By.xpath("//tbody/tr[2]/td[3]")).shouldHave(text(searchModule));
    }

}

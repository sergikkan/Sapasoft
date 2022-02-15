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


public class RightsManagment extends BasePage {

    private final SelenideElement rightsManagment = element(Selectors.byXpath("//div[@class='antd-pro-components-menu-page-index-items']/a[1]"));
    private final SelenideElement createNewRule = element(Selectors.byXpath("//button/span[text()=\"Создать новое право\"]"));
    private final SelenideElement rightCode = element(Selectors.byXpath("//input[@placeholder=\"Введите код права\"]"));


    @Step("Открываем раздел Управление правами")
    public void open() {
        rightsManagment.click();
        headerName.shouldHave(text("Управление правами"));
    }

    @Step("Кнопка создать новое прво")
    public void createNewRight() {
        createNewRule.click();
        modalWindow.shouldBe(visible);
    }

    @Step("Заполняем поля наименования на русском, казахском и казахском (латиница), английском")
    public void fillNames(String rus, String kaz, String kzLat, String eng) {
        clearAndType(rusName, rus);
        clearAndType(kzName, kaz);
        clearAndType(kzNameLatinica, kzLat);
        clearAndType(engName, eng);
    }

    @Step("Заполнить поле код")
    public void fillCode(String code) {
        rightCode.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        rightCode.setValue(code);
    }

    @Step("Синхронизировать с КГП (чекбокс)")
    public void synchronizeKNP() {
        $(By.xpath("//label/span[@class=\"ant-checkbox\"]")).click();
        $(By.xpath("//span[@class=\"ant-checkbox ant-checkbox-checked\"]")).shouldBe(visible);
    }

//    //Кнопка создать
//    @Step("Нажать на кнопку создать")
//    public void create() {
//        createButton.click();
//    }


//    @Step("Нажать на кнопку отмена")
//    public void cancel() {
//        cancelButton.click();
//    }

    @Step("Проверка что право создалось")
    public void checkRightWasCreated(String rusName) {
        $(byText("Право успешно создано")).shouldBe(visible);
        modalWindow.shouldNotBe(visible);
        $(By.xpath("//tbody/tr[1]/td[2]")).shouldHave(text(rusName));
    }

    @Step("Открыть право")
    public void openRight() {
        $(By.xpath("//tbody/tr[1]")).click();
        $(By.xpath("//div[text()=\"Общая информация\"]")).shouldBe(visible);
    }

//    @Step("Редактировать право")
//    public void editButton() {
//        editButton.click();
//    }


    @Step("Применить измения")
    public void editRightApply() {
        applyButton.click();
        $(byText("Право успешно изменено")).shouldBe(visible);
    }

    @Step("Кнопка деактивировать право")
    public void deactivateRight() {
        deactivationButton.click();
        confirmAction.click();
        $(byText("Право успешно деактивировано")).shouldBe(visible);
    }

    @Step("Кнопка активировать право")
    public void activateRight() {
        activationButton.click();
        confirmAction.click();
        $(byText("Право успешно активировано")).shouldBe(visible);
    }

    @Step("Проверка что право с таким кодом уже существует")
    public void checkThatCodeExist() {
        modalWindow.shouldBe(visible);
        $(By.xpath("//*[@class=\"ant-notification-notice-message\"]")).shouldHave(text("Право с таким кодом уже существует в системе"));
    }

    @Step("Проверка что право с таким именем уже существует")
    public void checkThatNamesExist() {
        modalWindow.shouldBe(visible);
        $(By.xpath("//*[@class=\"ant-notification-notice-message\"]")).shouldHave(text("Право с таким названием уже существует в системе"));
    }


    @Step("Поиск по коду или наименованию")
    public void searchRight(String searchText) {
        clearAndType(searchInput, searchText);
        $(By.xpath("//tbody/tr[1]")).shouldHave(text(searchText));
    }

    @Step("Кнопка расширенный поиск")
    public void extendedSearch() {
        extendedSearch.click();
        applySearch.shouldBe(visible);
    }

    @Step("Нажать кнопку применить в поиске")
    public void applySearch() {
        applySearch.click();
    }

    @Step("Нажать кнопку сбросить в поиске")
    public void resetSearch() {
        resetSearch.click();
    }

    @Step("Проверка, что статус соответствует значению в поиске")
    public void checkSearchStatus(String searchStatus) {
        $(By.xpath("//tbody/tr[1]/td[6]")).shouldHave(exactText(searchStatus));
    }

    @Step("Проверка, что значение модуля соответствует значению в поиске")
    public void checkSearchModule(String searchModule) {
        $(By.xpath("//tbody/tr[1]/td[3]")).shouldHave(exactText(searchModule));
    }

}

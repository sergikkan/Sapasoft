package sapasoft.adm.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;

public class RolesGroupsManagmentPage extends BasePage {

    private final SelenideElement rolesGroupsManagment = element(Selectors.byXpath("//div[@class='antd-pro-components-menu-page-index-items']/a[3]"));
    private final SelenideElement createNewRolesGroup = element(Selectors.byXpath("//button/span[text()=\"Создать группу ролей\"]"));
    private final SelenideElement groupCode = element(Selectors.byXpath("//input[@placeholder=\"Введите код группы\"]"));
    private final SelenideElement chooseModule = element(Selectors.byXpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Подсистема/модуль\"]/../..//input"));
    private final SelenideElement chooseDepartment = element(Selectors.byXpath("//span[@class=\"ant-input-group ant-input-group-compact\"]/div[2]//input"));
    private final SelenideElement chooseSubdivision = element(Selectors.byXpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Подразделение\"]/../../div[2]//input"));
    private final SelenideElement choosePosition = element(Selectors.byXpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Должность\"]/../..//input"));
    private final SelenideElement chooseSearchModule = element(Selectors.byXpath("//label[@title=\"Подсистема/модуль\"]/ancestor::div[@class=\"ant-row ant-form-item\"]/div[2]//input"));
    private final SelenideElement chooseStatus = element(Selectors.byXpath("//span[text()=\"Выберите статус\"]/..//input"));
    private final SelenideElement chooseSearchDepartment = element(Selectors.byXpath("//span[text()=\"Наименование ОГД\"]/..//input"));
    private final SelenideElement chooseSearchSubdivision = element(Selectors.byXpath("//label[text()=\"Подразделение\"]/../../div[2]//input"));


    @Step("Открываем раздел \"Управление группами ролей\"")
    public void open() {
        rolesGroupsManagment.click();
        headerName.shouldHave(text("Управление группами ролей"));
    }

    @Step("Нажать на кнопку создать новую группу ролей")
    public void createNewRolesGroup() {
        createNewRolesGroup.click();
        modalWindow.shouldBe(visible);
    }

    @Step("Ввести код группы ролей")
    public void fillCode(String rolesGroupCode) {
        clearAndType(groupCode, rolesGroupCode);
    }

    @Step("Ввести наименования группы ролей")
    public void fillNames(String rus, String kaz, String kzLat, String eng) {
        clearAndType(rusName, rus);
        clearAndType(kzName, kaz);
        clearAndType(kzNameLatinica, kzLat);
        clearAndType(engName, eng);
    }

    @Step("Выбрать модуль группу ролей")
    public void chooseModule(String module) {
        chooseModule.click();
        int n = 50;
        int i = 0;
        while (element(Selectors.byXpath("//span[contains(@title,\"" + module + "\")]")).is(Condition.not(visible))) {
            chooseModule.sendKeys(Keys.ARROW_DOWN);
            i = i + 1;
            if (i == n) break;
        }
        $(By.xpath("//span[contains(@title,\"" + module + "\")]")).click();
        $(By.xpath("//span[contains(@title,\"" + module + "\")]")).shouldBe(visible);
    }

    @Step("Выбрать орган государственных доходов")
    public void chooseDepartment(String rolesGroupDepartment) {
        chooseDepartment.click();
        int n = 200;
        int i = 0;
        while (element(Selectors.byXpath("//div[contains(@title,\"" + rolesGroupDepartment + "\")]")).is(Condition.not(visible))) {
            chooseDepartment.sendKeys(Keys.ARROW_DOWN);
            i = i + 1;
            if (i == n) break;
        }
        $(By.xpath("//div[contains(@title,\"" + rolesGroupDepartment + "\")]")).click();
        $(By.xpath("//span[contains(@title,\"" + rolesGroupDepartment + "\")]")).shouldBe(visible);
    }

    @Step("Выбрать подразделение")
    public void chooserolesGroupSubdivision(String rolesGroupSubdivision) {
        chooseSubdivision.shouldNotBe(disabled);
        chooseSubdivision.click();
        int n = 100;
        int i = 0;
        while (element(Selectors.byXpath("//div[contains(@title,\"" + rolesGroupSubdivision + "\")]")).is(Condition.not(visible))) {
            chooseSubdivision.sendKeys(Keys.ARROW_DOWN);
            i = i + 1;
            if (i == n) break;
        }
        element(Selectors.byXpath("//div[contains(@title,\"" + rolesGroupSubdivision + "\")]")).click();
        element(Selectors.byXpath("//div[contains(@title,\"" + rolesGroupSubdivision + "\")]")).shouldBe(visible);
    }

    @Step("Выбрать должность")
    public void chooserolesGroupPosition(String position) {
        choosePosition.click();
        int n = 20;
        int i = 0;
        while (element(Selectors.byXpath("//div[contains(@title,\"" + position + "\")]")).is(Condition.not(visible))) {
            choosePosition.sendKeys(Keys.ARROW_DOWN);
            i = i + 1;
            if (i == n) break;
        }
        element(Selectors.byXpath("//div[contains(@title,\"" + position + "\")]")).click();
        $(By.xpath("//span[contains(@title,\"" + position + "\")]")).shouldBe(visible);

    }

    @Step("Выбрать доступную роль")
    public void chooseRoles() {
        $(By.xpath("//ul[@class=\"ant-list-items\"]/div[1]//span[@class=\"ant-checkbox\"]")).click();
        $(By.xpath("//*[@class=\"ant-btn administration__button-white administration__button-arrow\"][1]")).click();
        $(By.xpath("//div[text()=\"Выбранные роли\"]/parent::div//ul/div[1]")).shouldBe(visible);
    }

    @Step("Проверка, что роль была создана")
    public void checkRoleWasCreated() {
        $(byText("Группа ролей успешно создана")).shouldBe(visible);
        modalWindow.shouldNotBe(visible);

    }

    @Step("Нажать на группу ролей для открытия информации")
    public void openRolesGroup() {
        $(By.xpath("//tbody/tr[2]")).click();
        $(By.xpath("//div[text()=\"Роли\"]")).shouldBe(visible);
    }


    @Step("Кнопка Применить в редактировании группы ролей")
    public void editRolesGroupApply() {
        applyButton.click();
        $(byText("Группа ролей успешно изменена")).shouldBe(visible);
    }


    @Step("Нажать на кнопку деактивировать группу ролей")
    public void deactivateRolesGroup() {
        deactivationButton.click();
        confirmAction.click();
        $(By.xpath("//*[@class=\"ant-notification-notice-message\"]")).shouldHave(text("Группа ролей успешно деактивирована"));
    }

    @Step("Нажать на кнопку активировать группу ролей")
    public void activateRolesGroup() {
        activationButton.click();
        confirmAction.click();
        $(byText("Группа ролей успешно активирована")).shouldBe(visible);
    }

    @Step("Поиск группы ролей по названию")
    public void searchRolesGroup(String searchText) {
        clearAndType(searchInput, searchText);
        $(By.xpath("//tbody/tr[2]")).shouldHave(text(searchText));
    }

    @Step("Нажать на кнопку расширенный поиск")
    public void extendedSearch() {
        extendedSearch.click();
        applySearch.shouldBe(visible);
    }


    @Step("Выбрать статус в расширенном поиске")
    public void fillSearchStatus(String status) {
        chooseStatus.click();
        $(By.xpath("//div[@title=\"" + status + "\"]")).click();
    }


    @Step("Нажать на кнопку применить в расширенном поиске")
    public void applySearch() {
        applySearch.click();
    }


    @Step("Нажать на кнопку сбросить в расширенном поиске")
    public void resetSearch() {
        resetSearch.click();
    }


    @Step("Проверка, что статус соотвествует значению в поиске")
    public void checkSearchStatus(String searchStatus) {
        $(By.xpath("//tbody/tr[2]/td[9]")).shouldHave(exactText(searchStatus));
    }

    @Step("Выбрать подсистему/модуль в поиске")
    public void chooseSearchModule(String searchModule) {
        chooseSearchModule.click();
        int n = 50;
        int i = 0;
        while (element(Selectors.byXpath("//span[contains(@title,\"" + searchModule + "\")]")).is(Condition.not(visible))) {
            chooseSearchModule.sendKeys(Keys.ARROW_DOWN);
            i = i + 1;
            if (i == n) break;
        }
        $(By.xpath("//span[contains(@title,\"" + searchModule + "\")]")).click();
        $(By.xpath("//span[contains(@title,\"" + searchModule + "\")]")).shouldBe(visible);
    }

    @Step("Проверка, что значение модуля соответствует значению в расширенном поиске")
    public void checkSearchModule(String searchModule) {
        $(By.xpath("//span[text()=\"Подсистема/модуль\"]/div/div")).shouldHave(exactText(searchModule));
    }

    @Step("Выбрать орган государственных доходов в расширенном поиске")
    public void chooseSearchDepartment(String rolesGroupDepartment) {
        chooseSearchDepartment.shouldNotBe(disabled);
        chooseSearchDepartment.click();
        int n = 200;
        int i = 0;
        while (element(Selectors.byXpath("//div[contains(@title,\"" + rolesGroupDepartment + "\")]")).is(Condition.not(visible))) {
            chooseSearchDepartment.sendKeys(Keys.ARROW_DOWN);
            i = i + 1;
            if (i == n) break;
        }
        $(By.xpath("//div[contains(@title,\"" + rolesGroupDepartment + "\")]")).click();
        $(By.xpath("//span[contains(@title,\"" + rolesGroupDepartment + "\")]")).shouldBe(visible);
    }

    @Step("Проверка, что значение органа государственных доходов соответствует значению в расширенном поиске")
    public void checkSearchDepartment(String searchDepartment) {
        $(By.xpath("//tbody/tr[2]/td[3]")).shouldHave(exactText(searchDepartment));

    }

    @Step("Выбрать подразделение в расширенном поиске")
    public void chooserolesGroupSearchSubdivision(String searchSubdivision) {
        chooseSearchSubdivision.shouldNotBe(disabled);
        chooseSearchSubdivision.click();
        int n = 100;
        int i = 0;
        while (element(Selectors.byXpath("//div[contains(@title,\"" + searchSubdivision + "\")]")).is(Condition.not(visible))) {
            chooseSearchSubdivision.sendKeys(Keys.ARROW_DOWN);
            i = i + 1;
            if (i == n) break;
        }
        element(Selectors.byXpath("//div[contains(@title,\"" + searchSubdivision + "\")]")).click();
        element(Selectors.byXpath("//div[contains(@title,\"" + searchSubdivision + "\")]")).shouldBe(visible);
    }

    @Step("Проверка, что значение подразделения соответствует значению в расширенном поиске")
    public void checkSearchSubdivision(String searchSubdivision) {
        $(By.xpath("//tbody/tr[2]/td[4]")).shouldHave(exactText(searchSubdivision));
    }

    @Step("Открыть пункт Пользователи в карточке группы ролей")
    public void openRolesGroupUsers() {
        $(By.xpath("//div[text()=\"Пользователи\"]")).click();
        $(By.xpath("//div[@class=\"ant-modal-body\"]//tr/th")).shouldBe(visible);

    }

    @Step("Открыть пункт Служебная информация в карточке группы ролей")
    public void openRolesGroupServiceInfo() {
        $(By.xpath("//div[text()=\"Служебная информация\"]")).click();
        $(By.xpath("//label[text()=\"Кем зарегестрирован\"]")).shouldBe(visible);
    }

    @Step("Кнопка закрыть группу ролей (крестик в правом верхнем углу)")
    public void closeRolesGroup() {
        closeModalWindow.click();
        modalWindow.shouldNotBe(visible);
    }

    @Step("Проверка что код уже зарегистрирован в системе")
    public void checkThatCodeExist() {
        modalWindow.shouldBe(visible);
        $(byText("Группа ролей с таким кодом уже существует в системе")).shouldBe(visible);
    }

    @Step("Проверка что название уже зарегистрировано в системе")
    public void checkThatCodeNameExist() {
        modalWindow.shouldBe(visible);
        $(byText("Группа ролей с таким названием уже существует в системе")).shouldBe(visible);
    }

}

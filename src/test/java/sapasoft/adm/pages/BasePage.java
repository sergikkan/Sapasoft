package sapasoft.adm.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;

public class BasePage {

    protected final SelenideElement headerName = element(Selectors.byXpath("//div/h1"));
    protected final SelenideElement modalWindow = element(Selectors.byXpath("//div[@class=\"ant-modal-body\"]"));
    protected final SelenideElement rusName = element(Selectors.byXpath("//label[text()=\"Наименование на русском\"]/parent::div/parent::div//input"));
    protected final SelenideElement kzName = element(Selectors.byXpath("//label[text()=\"Наименование на казахском\"]/parent::div/parent::div//input"));
    protected final SelenideElement kzNameLatinica = element(Selectors.byXpath("//label[text()=\"Наименование на казахском (латиница)\"]/parent::div/parent::div//input"));
    protected final SelenideElement engName = element(Selectors.byXpath("//label[text()=\"Наименование на английском\"]/parent::div/parent::div//input"));
    protected final SelenideElement createButton = element(Selectors.byXpath("//button[@class=\"ant-btn administration__button-blue\"]"));
    protected final SelenideElement cancelButton = element(Selectors.byXpath("//span[text()=\"Отмена\"]"));
    protected final SelenideElement editButton = element(Selectors.byXpath("//div[@class=\"ant-modal-body\"]//span[text()=\"Редактировать\"]"));
    protected final SelenideElement applyButton = element(Selectors.byXpath("//div[@class=\"ant-modal-body\"]//span[text()=\"Применить\"]"));
    protected final SelenideElement deactivationButton = element(Selectors.byXpath("//div[@class=\"ant-modal-body\"]//span[text()=\"Деактивировать\"]"));
    protected final SelenideElement activationButton = element(Selectors.byXpath("//div[@class=\"ant-modal-body\"]//span[text()=\"Активировать\"]"));
    protected final SelenideElement confirmAction = element(Selectors.byXpath("//div[@class=\"ant-popover-content\"]//button[@class=\"ant-btn ant-btn-primary administration__button-gold-small\"]"));
    protected final SelenideElement applySearch = element(Selectors.byXpath("//div[@class=\"ant-space-item\"]//span[text()=\"Применить\"]"));
    protected final SelenideElement resetSearch = element(Selectors.byXpath("//div[@class=\"ant-space-item\"]//span[text()=\"Сбросить\"]"));
    protected final SelenideElement searchInput = element(Selectors.byXpath("//input[@name=\"searchValue\"]"));
    protected final SelenideElement extendedSearch = element(Selectors.byXpath("//div[@class=\"filter\"]"));
    protected final SelenideElement closeModalWindow = element(Selectors.byXpath("//button[@aria-label=\"Close\"]"));
    protected final SelenideElement chooseSearchModule = element(Selectors.byXpath("//label[@title=\"Подсистема/модуль\"]/../../div[2]//input"));
    protected final SelenideElement chooseModule = element(Selectors.byXpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Подсистема/модуль\"]/../..//input"));


    protected void clearAndType(SelenideElement element, String value){
        while (!element.getAttribute("value").equals("")) element.sendKeys(Keys.BACK_SPACE);
        element.setValue(value);
    }

    @Step("Выбрать значение модуля в поиске")
    public void chooseSearchModule(String searchModule) {
        chooseSearchModule.click();
        int n = 20;
        int i = 0;
        while (element(Selectors.byXpath("//div[contains(@title,\"" + searchModule + "\")]")).is(Condition.not(visible))) {
            chooseSearchModule.sendKeys(Keys.ARROW_DOWN);
            i = i + 1;
            if (i == n) break;
        }
        $(By.xpath("//div[contains(@title,\"" + searchModule + "\")]")).click();
        $(By.xpath("//span[contains(@title,\"" + searchModule + "\")]")).shouldBe(visible);
    }

    @Step("Выбрать модуль")
    public void chooseModule(String module) {
        chooseModule.click();
        int n = 20;
        int i = 0;
        while (element(Selectors.byXpath("//div[contains(@title,\"" + module + "\")]")).is(Condition.not(visible))) {
            chooseModule.sendKeys(Keys.ARROW_DOWN);
            i = i + 1;
            if (i == n) break;
        }
        element(Selectors.byXpath("//div[contains(@title,\"" + module + "\")]")).click();
        $(By.xpath("//span[contains(@title,\"" + module + "\")]")).shouldBe(visible);
    }

    @Step("Выбрать значение статуса в поиске")
    public void fillSearchStatus(String status) {
        $(By.xpath("//span[text()=\"Выберите статус\"]/..//input")).click();
        $(By.xpath("//div[@title=\"" + status + "\"]")).click();
    }

    @Step("Нажать на кнопку создать")
    public void create() {
        createButton.shouldNotBe(disabled);
        createButton.click();
    }

    @Step("Нажать на кнопку отмена")
    public void cancel() {
        cancelButton.click();
    }

    @Step("Нажать на кнопку редактировать")
    public void pressEditButton() {
        editButton.click();
    }

}

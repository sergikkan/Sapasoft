package sapasoft.adm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RolesGroupsManagmentPage {

    public void open(){
        $(By.xpath("//div[@class='antd-pro-components-menu-page-index-items']/a[3]")).click();
        $(By.xpath("//div/h1")).shouldHave(text("Управление группами ролей"));
    }

    public void createNewRolesGroup() {
        $(By.xpath("//button/span[text()=\"Создать группу ролей\"]")).click();
        $(By.xpath("//div[@class=\"ant-modal-body\"]")).shouldBe(visible);

    }

    public void fillCode(String rolesGroupCode) {
        $(By.xpath("//input[@placeholder=\"Введите код группы\"]")).setValue(rolesGroupCode);
    }

    public void fillNames(String rusName, String engName){
        $(By.xpath("//label[text()=\"Наименование на русском\"]/parent::div/parent::div//input")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//label[text()=\"Наименование на русском\"]/parent::div/parent::div//input")).shouldHave(exactText(""));
        $(By.xpath("//label[text()=\"Наименование на русском\"]/parent::div/parent::div//input")).setValue(rusName);
        $(By.xpath("//label[text()=\"Наименование на казахском\"]/parent::div/parent::div//input")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//label[text()=\"Наименование на казахском\"]/parent::div/parent::div//input")).shouldHave(exactText(""));
        $(By.xpath("//label[text()=\"Наименование на казахском\"]/parent::div/parent::div//input")).setValue(rusName);
        $(By.xpath("//label[text()=\"Наименование на казахском (латиница)\"]/parent::div/parent::div//input")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//label[text()=\"Наименование на казахском (латиница)\"]/parent::div/parent::div//input")).shouldHave(exactText(""));
        $(By.xpath("//label[text()=\"Наименование на казахском (латиница)\"]/parent::div/parent::div//input")).setValue(engName);
    }

    public void chooseModule(String module) {
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Подсистема/модуль\"]/../..//input")).click();
        //if(module =="Отчетность"|| module =="Регистрация налогоплательщиков и ККМ" ||module =="АРМ ОГД" ||module == "Кабинет налогоплательщика" ){
        // $(By.xpath("//div[@class=\"ant-select-tree-list-holder-inner\"]")).hover();
        //$(By.xpath("//span[@title=\""+module+"\"]/ancestor::div[@class=\"rc-virtual-list-holder-inner\"]")).scrollIntoView(false);
        //$(By.xpath("//span[@title=\""+module+"\"]")).click();
        //}else{
        //$(By.xpath("//div[@class=\"ant-select-tree-list-holder-inner\"]/div[1]")).hover();
        //$(By.xpath("//span[text()=\"Лицевые счета\"]")).hover();
        //$(By.xpath("//span[text()=\"Лицевые счета\"]")).scrollIntoView("//span[@title=\""+module+"\"]");
        //$(By.xpath("//span[@title=\""+module+"\"]")).scrollIntoView(true);
        $(By.xpath("//span[@title=\""+module+"\"]")).click();

        //}
        $(By.xpath("//div[@class=\"ant-modal-body\"]//div[@class=\"ant-select-selection-overflow\"]")).click();
        $(By.xpath("//span[@title=\""+module+"\"]")).shouldBe(visible);
    }

    public void chooseDepartment(String rolesGroupDepartment) {
        $(By.xpath("//form/div/div[7]/div/div[2]/div/div/span/div[2]")).click();

        $(By.xpath("//div[@title=\""+rolesGroupDepartment+"\"]")).click();
        $(By.xpath("//div[@title=\""+rolesGroupDepartment+"\"]")).shouldBe(visible);
    }

    public void chooserolesGroupSubdivision() {
        // $(By.xpath("//div[@class=\"ant-modal-body\"]//span[text()=\"Выберите подразделение\"]")).click();
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Подразделение\"]/../../div[2]")).shouldNotBe(disabled);
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Подразделение\"]/../../div[2]")).click();
        $(By.xpath("//div[5]/div/div/div/div[2]/div[1]/div/div/div[1]")).click();
    }

    public void chooserolesGroupPosition() {
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Должность\"]/../..//input")).click();
        $(By.xpath("//div[6]/div/div/div/div[2]/div[1]/div/div/div[1]")).click();
    }

    public void chooseRoles() {
        $(By.xpath("//ul[@class=\"ant-list-items\"]/div[1]//span[@class=\"ant-checkbox\"]")).click();
        $(By.xpath("//*[@class=\"ant-btn administration__button-white administration__button-arrow\"][1]")).click();
        $(By.xpath("//div[text()=\"Выбранные роли\"]/parent::div//ul/div[1]")).shouldBe(visible);
    }

    //Кнопка создать
    public void create(){

        $(By.xpath("//button[@class=\"ant-btn administration__button-blue\"]")).shouldNotBe(disabled);
        $(By.xpath("//button[@class=\"ant-btn administration__button-blue\"]")).click();
    }

    public void checkRoleWasCreated(String rolesGroupRusName) {
        $(byText("Группа ролей успешно создана")).shouldBe(visible);
        $(By.xpath("//div[@class=\"ant-modal-content\"]")).shouldNotBe(visible);
        $(By.xpath("//tbody/tr[2]/td[2]")).shouldHave(text(rolesGroupRusName));
    }

    // Открыть роль
    public void openRolesGroup(){
        $(By.xpath("//tbody/tr[2]")).click();
        $(By.xpath("//div[text()=\"Роли\"]")).shouldBe(visible);
    }

    // Кнопка деактивировать группу ролей
    public void deactivateRolesGroup(){
        $(By.xpath("//div[@class=\"ant-modal-body\"]//span[text()=\"Деактивировать\"]")).click();
        $(By.xpath("//div[@class=\"ant-popover-content\"]//button[@class=\"ant-btn ant-btn-primary administration__button-gold-small\"]")).click();
        $(byText("Группа ролей успешно деактивирована")).shouldBe(visible);
    }

    // Кнопка активировать группу ролей
    public void activateRolesGroup(){
        $(By.xpath("//div[@class=\"ant-modal-body\"]//span[text()=\"Активировать\"]")).click();
        $(By.xpath("//div[@class=\"ant-popover-content\"]//button[@class=\"ant-btn ant-btn-primary administration__button-gold-small\"]")).click();
        $(byText("Группа ролей успешно активирована")).shouldBe(visible);
    }







    public void searchRolesGroup(String searchText){
        $(By.xpath("//input[@name=\"searchValue\"]")).setValue(searchText);
        $(By.xpath("//tbody/tr[2]")).shouldHave(text(searchText));

    }
    //Кнопка Расширенный поиск
    public void extendedSearch(){
        $(By.xpath("//div[@class=\"filter\"]")).click();
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Применить\"]")).shouldBe(visible);
    }

    // Выбрать значение статуса в поиске
    public void fillSearchStatus(String status){
        $(By.xpath("//span[text()=\"Выберите статус\"]/..//input")).click();
        $(By.xpath("//div[@title=\""+status+"\"]")).click();
    }

    // Кнопка Применить
    public void applySearch(){
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Применить\"]")).click();
    }

    // Кнопка Сбросить
    public void resetSearch(){
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Сбросить\"]")).click();
    }

    // Проверка, что статус соотвествует значению в поиске
    public void checkSearchStatus(String searchStatus) {
        $(By.xpath("//tbody/tr[2]/td[9]")).shouldHave(exactText(searchStatus));
    }

    // Проверка, что значение модуля соответствует значению в поиске
    public void checkSearchModule(String searchModule) {
        $(By.xpath("//tbody/tr[2]/td[3]")).shouldHave(text(searchModule));
    }

    public void chooseSearchModule(String searchModule){
        $(By.xpath("//label[@title=\"Подсистема/модуль\"]/ancestor::div[@class=\"ant-row ant-form-item\"]/div[2]")).click();
        $(By.xpath("//span[@title=\""+searchModule+"\"]")).click();

        // $(By.xpath("//div[@class=\"ant-modal-body\"]//div[@class=\"ant-select-selection-overflow\"]")).click();
        $(By.xpath("//span[@title=\""+searchModule+"\"]")).shouldBe(visible);
    }
}

package sapasoft.adm.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RolesGroupsManagmentPage {

    @Step("Открываем раздел \"Управление группами ролей\"")
    public void open(){
        $(By.xpath("//div[@class='antd-pro-components-menu-page-index-items']/a[3]")).click();
        $(By.xpath("//div/h1")).shouldHave(text("Управление группами ролей"));
    }

    @Step("Нажать на кнопку создать новую группу ролей")
    public void createNewRolesGroup() {
        $(By.xpath("//button/span[text()=\"Создать группу ролей\"]")).click();
        $(By.xpath("//div[@class=\"ant-modal-body\"]")).shouldBe(visible);

    }

    @Step("Ввести код группы ролей")
    public void fillCode(String rolesGroupCode) {
        $(By.xpath("//input[@placeholder=\"Введите код группы\"]")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//input[@placeholder=\"Введите код группы\"]")).setValue(rolesGroupCode);
    }

    @Step("Ввести наименования группы ролей")
    public void fillNames(String rusName, String engName){
        $(By.xpath("//label[text()=\"Наименование на русском\"]/parent::div/parent::div//input")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//label[text()=\"Наименование на казахском\"]/parent::div/parent::div//input")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//label[text()=\"Наименование на казахском (латиница)\"]/parent::div/parent::div//input")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $(By.xpath("//label[text()=\"Наименование на английском\"]/parent::div/parent::div//input")).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);

        $(By.xpath("//label[text()=\"Наименование на русском\"]/parent::div/parent::div//input")).sendKeys(rusName);
        Selenide.sleep(1000);
        $(By.xpath("//label[text()=\"Наименование на казахском\"]/parent::div/parent::div//input")).sendKeys(rusName);
        $(By.xpath("//label[text()=\"Наименование на казахском (латиница)\"]/parent::div/parent::div//input")).sendKeys(engName);
        $(By.xpath("//label[text()=\"Наименование на английском\"]/parent::div/parent::div//input")).sendKeys(engName);
    }

    @Step("Выбрать модуль группу ролей")
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
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Подсистема/модуль\"]/../..//input")).click();
        $(By.xpath("//span[@title=\""+module+"\"]")).shouldBe(visible);
    }

    @Step("Выбрать орган государственных доходов")
    public void chooseDepartment(String rolesGroupDepartment) {
        $(By.xpath("//span[@class=\"ant-input-group ant-input-group-compact\"]/div[2]//input")).click();
        $(By.xpath("//div[@title=\""+rolesGroupDepartment+"\"]")).click();

    }

    @Step("Выбрать подразделение")
    public void chooserolesGroupSubdivision() {
        // $(By.xpath("//div[@class=\"ant-modal-body\"]//span[text()=\"Выберите подразделение\"]")).click();
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Подразделение\"]/../../div[2]")).shouldNotBe(disabled);
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Подразделение\"]/../../div[2]")).click();
        $(By.xpath("//div[5]/div/div/div/div[2]/div[1]/div/div/div[1]")).click();
    }

    @Step("Выбрать должность")
    public void chooserolesGroupPosition() {
        $(By.xpath("//div[@class=\"ant-modal-body\"]//label[text()=\"Должность\"]/../..//input")).click();
        $(By.xpath("//div[6]/div/div/div/div[2]/div[1]/div/div/div[1]")).click();
    }

    @Step("Выбрать доступную роль")
    public void chooseRoles() {
        $(By.xpath("//ul[@class=\"ant-list-items\"]/div[1]//span[@class=\"ant-checkbox\"]")).click();
        $(By.xpath("//*[@class=\"ant-btn administration__button-white administration__button-arrow\"][1]")).click();
        $(By.xpath("//div[text()=\"Выбранные роли\"]/parent::div//ul/div[1]")).shouldBe(visible);
    }

    //Кнопка создать

    @Step("Нажать на кнопку создать")
    public void create(){
        $(By.xpath("//button[@class=\"ant-btn administration__button-blue\"]")).shouldNotBe(disabled);
        $(By.xpath("//button[@class=\"ant-btn administration__button-blue\"]")).click();
    }

    //Кнопка отмена
    @Step("Кнопка отмена")
    public void cancel(){
        $(By.xpath("//span[text()=\"Отмена\"]")).click();
    }

    @Step("Проверка, что роль была создана")
    public void checkRoleWasCreated(String rolesGroupRusName) {
        $(byText("Группа ролей успешно создана")).shouldBe(visible);
        $(By.xpath("//div[@class=\"ant-modal-content\"]")).shouldNotBe(visible);
        //Selenide.sleep(1000);
        //$(By.xpath("//tbody/tr[2]/td[2]")).shouldHave(text(rolesGroupRusName));
    }

    // Открыть роль
    @Step("Нажать на группу ролей для открытия информации")
    public void openRolesGroup(){
        $(By.xpath("//tbody/tr[2]")).click();
        $(By.xpath("//div[text()=\"Роли\"]")).shouldBe(visible);
    }

    //Редактировать группу ролей
    @Step("Нажать на кнопку редактировать")
    public void editRolesGroup(){
        $(By.xpath("//div[@class=\"ant-modal-body\"]//span[text()=\"Редактировать\"]")).click();
    }
    //Применить изменения
    @Step("Кнопка Применить в редактировании группы ролей")
    public void editRolesGroupApply() {
        $(By.xpath("//div[@class=\"ant-modal-body\"]//span[text()=\"Применить\"]")).click();
        $(byText("Группа ролей успешно изменена")).shouldBe(visible);
    }

    // Кнопка деактивировать группу ролей
    @Step("Нажать на кнопку деактивировать группу ролей")
    public void deactivateRolesGroup(){
        $(By.xpath("//div[@class=\"ant-modal-body\"]//span[text()=\"Деактивировать\"]")).click();
        $(By.xpath("//div[@class=\"ant-popover-content\"]//button[@class=\"ant-btn ant-btn-primary administration__button-gold-small\"]")).click();
        //$(byText("Группа ролей успешно деактивирована")).shouldBe(visible);
        $(By.xpath("//*[@class=\"ant-notification-notice-message\"]")).shouldHave(text("Группа ролей успешно деактивирована"));
    }

    // Кнопка активировать группу ролей
    @Step("Нажать на кнопку активировать группу ролей")
    public void activateRolesGroup(){
        $(By.xpath("//div[@class=\"ant-modal-body\"]//span[text()=\"Активировать\"]")).click();
        $(By.xpath("//div[@class=\"ant-popover-content\"]//button[@class=\"ant-btn ant-btn-primary administration__button-gold-small\"]")).click();
        $(byText("Группа ролей успешно активирована")).shouldBe(visible);
    }

    @Step("Поиск группы ролей по названию")
    public void searchRolesGroup(String searchText){
        $(By.xpath("//input[@name=\"searchValue\"]")).setValue(searchText);
        Selenide.sleep(1000);
        $(By.xpath("//tbody/tr[2]")).shouldHave(text(searchText));

    }
    //Кнопка Расширенный поиск
    @Step("Нажать на кнопку расширенный поиск")
    public void extendedSearch(){
        $(By.xpath("//div[@class=\"filter\"]")).click();
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Применить\"]")).shouldBe(visible);
    }

    // Выбрать значение статуса в поиске
    @Step("Выбрать статус в расширенном поиске")
    public void fillSearchStatus(String status){
        $(By.xpath("//span[text()=\"Выберите статус\"]/..//input")).click();
        $(By.xpath("//div[@title=\""+status+"\"]")).click();
    }

    // Кнопка Применить
    @Step("Нажать на кнопку применить в расширенном поиске")
    public void applySearch(){
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Применить\"]")).click();
        $(By.xpath("//div[@class=\"filter opened\"]")).click();
    }

    // Кнопка Сбросить
    @Step("Нажать на кнопку сбросить в расширенном поиске")
    public void resetSearch(){
        $(By.xpath("//div[@class=\"ant-space-item\"]//span[text()=\"Сбросить\"]")).click();
    }

    // Проверка, что статус соотвествует значению в поиске
    @Step("Проверка, что статус соотвествует значению в поиске")
    public void checkSearchStatus(String searchStatus) {
        $(By.xpath("//tbody/tr[2]/td[9]")).shouldHave(exactText(searchStatus));
    }

    // Проверка, что значение модуля соответствует значению в поиске
//    public void checkSearchModule(String searchModule) {
//        $(By.xpath("//tbody/tr[2]/td[3]")).shouldHave(text(searchModule));
//    }

    public void chooseSearchModule(String searchModule){
        $(By.xpath("//label[@title=\"Подсистема/модуль\"]/ancestor::div[@class=\"ant-row ant-form-item\"]/div[2]")).click();
        $(By.xpath("//span[@title=\""+searchModule+"\"]")).click();

        // $(By.xpath("//div[@class=\"ant-modal-body\"]//div[@class=\"ant-select-selection-overflow\"]")).click();
        $(By.xpath("//span[@title=\""+searchModule+"\"]")).shouldBe(visible);
    }

    @Step("Выбрать орган государственных доходов в расширенном поиске")
    public void chooseSearchDepartment(String rolesGroupDepartment) {
        $(By.xpath("//span[text()=\"Наименование ОГД\"]/..//input")).click();

        $(By.xpath("//div[@title=\""+rolesGroupDepartment+"\"]")).click();

        //$(By.xpath("//div[@title=\""+rolesGroupDepartment+"\"]")).shouldBe(visible);

    }

    @Step("Проверка, что значение органа государственных доходов соответствует значению в расширенном поиске")
    public void checkSearchDepartment(String searchDepartment){
        $(By.xpath("//tbody/tr[2]/td[3]")).shouldHave(exactText(searchDepartment));

    }

    @Step("Выбрать подразделение в расширенном поиске")
    public void chooserolesGroupSearchSubdivision(String searchSubdivision) {
        $(By.xpath("//label[text()=\"Подразделение\"]/../../div[2]")).shouldNotBe(disabled);
        $(By.xpath("//label[text()=\"Подразделение\"]/../../div[2]")).click();
        $(By.xpath("//div[text()=\""+searchSubdivision+"\"]")).click();
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
        $(By.xpath("//button[@aria-label=\"Close\"]")).click();
        $(By.xpath("//div[@class=\"ant-modal-body\"]")).shouldNotBe(visible);
    }

    @Step("Проверка что код уже зарегистрирован в системе")
    public void checkThatCodeExisted(String existRolesGroupCode) {
        $(By.xpath("//div[@class=\"ant-modal-body\"]")).shouldBe(visible);
        $(byText("Группа ролей с таким кодом уже существует в системе")).shouldBe(visible);
    }

    @Step("Проверка что название уже зарегистрировано в системе")
    public void checkThatCodeNameExist(String existRolesGroupRusName) {
        $(By.xpath("//div[@class=\"ant-modal-body\"]")).shouldBe(visible);
        $(byText("Группа ролей с таким названием уже существует в системе")).shouldBe(visible);
    }
}

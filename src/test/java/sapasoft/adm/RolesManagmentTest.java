package sapasoft.adm;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import sapasoft.adm.pages.Adm;
import sapasoft.adm.testconfigs.BaseSetings;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@DisplayName("Раздел \"Управление ролями\"")
public class RolesManagmentTest extends BaseSetings {


    /*Тестовые данные*/

    private String rolesModule = "АРМ ОГД"; //Название подсистемы/модуля при создании
    private String rolesCode = "new"+System.currentTimeMillis(); //Код роли при создании
    private String rolesRusName="Роль "+str();  //Наименование на русском и казахском при создании
    private String rolesEngName="Role "+ RandomStringUtils.randomAlphabetic(5); //Наименование на латинице при создании
    private String newRolesRusName="Роль "+str();  //Наименование на русском и казахском при редактировании
    private String newRolesEngName="Role "+RandomStringUtils.randomAlphabetic(5); //Наименование на латинице при редактировании
    private String level = "ДГД";  //Значение уровня при создании
    private String newLevel = "КГД";  //Значение уровня редактировании
    private String dateFrom=  date(); // Дата при создании
    private String existRolesRusName="Тестовая роль КНП два"; //Наименование существующей роли
    private String existRolesEngName="Test role KNP "; //Наименование существующей роли
    private String existRolesModule="Кабинет налогоплательщика"; //Модуль существующей роли, нужен для поиска и для того чтобы сформировать существующий код
    private String existCode="7776"; //Существующий код для проверки уникальности при создании
    private String searchStatus = "Неактивна"; //Значение статуса в расширенном поиске





    @Test
    @DisplayName("Создание роли")
    public void t1CreateNewRole() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rolesManagment().open();
        adm.rolesManagment().createNewRole();
        adm.rolesManagment().chooseModule(rolesModule);
        adm.rolesManagment().fillCode(rolesCode);
        adm.rolesManagment().chooseLevel(level);
        adm.rolesManagment().chooseDate(dateFrom);
        adm.rolesManagment().fillNames(rolesRusName, rolesEngName);
        adm.rolesManagment().chooseRights();
        adm.rolesManagment().create();
        adm.rolesManagment().checkRoleWasCreated(rolesRusName);
        adm.logOut();

    }

    @Test
    @DisplayName("Деактивация роли")
    public void t2DeactivateRole() {

        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rolesManagment().open();
        adm.rolesManagment().extendedSearch();
        adm.rolesManagment().fillSearchStatus("Активна"); // Ищем роль со статусом Активна
        adm.rolesManagment().applySearch();
        adm.rolesManagment().checkSearchStatus("Активна");
        adm.rolesManagment().openRole();
        adm.rolesManagment().deactivateRole();
        adm.rolesManagment().checkThatRoleDeactivated();
        adm.logOut();
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Активация роли")
    public void t3ActivateRole() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rolesManagment().open();
        adm.rolesManagment().extendedSearch();
        adm.rolesManagment().fillSearchStatus("Неактивна"); // Ищем роль со статусом Неактивна
        adm.rolesManagment().applySearch();
        adm.rolesManagment().checkSearchStatus("Неактивна");
        adm.rolesManagment().openRole();
        adm.rolesManagment().activateRole();
        adm.rolesManagment().checkThatRoleActivated();
        adm.logOut();
        //Configuration.holdBrowserOpen = true;
    }

    //Поиск роли
    @Test
    @DisplayName("Поиск роли")
    public void t4SearchRole(){
        Adm adm =new Adm();
        adm.logIn(login, password);
        adm.rolesManagment().open();
        adm.rolesManagment().searchRole(existRolesRusName); // Вводим в поисковую строку текст, система проверяет, что в таблице в первой строке есть роль с таким наименованием или кодом
        adm.logOut();
    }

    @Test
    @DisplayName("Расширенный поиск роли")
    public void t5ExtendedSearchRole(){
        Adm adm =new Adm();
        adm.logIn(login, password);
        adm.rolesManagment().open();
        adm.rolesManagment().extendedSearch();
        adm.rolesManagment().chooseSearchModule(existRolesModule);
        adm.rolesManagment().fillSearchStatus(searchStatus);
        adm.rolesManagment().applySearch();
        adm.rolesManagment().checkSearchModule(existRolesModule);
        adm.rolesManagment().checkSearchStatus(searchStatus);
        adm.logOut();
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Просмотр информации о роли")
    public void t6OpenRoleInformation() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rolesManagment().open();
        adm.rolesManagment().openRole();
        adm.rolesManagment().openRoleUsers();
        adm.rolesManagment().openRoleServiceInfo();
        adm.rolesManagment().closeRole();
        adm.logOut();
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Редактирование роли")
    public void t6EditRole(){
        Adm adm =new Adm();
        adm.logIn(login, password);
        adm.rolesManagment().open();
        adm.rolesManagment().extendedSearch();
        adm.rolesManagment().fillSearchStatus("Активна"); // Ищем роль со статусом Активна
        adm.rolesManagment().applySearch();
        adm.rolesManagment().checkSearchStatus("Активна");
        adm.rolesManagment().openRole();
        adm.rolesManagment().editRole();
        adm.rolesManagment().chooseLevel(newLevel);
        adm.rolesManagment().fillNames(newRolesRusName, newRolesEngName);
        adm.rolesManagment().editRoleApply();
        adm.rolesManagment().searchRole(newRolesRusName);
        adm.rolesManagment().checkLevel(newLevel);
        adm.logOut();
    }

    @Test
    @DisplayName("Проверка уникальных полей при создании роли")
    public void t7CheckUniqueFields() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rolesManagment().open();
        adm.rolesManagment().createNewRole();
        adm.rolesManagment().chooseModule(existRolesModule);
        adm.rolesManagment().fillCode(existCode);
        adm.rolesManagment().chooseLevel(level);
        adm.rolesManagment().chooseDate(dateFrom);
        adm.rolesManagment().fillNames(rolesRusName, rolesEngName);
        adm.rolesManagment().chooseRights();
        adm.rolesManagment().create();
        adm.rolesManagment().checkThatCodeExist();
        adm.rolesManagment().fillCode(rolesCode);
        adm.rolesManagment().fillNames(existRolesRusName, existRolesEngName);
        adm.rolesManagment().create();
        adm.rolesManagment().checkThatNamesExist();
        adm.rolesManagment().cancel();
        adm.logOut();
       //  Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Проверка обязательных  полей при создании роли")
    public void t8CheckRequiredFields() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rolesManagment().open();
        adm.rolesManagment().createNewRole();
        adm.rolesManagment().create();
        adm.rolesManagment().checkThatButtonDisabled();

    }

}

package sapasoft.adm;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sapasoft.adm.pages.Adm;
import sapasoft.adm.testconfigs.BaseSetings;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("Раздел \"Управление ролями\"")
public class RolesManagmentTest extends BaseSetings {


    /*Тестовые данные*/

    private String rolesModule = "Администрирование и мониторинг"; //Название подсистемы/модуля при создании
    private String rolesCode = "new" + System.currentTimeMillis(); //Код роли при создании
    private String rolesRusName = "Роль " + str();  //Наименование на русском и казахском при создании
    private String rolesEngName = "Role " + RandomStringUtils.randomAlphabetic(5); //Наименование на латинице при создании
    private String newRolesRusName = "Роль " + str();  //Наименование на русском и казахском при редактировании
    private String newRolesEngName = "Role " + RandomStringUtils.randomAlphabetic(5); //Наименование на латинице при редактировании
    private String level = "ДГД";  //Значение уровня при создании
    private String newLevel = "КГД";  //Значение уровня редактировании
    private String dateFrom = date(); // Дата при создании
    private String existRolesRusName = "Тестовая роль КНП два"; //Наименование существующей роли
    private String existRolesEngName = "Test role KNP "; //Наименование существующей роли
    private String existRolesModule = "Кабинет налогоплательщика"; //Модуль существующей роли, нужен для поиска и для того чтобы сформировать существующий код
    private String existCode = "7776"; //Существующий код для проверки уникальности при создании
    private String searchLevel = "КГД"; //Существующий уровень для проверки уникальности при создании
    private String searchStatus = "Неактивна"; //Значение статуса в расширенном поиске
    private String deactivationName = "Роль для деактивации Тест"; //Роль для деактивации и активации
    private String editRoleName = "Роль для редактирования Тест"; //Роль для деактивации и активации
    private String editRoleLevel = "ДГД"; //уровень для проверки при редактировании


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
    @DisplayName("Деактивация и активация роли")
    public void t2DeactivateActivateRole() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rolesManagment().open();
        adm.rolesManagment().searchRole(deactivationName);
        adm.rolesManagment().checkSearchStatus("Активна");
        adm.rolesManagment().openRole();
        adm.rolesManagment().deactivateRole();
        adm.rolesManagment().checkThatRoleDeactivated();
        adm.rolesManagment().clearSearchField();
        adm.rolesManagment().searchRole(deactivationName);
        adm.rolesManagment().checkSearchStatus("Неактивна");
        adm.rolesManagment().openRole();
        adm.rolesManagment().activateRole();
        adm.rolesManagment().checkThatRoleActivated();
        adm.rolesManagment().clearSearchField();
        adm.rolesManagment().searchRole(deactivationName);
        adm.rolesManagment().checkSearchStatus("Активна");
        adm.logOut();
    }

    @Test
    @DisplayName("Поиск роли")
    public void t3SearchRole() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rolesManagment().open();
        adm.rolesManagment().searchRole(existRolesRusName); // Вводим в поисковую строку текст, система проверяет, что в таблице в первой строке есть роль с таким наименованием или кодом
        adm.logOut();
    }

    @Test
    @DisplayName("Расширенный поиск роли")
    public void t4ExtendedSearchRole() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rolesManagment().open();
        adm.rolesManagment().extendedSearch();
        adm.rolesManagment().chooseSearchModule(existRolesModule);
        adm.rolesManagment().fillSearchStatus(searchStatus);
        adm.rolesManagment().chooseSearchLevel(searchLevel);
        adm.rolesManagment().applySearch();
        adm.rolesManagment().checkSearchModule(existRolesModule);
        adm.rolesManagment().checkSearchStatus(searchStatus);
        adm.rolesManagment().checkLevel(searchLevel);
        adm.logOut();
    }

    @Test
    @DisplayName("Просмотр информации о роли")
    public void t5OpenRoleInformation() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rolesManagment().open();
        adm.rolesManagment().openRole();
        adm.rolesManagment().openRoleUsers();
        adm.rolesManagment().openRoleServiceInfo();
        adm.rolesManagment().closeRole();
        adm.logOut();
    }

    @Test
    @DisplayName("Редактирование роли")
    public void t6EditRole() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rolesManagment().open();
        adm.rolesManagment().searchRole(editRoleName);
        adm.rolesManagment().checkSearchStatus("Активна");
        adm.rolesManagment().openRole();
        adm.rolesManagment().editRole();
        adm.rolesManagment().chooseLevel(newLevel);
        adm.rolesManagment().fillNames(newRolesRusName, newRolesEngName);
        adm.rolesManagment().editRoleApply();
        adm.rolesManagment().clearSearchField();
        adm.rolesManagment().searchRole(newRolesRusName);
        adm.rolesManagment().checkLevel(newLevel);
        adm.rolesManagment().openRole();
        adm.rolesManagment().editRole();
        adm.rolesManagment().chooseLevel(editRoleLevel);
        adm.rolesManagment().fillNames(editRoleName, newRolesEngName);
        adm.rolesManagment().editRoleApply();
        adm.rolesManagment().clearSearchField();
        adm.rolesManagment().searchRole(editRoleName);
        adm.rolesManagment().checkLevel(editRoleLevel);
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
    }

    @Test
    @DisplayName("Проверка обязательных полей при создании роли")
    public void t8CheckRequiredFields() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rolesManagment().open();
        adm.rolesManagment().createNewRole();
        adm.rolesManagment().checkThatButtonDisabled();
        adm.rolesManagment().cancel();
        adm.logOut();
    }

}

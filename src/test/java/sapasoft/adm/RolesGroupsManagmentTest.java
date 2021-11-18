package sapasoft.adm;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import sapasoft.adm.pages.Adm;
import sapasoft.adm.testconfigs.BaseSetings;
@DisplayName("Раздел \"Управление группами ролей\"")
public class RolesGroupsManagmentTest extends BaseSetings {

    /*Тестовые данные*/

    private String rolesGroupCode="GroupCode"+System.currentTimeMillis();
    private String existRolesGroupCode="KNP_GROUP_1";
    private String rolesGroupRusName="Группа ролей "+str();
    private String existRolesGroupRusName="тестовые данные";
    private String rolesGroupEngName="Roles group "+ RandomStringUtils.randomAlphabetic(5);
    private String rolesGroupModule="Лицевые счета";
    private String rolesGroupDepartment="Комитет государственных доходов Министерства финансов Республики Казахстан";
    private String rolesGroupSearchDepartment="ДГД по Акмолинской области";
    private String searchStatus= "Активна";
    private String existRolesGroupModule= "Лицевые счета";
    private String searchSubdivision= "Управление государственных услуг";
    private String newRolesGroupRusName="Группа ролей "+str();
    private String newRolesGroupEngName="Roles group "+ RandomStringUtils.randomAlphabetic(5);





    @Test
    @DisplayName("Создание новой группы ролей")
    public void t1CreateRolesGroup(){
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rolesGroupsManagment().open();
        adm.rolesGroupsManagment().createNewRolesGroup();
        adm.rolesGroupsManagment().fillCode(rolesGroupCode);
        adm.rolesGroupsManagment().chooseModule(rolesGroupModule);
        adm.rolesGroupsManagment().chooseDepartment(rolesGroupDepartment);
        adm.rolesGroupsManagment().fillNames(rolesGroupRusName, rolesGroupEngName);
        adm.rolesGroupsManagment().chooserolesGroupSubdivision();
        adm.rolesGroupsManagment().chooserolesGroupPosition();
        adm.rolesGroupsManagment().chooseRoles();
        adm.rolesGroupsManagment().create();
        adm.rolesGroupsManagment().checkRoleWasCreated(rolesGroupRusName);
        adm.rolesGroupsManagment().searchRolesGroup(rolesGroupRusName);
        adm.logOut();
    }

    @Test
    @DisplayName("Деактивация группы ролей")
    public void t2DeactivateRolesGroup() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rolesGroupsManagment().open();
        adm.rolesGroupsManagment().extendedSearch();
        adm.rolesGroupsManagment().fillSearchStatus("Активна"); // Ищем группу ролей со статусом Активна
        adm.rolesGroupsManagment().applySearch();
        adm.rolesGroupsManagment().checkSearchStatus("Активна");
        adm.rolesGroupsManagment().openRolesGroup();
        adm.rolesGroupsManagment().deactivateRolesGroup();
        adm.logOut();
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Активация группы ролей")
    public void t3ActivateRolesGroup() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rolesGroupsManagment().open();
        adm.rolesGroupsManagment().extendedSearch();
        adm.rolesGroupsManagment().fillSearchStatus("Неактивна"); // Ищем группу ролей со статусом Неактивна
        adm.rolesGroupsManagment().applySearch();
        adm.rolesGroupsManagment().checkSearchStatus("Неактивна");
        adm.rolesGroupsManagment().openRolesGroup();
        adm.rolesGroupsManagment().activateRolesGroup();
        adm.logOut();
        //Configuration.holdBrowserOpen = true;
    }

    //Поиск группы ролей
    @Test
    @DisplayName("Поиск группы ролей")
    public void t4SearchRolesGroup() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rolesGroupsManagment().open();
        adm.rolesGroupsManagment().searchRolesGroup(existRolesGroupRusName); // Вводим в поисковую строку текст, система проверяет, что в таблице в первой строке есть Группа ролей с таким наименованием или кодом
        adm.logOut();
    }

    @Test
    @DisplayName("Расширенный поиск группы ролей")
    public void t5ExtendedSearchRolesGroup(){
        Adm adm =new Adm();
        adm.logIn(login, password);
        adm.rolesGroupsManagment().open();
        adm.rolesGroupsManagment().extendedSearch();
        adm.rolesGroupsManagment().fillSearchStatus(searchStatus);
        //adm.rolesGroupsManagment().chooseSearchModule(existRolesGroupModule);
        adm.rolesGroupsManagment().chooseSearchDepartment(rolesGroupSearchDepartment);
        adm.rolesGroupsManagment().chooserolesGroupSearchSubdivision(searchSubdivision);
        adm.rolesGroupsManagment().applySearch();
        //adm.rolesGroupsManagment().checkSearchModule(existRolesGroupModule);
        adm.rolesGroupsManagment().checkSearchStatus(searchStatus);
        adm.rolesGroupsManagment().checkSearchDepartment(rolesGroupSearchDepartment);
        adm.rolesGroupsManagment().checkSearchSubdivision(searchSubdivision);
        adm.logOut();
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Просмотр информации о группе ролей")
    public void t6OpenRolesGroupInformation() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rolesGroupsManagment().open();
        adm.rolesGroupsManagment().openRolesGroup();
        adm.rolesGroupsManagment().openRolesGroupUsers();
        adm.rolesGroupsManagment().openRolesGroupServiceInfo();
        adm.rolesGroupsManagment().closeRolesGroup();
        adm.logOut();
       // Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Редактирование группы ролей")
    public void t7EditRolesGroup(){
        Adm adm =new Adm();
        adm.logIn(login, password);
        adm.rolesGroupsManagment().open();
        adm.rolesGroupsManagment().extendedSearch();
        adm.rolesGroupsManagment().fillSearchStatus("Активна"); // Ищем группу ролей со статусом Активна
        adm.rolesGroupsManagment().applySearch();
        adm.rolesGroupsManagment().checkSearchStatus("Активна");
        adm.rolesGroupsManagment().openRolesGroup();
        adm.rolesGroupsManagment().editRolesGroup();
        adm.rolesGroupsManagment().fillNames(newRolesGroupRusName, newRolesGroupEngName);
        adm.rolesGroupsManagment().editRolesGroupApply();
        adm.rolesGroupsManagment().searchRolesGroup(newRolesGroupRusName);
        adm.logOut();
    }

    @Test
    @DisplayName("Проверка уникальных полей при создании группы ролей")
    public void t8CheckUniqueFields() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rolesGroupsManagment().open();
        adm.rolesGroupsManagment().createNewRolesGroup();
        adm.rolesGroupsManagment().fillCode(existRolesGroupCode);
        adm.rolesGroupsManagment().chooseModule(rolesGroupModule);
        adm.rolesGroupsManagment().chooseDepartment(rolesGroupDepartment);
        adm.rolesGroupsManagment().fillNames(rolesGroupRusName, rolesGroupEngName);
        adm.rolesGroupsManagment().chooserolesGroupSubdivision();
        adm.rolesGroupsManagment().chooserolesGroupPosition();
        adm.rolesGroupsManagment().chooseRoles();
        adm.rolesGroupsManagment().create();
        adm.rolesGroupsManagment().checkThatCodeExisted(existRolesGroupCode);
        adm.rolesGroupsManagment().fillCode(rolesGroupCode);
        adm.rolesGroupsManagment().fillNames(existRolesGroupRusName, rolesGroupEngName);
        adm.rolesGroupsManagment().create();
        adm.rolesGroupsManagment().checkThatCodeNameExist(existRolesGroupRusName);
        adm.rolesGroupsManagment().cancel();
        adm.logOut();

    }



}

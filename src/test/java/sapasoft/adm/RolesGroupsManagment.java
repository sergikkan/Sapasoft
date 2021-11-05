package sapasoft.adm;

import com.codeborne.selenide.Configuration;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import sapasoft.adm.pages.Adm;
import sapasoft.adm.testconfigs.BaseSetings;

public class RolesGroupsManagment extends BaseSetings {

    /*Тестовые данные*/

    private String rolesGroupCode="GroupCode"+System.currentTimeMillis();;
    private String rolesGroupRusName="Группа ролей "+str();
    private String existRolesGroupRusName="тестовые данные";
    private String rolesGroupEngName="Roles group "+ RandomStringUtils.randomAlphabetic(5);
    private String rolesGroupModule="Лицевые счета";
    private String rolesGroupDepartment="Комитет государственных доходов Министерства финансов Республики Казахстан";
    private String searchStatus= "Активна";
    private String existRolesGroupModule= "Реабилитация и банкротство";





    @Test
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
        adm.logOut();
    }

    @Test
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
    public void t4SearchRolesGroup() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rolesGroupsManagment().open();
        adm.rolesGroupsManagment().searchRolesGroup(existRolesGroupRusName); // Вводим в поисковую строку текст, система проверяет, что в таблице в первой строке есть Группа ролей с таким наименованием или кодом
        adm.logOut();
    }

    @Test
    public void t5ExtendedSearchRolesGroup(){
        Adm adm =new Adm();
        adm.logIn(login, password);
        adm.rolesGroupsManagment().open();
        adm.rolesGroupsManagment().extendedSearch();
        adm.rolesGroupsManagment().chooseSearchModule(existRolesGroupModule);
        adm.rolesGroupsManagment().fillSearchStatus(searchStatus);
        adm.rolesGroupsManagment().chooseDepartment(rolesGroupDepartment);
        adm.rolesGroupsManagment().applySearch();

        //adm.rolesGroupsManagment().checkSearchModule(existRolesGroupModule);
        adm.rolesGroupsManagment().checkSearchStatus(searchStatus);
        // adm.logOut();
        Configuration.holdBrowserOpen = true;
    }

}

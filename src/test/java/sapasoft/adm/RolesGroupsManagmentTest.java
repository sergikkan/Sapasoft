package sapasoft.adm;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sapasoft.adm.pages.Adm;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

@DisplayName("Раздел \"Управление группами ролей\"")
public class RolesGroupsManagmentTest extends BaseTest {

    /*Тестовые данные*/

    private String rolesGroupCode = "GroupCode" + System.currentTimeMillis();
    private String existRolesGroupCode = "KNP_GROUP_1";
    private String rolesGroupRusName = "Группа ролей " + str();
    private String rolesGroupKzName = "Группа ролей " + str();
    private String rolesGroupKzLatName = "Roles group " + RandomStringUtils.randomAlphabetic(5);
    private String rolesGroupEngName = "Roles group " + RandomStringUtils.randomAlphabetic(5);
    private String newRolesGroupRusName = "Группа ролей " + str();
    private String newRolesGroupKzName = "Группа ролей " + str();
    private String newRolesGroupKzLatName = "Roles group " + RandomStringUtils.randomAlphabetic(5);
    private String newRolesGroupEngName = "Roles group " + RandomStringUtils.randomAlphabetic(5);
    private String existRolesGroupRusName = "тестовые данные";
    private String rolesGroupModule = "Лицевые счета";
    private String rolesGroupDepartment = "ДГД по г.Алматы";
    private String rolesGroupSubdivision= "Отдел рисков";
    private String rolesGroupPosition= "Главный специалист";
    private String searchStatus = "Активна";
    private String searchRolesGroupModule = "Администрирование и мониторинг";
    private String rolesGroupSearchDepartment = "ДГД по Акмолинской области";
    private String searchSubdivision = "Управление государственных услуг";
    private String editRolesGroup = "Группа ролей для редактирования Тест";
    private String deactivationRolesGroup = "Группа ролей для деактивации";


    @Test
    @DisplayName("Создание новой группы ролей")
    public void t1CreateRolesGroup() {
        Adm adm = new Adm();
        adm.logIn(LOGIN, PASSWORD);
        adm.rolesGroupsManagment().open();
        adm.rolesGroupsManagment().createNewRolesGroup();
        adm.rolesGroupsManagment().fillCode(rolesGroupCode);
        adm.rolesGroupsManagment().chooseModule(rolesGroupModule);
        adm.rolesGroupsManagment().chooseDepartment(rolesGroupDepartment);
        adm.rolesGroupsManagment().fillNames(rolesGroupRusName, rolesGroupKzName, rolesGroupKzLatName, rolesGroupEngName);
        adm.rolesGroupsManagment().chooserolesGroupSubdivision(rolesGroupSubdivision);
        adm.rolesGroupsManagment().chooserolesGroupPosition(rolesGroupPosition);
        adm.rolesGroupsManagment().chooseRoles();
        adm.rolesGroupsManagment().create();
        adm.rolesGroupsManagment().checkRoleWasCreated();
        adm.rolesGroupsManagment().searchRolesGroup(rolesGroupRusName);
        adm.logOut();
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Деактивация и активация группы ролей")
    public void t2DeactivateActivateRolesGroup() {
        Adm adm = new Adm();
        adm.logIn(LOGIN, PASSWORD);
        adm.rolesGroupsManagment().open();
        adm.rolesGroupsManagment().searchRolesGroup(deactivationRolesGroup);
        adm.rolesGroupsManagment().checkSearchStatus("Активна");
        adm.rolesGroupsManagment().openRolesGroup();
        adm.rolesGroupsManagment().deactivateRolesGroup();
        adm.rolesGroupsManagment().searchRolesGroup(deactivationRolesGroup);
        adm.rolesGroupsManagment().checkSearchStatus("Неактивна");
        adm.rolesGroupsManagment().openRolesGroup();
        adm.rolesGroupsManagment().activateRolesGroup();
        adm.rolesGroupsManagment().searchRolesGroup(deactivationRolesGroup);
        adm.rolesGroupsManagment().checkSearchStatus("Активна");
        adm.logOut();
    }

    @Test
    @DisplayName("Поиск группы ролей")
    public void t3SearchRolesGroup() {
        Adm adm = new Adm();
        adm.logIn(LOGIN, PASSWORD);
        adm.rolesGroupsManagment().open();
        adm.rolesGroupsManagment().searchRolesGroup(existRolesGroupRusName); // Вводим в поисковую строку текст, система проверяет, что в таблице в первой строке есть Группа ролей с таким наименованием или кодом
        adm.logOut();
    }

    @Test
    @DisplayName("Расширенный поиск группы ролей")
    public void t4ExtendedSearchRolesGroup() {
        Adm adm = new Adm();
        adm.logIn(LOGIN, PASSWORD);
        adm.rolesGroupsManagment().open();
        adm.rolesGroupsManagment().extendedSearch();
        adm.rolesGroupsManagment().fillSearchStatus(searchStatus);
        adm.rolesGroupsManagment().chooseSearchModule(searchRolesGroupModule);
        adm.rolesGroupsManagment().chooseSearchDepartment(rolesGroupSearchDepartment);
        adm.rolesGroupsManagment().chooserolesGroupSearchSubdivision(searchSubdivision);
        adm.rolesGroupsManagment().applySearch();
        adm.rolesGroupsManagment().checkSearchStatus(searchStatus);
        adm.rolesGroupsManagment().openRolesGroup();
        adm.rolesGroupsManagment().checkSearchModule(searchRolesGroupModule);
        adm.rolesGroupsManagment().closeRolesGroup();
        adm.rolesGroupsManagment().checkSearchDepartment(rolesGroupSearchDepartment);
        adm.rolesGroupsManagment().checkSearchSubdivision(searchSubdivision);
        adm.logOut();
    }

    @Test
    @DisplayName("Просмотр информации о группе ролей")
    public void t5OpenRolesGroupInformation() {
        Adm adm = new Adm();
        adm.logIn(LOGIN, PASSWORD);
        adm.rolesGroupsManagment().open();
        adm.rolesGroupsManagment().openRolesGroup();
        adm.rolesGroupsManagment().openRolesGroupUsers();
        adm.rolesGroupsManagment().openRolesGroupServiceInfo();
        adm.rolesGroupsManagment().closeRolesGroup();
        adm.logOut();

    }

    @Test
    @DisplayName("Редактирование группы ролей")
    public void t6EditRolesGroup() {
        Adm adm = new Adm();
        adm.logIn(LOGIN, PASSWORD);
        adm.rolesGroupsManagment().open();
        adm.rolesGroupsManagment().searchRolesGroup(editRolesGroup);
        adm.rolesGroupsManagment().checkSearchStatus("Активна");
        adm.rolesGroupsManagment().openRolesGroup();
        adm.rolesGroupsManagment().pressEditButton();
        adm.rolesGroupsManagment().fillNames(newRolesGroupRusName, newRolesGroupKzName, newRolesGroupKzLatName, newRolesGroupEngName);
        adm.rolesGroupsManagment().editRolesGroupApply();
        adm.rolesGroupsManagment().searchRolesGroup(newRolesGroupRusName);
        adm.rolesGroupsManagment().openRolesGroup();
        adm.rolesGroupsManagment().pressEditButton();
        adm.rolesGroupsManagment().fillNames(editRolesGroup,newRolesGroupKzName, newRolesGroupKzLatName, newRolesGroupEngName);
        adm.rolesGroupsManagment().editRolesGroupApply();
        adm.rolesGroupsManagment().searchRolesGroup(editRolesGroup);
        adm.logOut();
    }

    @Test
    @DisplayName("Проверка уникальных полей при создании группы ролей")
    public void t7CheckUniqueFields() {
        Adm adm = new Adm();
        adm.logIn(LOGIN, PASSWORD);
        adm.rolesGroupsManagment().open();
        adm.rolesGroupsManagment().createNewRolesGroup();
        adm.rolesGroupsManagment().fillCode(existRolesGroupCode);
        adm.rolesGroupsManagment().chooseModule(rolesGroupModule);
        adm.rolesGroupsManagment().chooseDepartment(rolesGroupDepartment);
        adm.rolesGroupsManagment().fillNames(rolesGroupRusName, rolesGroupKzName, rolesGroupKzLatName, rolesGroupEngName);
        adm.rolesGroupsManagment().chooserolesGroupSubdivision(rolesGroupSubdivision);
        adm.rolesGroupsManagment().chooserolesGroupPosition(rolesGroupPosition);
        adm.rolesGroupsManagment().chooseRoles();
        adm.rolesGroupsManagment().create();
        adm.rolesGroupsManagment().checkThatCodeExist();
        adm.rolesGroupsManagment().fillCode(rolesGroupCode);
        adm.rolesGroupsManagment().fillNames(existRolesGroupRusName, newRolesGroupKzName, newRolesGroupKzLatName, rolesGroupEngName);
        adm.rolesGroupsManagment().create();
        adm.rolesGroupsManagment().checkThatCodeNameExist();
        adm.rolesGroupsManagment().cancel();
        adm.logOut();

    }

}

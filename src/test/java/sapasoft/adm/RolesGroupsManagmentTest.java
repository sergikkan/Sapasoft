//package sapasoft.adm;
//
//import com.codeborne.selenide.Configuration;
//import io.qameta.allure.junit4.DisplayName;
//import org.apache.commons.lang.RandomStringUtils;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import sapasoft.adm.pages.Adm;
//import sapasoft.adm.testconfigs.BaseSetings;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//
//@DisplayName("Раздел \"Управление группами ролей\"")
//public class RolesGroupsManagmentTest extends BaseSetings {
//
//    /*Тестовые данные*/
//
//    private String rolesGroupCode = "GroupCode" + System.currentTimeMillis();
//    private String existRolesGroupCode = "KNP_GROUP_1";
//    private String rolesGroupRusName = "Группа ролей " + str();
//    private String existRolesGroupRusName = "тестовые данные";
//    private String rolesGroupEngName = "Roles group " + RandomStringUtils.randomAlphabetic(5);
//    private String rolesGroupModule = "Лицевые счета";
//    private String rolesGroupDepartment = "Комитет государственных доходов Министерства финансов Республики Казахстан";
//    private String rolesGroupSubdivision= "Юридическое управление";
//
//    private String searchStatus = "Активна";
//    private String searchRolesGroupModule = "Администрирование и мониторинг";
//    private String rolesGroupSearchDepartment = "ДГД по Акмолинской области";
//    private String searchSubdivision = "Управление государственных услуг";
//    private String newRolesGroupRusName = "Группа ролей " + str();
//    private String newRolesGroupEngName = "Roles group " + RandomStringUtils.randomAlphabetic(5);
//    private String editRolesGroup = "Группа ролей для редактирования Тест";
//    private String deactivationRolesGroup = "Группа ролей для деактивации";
//
//
//    //@Test
//    @DisplayName("Создание новой группы ролей")
//    public void t1CreateRolesGroup() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.rolesGroupsManagment().open();
//        adm.rolesGroupsManagment().createNewRolesGroup();
//        adm.rolesGroupsManagment().fillCode(rolesGroupCode);
//        adm.rolesGroupsManagment().chooseModule(rolesGroupModule);
//        adm.rolesGroupsManagment().chooseDepartment(rolesGroupDepartment);
//        adm.rolesGroupsManagment().fillNames(rolesGroupRusName, rolesGroupEngName);
//        adm.rolesGroupsManagment().chooserolesGroupSubdivision(rolesGroupSubdivision);
//        adm.rolesGroupsManagment().chooserolesGroupPosition();
//        adm.rolesGroupsManagment().chooseRoles();
//        adm.rolesGroupsManagment().create();
//        adm.rolesGroupsManagment().checkRoleWasCreated();
//        adm.rolesGroupsManagment().searchRolesGroup(rolesGroupRusName);
//        adm.logOut();
//        //Configuration.holdBrowserOpen = true;
//    }
//
//    @Test
//    @DisplayName("Деактивация и активация группы ролей")
//    public void t2DeactivateActivateRolesGroup() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.rolesGroupsManagment().open();
//        adm.rolesGroupsManagment().searchRolesGroup(deactivationRolesGroup);
//        adm.rolesGroupsManagment().checkSearchStatus("Активна");
//        adm.rolesGroupsManagment().openRolesGroup();
//        adm.rolesGroupsManagment().deactivateRolesGroup();
//        adm.rolesGroupsManagment().clearSearchField();
//        adm.rolesGroupsManagment().searchRolesGroup(deactivationRolesGroup);
//        adm.rolesGroupsManagment().checkSearchStatus("Неактивна");
//        adm.rolesGroupsManagment().openRolesGroup();
//        adm.rolesGroupsManagment().activateRolesGroup();
//        adm.rolesGroupsManagment().clearSearchField();
//        adm.rolesGroupsManagment().searchRolesGroup(deactivationRolesGroup);
//        adm.rolesGroupsManagment().checkSearchStatus("Активна");
//        adm.logOut();
//    }
//
//    @Test
//    @DisplayName("Поиск группы ролей")
//    public void t3SearchRolesGroup() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.rolesGroupsManagment().open();
//        adm.rolesGroupsManagment().searchRolesGroup(existRolesGroupRusName); // Вводим в поисковую строку текст, система проверяет, что в таблице в первой строке есть Группа ролей с таким наименованием или кодом
//        adm.logOut();
//    }
//
//    @Test
//    @DisplayName("Расширенный поиск группы ролей")
//    public void t4ExtendedSearchRolesGroup() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.rolesGroupsManagment().open();
//        adm.rolesGroupsManagment().extendedSearch();
//        adm.rolesGroupsManagment().fillSearchStatus(searchStatus);
//        adm.rolesGroupsManagment().chooseSearchModule(searchRolesGroupModule);
//        adm.rolesGroupsManagment().chooseSearchDepartment(rolesGroupSearchDepartment);
//        adm.rolesGroupsManagment().chooserolesGroupSearchSubdivision(searchSubdivision);
//        adm.rolesGroupsManagment().applySearch();
//        adm.rolesGroupsManagment().checkSearchStatus(searchStatus);
//        adm.rolesGroupsManagment().openRolesGroup();
//        adm.rolesGroupsManagment().checkSearchModule(searchRolesGroupModule);
//        adm.rolesGroupsManagment().closeRolesGroup();
//        adm.rolesGroupsManagment().checkSearchDepartment(rolesGroupSearchDepartment);
//        adm.rolesGroupsManagment().checkSearchSubdivision(searchSubdivision);
//        adm.logOut();
//    }
//
//    @Test
//    @DisplayName("Просмотр информации о группе ролей")
//    public void t5OpenRolesGroupInformation() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.rolesGroupsManagment().open();
//        adm.rolesGroupsManagment().openRolesGroup();
//        adm.rolesGroupsManagment().openRolesGroupUsers();
//        adm.rolesGroupsManagment().openRolesGroupServiceInfo();
//        adm.rolesGroupsManagment().closeRolesGroup();
//        adm.logOut();
//
//    }
//
//    @Test
//    @DisplayName("Редактирование группы ролей")
//    public void t6EditRolesGroup() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.rolesGroupsManagment().open();
//        adm.rolesGroupsManagment().searchRolesGroup(editRolesGroup);
//        adm.rolesGroupsManagment().checkSearchStatus("Активна");
//        adm.rolesGroupsManagment().openRolesGroup();
//        adm.rolesGroupsManagment().editRolesGroup();
//        adm.rolesGroupsManagment().fillNames(newRolesGroupRusName, newRolesGroupEngName);
//        adm.rolesGroupsManagment().editRolesGroupApply();
//        adm.rolesGroupsManagment().clearSearchField();
//        adm.rolesGroupsManagment().searchRolesGroup(newRolesGroupRusName);
//        adm.rolesGroupsManagment().openRolesGroup();
//        adm.rolesGroupsManagment().editRolesGroup();
//        adm.rolesGroupsManagment().fillNames(editRolesGroup, newRolesGroupEngName);
//        adm.rolesGroupsManagment().editRolesGroupApply();
//        adm.rolesGroupsManagment().clearSearchField();
//        adm.rolesGroupsManagment().searchRolesGroup(editRolesGroup);
//        adm.logOut();
//    }
//
//    @Test
//    @DisplayName("Проверка уникальных полей при создании группы ролей")
//    public void t7CheckUniqueFields() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.rolesGroupsManagment().open();
//        adm.rolesGroupsManagment().createNewRolesGroup();
//        adm.rolesGroupsManagment().fillCode(existRolesGroupCode);
//        adm.rolesGroupsManagment().chooseModule(rolesGroupModule);
//        adm.rolesGroupsManagment().chooseDepartment(rolesGroupDepartment);
//        adm.rolesGroupsManagment().fillNames(rolesGroupRusName, rolesGroupEngName);
//        adm.rolesGroupsManagment().chooserolesGroupSubdivision(rolesGroupSubdivision);
//        adm.rolesGroupsManagment().chooserolesGroupPosition();
//        adm.rolesGroupsManagment().chooseRoles();
//        adm.rolesGroupsManagment().create();
//        adm.rolesGroupsManagment().checkThatCodeExist();
//        adm.rolesGroupsManagment().fillCode(rolesGroupCode);
//        adm.rolesGroupsManagment().fillNames(existRolesGroupRusName, rolesGroupEngName);
//        adm.rolesGroupsManagment().create();
//        adm.rolesGroupsManagment().checkThatCodeNameExist();
//        adm.rolesGroupsManagment().cancel();
//        adm.logOut();
//
//    }
//
//}

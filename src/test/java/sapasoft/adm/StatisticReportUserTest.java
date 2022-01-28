//package sapasoft.adm;
//
//import io.qameta.allure.junit4.DisplayName;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import sapasoft.adm.pages.Adm;
//import sapasoft.adm.testconfigs.BaseSetings;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@DisplayName("Раздел Статистические отчеты, отчет по пользователям")
//public class StatisticReportUserTest extends BaseSetings {
//
//    /*Данные для отчета пользователям*/
//    String userLogin = "fdfdfdf";
//    String userName = "Махамбетов";
//    String whoRegister = "naik";
//    String ipAdress = "123456789";
//    String status = "Удалена";
//    String dateFrom = "30.12.2021";
//    String dateTo = "20.01.2022";
//    String subdivision = "Управление администрирования акцизов";
//    String position = "Руководитель управления";
//    String module = "Администрирование и мониторинг";
//    String userType = "Аудитор";
//    String department = "Комитет государственных доходов Министерства финансов Республики Казахстан";
//
//    @Test
//    @DisplayName("Открыть отчет по пользователям")
//    public void t1UsersReport() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.statisticUserReport().open();
//        adm.statisticUserReport().openUsers();
//        adm.logOut();
//        // Configuration.holdBrowserOpen = true;
//    }
//
//    @Test
//    @DisplayName("Отчет по пользователям, отфильтрованный по учетной записи")
//    public void t2UserLoginSearch() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.statisticUserReport().open();
//        adm.statisticUserReport().openUsers();
//        adm.statisticUserReport().fillUsername(userLogin);
//        adm.statisticUserReport().formReportButton();
//        adm.logOut();
//    }
//
//    @Test
//    @DisplayName("Отчет по пользователям, отфильтрованный по ФИО")
//    public void t3NameSearch() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.statisticUserReport().open();
//        adm.statisticUserReport().openUsers();
//        adm.statisticUserReport().fillName(userName);
//        adm.statisticUserReport().formReportButton();
//        adm.statisticUserReport().checkName(userName);
//        adm.logOut();
//    }
//
//    @Test
//    @DisplayName("Отчет по пользователям, отфильтрованный по полю кем зарегистрирован")
//    public void t4whoRegisterSearch() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.statisticUserReport().open();
//        adm.statisticUserReport().openUsers();
//        adm.statisticUserReport().fillWhoRegister(whoRegister);
//        adm.statisticUserReport().formReportButton();
//        adm.statisticUserReport().checkWhoRegister(whoRegister);
//        adm.logOut();
//    }
//
//    @Test
//    @DisplayName("Отчет по пользователям, отфильтрованный по полю IP адрес")
//    public void t5ipAdressSearch() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.statisticUserReport().open();
//        adm.statisticUserReport().openUsers();
//        adm.statisticUserReport().fillIPAdress(ipAdress);
//        adm.statisticUserReport().formReportButton();
//        adm.statisticUserReport().checkIPAdress(ipAdress);
//        adm.logOut();
//    }
//
//    @Test
//    @DisplayName("Отчет по пользователям, отфильтрованный по статусу")
//    public void t6StatusSearch() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.statisticUserReport().open();
//        adm.statisticUserReport().openUsers();
//        adm.statisticUserReport().chooseStatus(status);
//        adm.statisticUserReport().formReportButton();
//        adm.statisticUserReport().checkStatus(status);
//        adm.logOut();
//    }
//
//    @Test
//    @DisplayName("Отчет по пользователям, отфильтрованный по дате регистрации")
//    public void t7checkDateSearch() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.statisticUserReport().open();
//        adm.statisticUserReport().openUsers();
//        adm.statisticUserReport().chooseDates(dateFrom, dateTo);
//        adm.statisticUserReport().formReportButton();
//        adm.statisticUserReport().checkDates(dateFrom, dateTo);
//        adm.logOut();
//    }
//
//    @Test
//    @DisplayName("Отчет по пользователям, отфильтрованный по полю Подсистема/модуль")
//    public void t8checkModuleSearch() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.statisticUserReport().open();
//        adm.statisticUserReport().openUsers();
//        adm.statisticUserReport().chooseSearchModule(module);
//        adm.statisticUserReport().formReportButton();
//        adm.logOut();
//    }
//
//    @Test
//    @DisplayName("Отчет по пользователям, отфильтрованный по типу пользователя")
//    public void t9checkUserType() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.statisticUserReport().open();
//        adm.statisticUserReport().openUsers();
//        adm.statisticUserReport().chooseUserType(userType);
//        adm.statisticUserReport().formReportButton();
//        adm.statisticUserReport().checkUserType(userType);
//        adm.logOut();
//        //Configuration.holdBrowserOpen = true;
//    }
//
//    @Test
//    @DisplayName("Отчет по пользователям, отфильтрованный по полю Орган государственных доходов")
//    public void t10checkDepartment() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.statisticUserReport().open();
//        adm.statisticUserReport().openUsers();
//        adm.statisticUserReport().chooseSearchDepartment(department);
//        adm.statisticUserReport().formReportButton();
//        adm.statisticUserReport().checkSearchDepartment(department);
//        adm.logOut();
//        //Configuration.holdBrowserOpen = true;
//    }
//
//    @Test
//    @DisplayName("Отчет по пользователям, отфильтрованный по подразделению")
//    public void t11checkSubdivision() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.statisticUserReport().open();
//        adm.statisticUserReport().openUsers();
//        adm.statisticUserReport().chooseSearchDepartment(department);
//        adm.statisticUserReport().chooseSubdivision(subdivision);
//        adm.statisticUserReport().formReportButton();
//        adm.statisticUserReport().checkSubdivision(subdivision);
//        adm.logOut();
//    }
//
//    @Test
//    @DisplayName("Отчет по пользователям, отфильтрованный по должности")
//    public void t12checkPosition() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.statisticUserReport().open();
//        adm.statisticUserReport().openUsers();
//        adm.statisticUserReport().chooseSearchDepartment(department);
//        adm.statisticUserReport().chooseSubdivision(subdivision);
//        adm.statisticUserReport().choosePosition(position);
//        adm.statisticUserReport().formReportButton();
//        adm.statisticUserReport().checkPosition(position);
//        adm.logOut();
//    }
//
//
////    @Test
////    @DisplayName("Открыть отчет по действиям администраторов")
////    public void t4RightsReport(){
////        Adm adm =new Adm();
////        adm.logIn(login, password);
////        adm.staticalReport().open();
////        adm.staticalReport().openAdmins();
////
////        adm.logOut();
////        // Configuration.holdBrowserOpen = true;
////    }
////
////    @Test
////    @DisplayName("Открыть статистический отчет")
////    public void t5StatisticReport(){
////        Adm adm =new Adm();
////        adm.logIn(login, password);
////        adm.staticalReport().open();
////        adm.staticalReport().openReport();
////
////        adm.logOut();
////        // Configuration.holdBrowserOpen = true;
////    }
//
//
//}

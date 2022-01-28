//package sapasoft.adm;
//
//import com.codeborne.selenide.Configuration;
//import io.qameta.allure.junit4.DisplayName;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.openqa.selenium.By;
//import sapasoft.adm.pages.Adm;
//import sapasoft.adm.testconfigs.BaseSetings;
//
//import static com.codeborne.selenide.Selenide.$;
//import static java.lang.Thread.sleep;
//
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@DisplayName("Раздел \"Управление заявками\"")
//public class ApplicationManagementTest extends BaseSetings {
//
//    //Тестовые данные
//    private String searchLine = "861023450579"; // Поиск по ИИН или ФИО
//    private String typeOfApplication ="Регистрация аудитора";
//    private String status="На согласовании у руководителя подсистемы/модуля";
//    private String module="Аудит и Мониторинг";
//
//    private String ogd="Комитет государственных доходов Министерства финансов Республики Казахстан";
//    private String subdivision ="Управление государственных услуг";
//    private String position="Главный эксперт ";
//    private String period="";
//    protected String iin;
//    private String date=date1();
//
//
//
//
//    @Test
//    @DisplayName("Просмотр заявки")
//    public void t1ViewApplication(){
//        Adm adm =new Adm();
//        adm.logIn(login, password);
//        adm.applicationManagement().open();
//        adm.applicationManagement().openApplication();
//        adm.applicationManagement().cancelButton();
//        adm.logOut();
//
//    }
//
//    @Test
//    @DisplayName("Поиск заявки по наименованию или ИИН")
//    public void t2SearchApplication() {
//        Adm adm =new Adm();
//        adm.logIn(login, password);
//        adm.applicationManagement().open();
//        adm.applicationManagement().searchLine(searchLine);
//        adm.logOut();
//    }
//
//    @Test
//    @DisplayName("Расширенный поиск заявки")
//    public void t3ExtendedSearchApplication() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.applicationManagement().open();
//        adm.applicationManagement().extendedSearch();
//        adm.applicationManagement().typeOfApplication(typeOfApplication);
//        adm.applicationManagement().applySearch();
//        adm.applicationManagement().checkSearchResult(typeOfApplication);
//        adm.applicationManagement().extendedSearch();
//        adm.applicationManagement().status(status);
//        adm.applicationManagement().applySearch();
//        adm.applicationManagement().checkSearchResult(status);
//        adm.logOut();
//
//    }
//
//    //@Test
//    @DisplayName("Согласование заявки администратором")
//    public void t4ApprovalApplicationAdmin() {
//        Adm adm = new Adm();
//        adm.logIn(login, password);
//        adm.applicationManagement().open();
//        adm.applicationManagement().extendedSearch();
//        adm.applicationManagement().status("На согласовании у администратора");
//        adm.applicationManagement().applySearch();
//        adm.applicationManagement().checkStatus("На согласовании у администратора");
//        adm.applicationManagement().openApplication();
//        // this.iin = $(By.xpath("//tbody/tr[1]/td[2]/span")).getText();
//        adm.applicationManagement().createAccountAdmin();
//        //adm.applicationManagement().checkThatAccountCreated(iin);
//        adm.logOut();
//
//    }
//
//    //@Test
//    @DisplayName("Согласование руководителем подсистемы")
//    public void t5ApprovalApplicationManager() {
//        Adm adm = new Adm();
//        adm.logIn("ans_adm", "ans_adm");
//        adm.applicationManagement().open();
//        adm.applicationManagement().extendedSearch();
//        adm.applicationManagement().status("На согласовании у руководителя подсистемы/модуля");
//        adm.applicationManagement().applySearch();
//        adm.applicationManagement().checkStatus("На согласовании у руководителя подсистемы/модуля");
//        adm.applicationManagement().openApplication();
//        adm.applicationManagement().cancelButton();
//        adm.logOut();
//    }
//
//    //@Test
//    @DisplayName("Согласование Сотрудником ИБ")
//    public void t5ApprovalApplicationSecurity() {
//        Adm adm = new Adm();
//        adm.logIn("user1", "123456S");
//        adm.applicationManagement().open();
//        adm.applicationManagement().extendedSearch();
//        adm.applicationManagement().status("На согласовании у сотрудника ИБ");
//        adm.applicationManagement().applySearch();
//        adm.applicationManagement().checkStatus("На согласовании у сотрудника ИБ");
//        adm.applicationManagement().openApplication();
//        adm.applicationManagement().applyButton();
//        adm.logOut();
//    }
//
//    //@Test
//    @DisplayName("Отклонение заявки руководителем подсистемы")
//    public void t6DeclineApplicationManager() {
//        Adm adm = new Adm();
//        adm.logIn("ans_adm", "ans_adm");
//        adm.applicationManagement().open();
//        adm.applicationManagement().extendedSearch();
//        adm.applicationManagement().status("На согласовании у руководителя подсистемы/модуля");
//        adm.applicationManagement().applySearch();
//        adm.applicationManagement().checkStatus("На согласовании у руководителя подсистемы/модуля");
//        adm.applicationManagement().openApplication();
//        //adm.applicationManagement().decline();
//
//        Configuration.holdBrowserOpen = true;
//        //adm.logOut();
//
//    }
//
//
//
//
//}

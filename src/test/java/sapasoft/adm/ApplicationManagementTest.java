package sapasoft.adm;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sapasoft.adm.pages.Adm;
import sapasoft.adm.testconfigs.BaseSetings;

import static java.lang.Thread.sleep;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("Раздел \"Управление заявками\"")
public class ApplicationManagementTest extends BaseSetings {

    //Тестовые данные
    private String searchLine = "861023450579"; //



    @Test
    @DisplayName("Просмотр заявки")
    public void t1ViewApplication(){
        Adm adm =new Adm();
        adm.logIn(login, password);
        adm.applicationManagement().open();
        adm.applicationManagement().openApplication();
        adm.applicationManagement().cancelButton();
        adm.logOut();

    }

    @Test
    @DisplayName("Поиск заявки по наименованию или ИИН")
    public void t2SearchApplication() throws InterruptedException {
        Adm adm =new Adm();
        adm.logIn(login, password);
        adm.applicationManagement().open();
        adm.applicationManagement().searchLine(searchLine);
        sleep(3000);
        adm.logOut();
    }

    @Test
    @DisplayName("Расширенный поиск заявки")
    public void t3ExtendedSearchApplication() {
        Adm adm =new Adm();
        adm.logIn(login, password);
        adm.applicationManagement().open();
        adm.applicationManagement().extendedSearch();
        adm.applicationManagement().typeOfApplication();
        adm.applicationManagement().status();
        adm.applicationManagement().periodOfCreation();
        adm.applicationManagement().module();
        adm.applicationManagement().ogd();
        adm.applicationManagement().subdivision();
        adm.applicationManagement().position();
        adm.applicationManagement().applySearch();



        adm.logOut();

}

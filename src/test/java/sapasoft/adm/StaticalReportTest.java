package sapasoft.adm;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import sapasoft.adm.pages.Adm;
import sapasoft.adm.testconfigs.BaseSetings;
@DisplayName("Раздел Статистические отчеты")
public class StaticalReportTest extends BaseSetings {

    @Test
    @DisplayName("Открыть отчет по пользователям")
    public void t1UsersReport(){
        Adm adm =new Adm();
        adm.logIn(login, password);
        adm.staticalReport().open();
        adm.staticalReport().openUsers();

        adm.logOut();
       // Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Открыть отчет по ролям")
    public void t2RolesReport(){
        Adm adm =new Adm();
        adm.logIn(login, password);
        adm.staticalReport().open();
        adm.staticalReport().openRoles();

        adm.logOut();
        // Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Открыть отчет по правам")
    public void t3RightsReport(){
        Adm adm =new Adm();
        adm.logIn(login, password);
        adm.staticalReport().open();
        adm.staticalReport().openRights();

        adm.logOut();
        // Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Открыть отчет по действиям администраторов")
    public void t4RightsReport(){
        Adm adm =new Adm();
        adm.logIn(login, password);
        adm.staticalReport().open();
        adm.staticalReport().openAdmins();

        adm.logOut();
        // Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Открыть статистический отчет")
    public void t5StatisticReport(){
        Adm adm =new Adm();
        adm.logIn(login, password);
        adm.staticalReport().open();
        adm.staticalReport().openReport();

        adm.logOut();
        // Configuration.holdBrowserOpen = true;
    }


}

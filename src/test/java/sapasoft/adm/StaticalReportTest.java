package sapasoft.adm;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import sapasoft.adm.pages.Adm;
import sapasoft.adm.testconfigs.BaseSetings;

public class StaticalReportTest extends BaseSetings {

    @Test
    @DisplayName("Сформировать отчет по пользователям")
    public void t1UsersReport(){
        Adm adm =new Adm();
        adm.logIn(login, password);
        adm.staticalReport().open();
        adm.staticalReport().openUsers();

        //adm.logOut();
       // Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Сформировать отчет по ролям")
    public void t2RolesReport(){
        Adm adm =new Adm();
        adm.logIn(login, password);
        adm.staticalReport().open();
        adm.staticalReport().openRoles();

        //adm.logOut();
        // Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Сформировать отчет по правам")
    public void t3RightsReport(){
        Adm adm =new Adm();
        adm.logIn(login, password);
        adm.staticalReport().open();
        adm.staticalReport().openRights();

        //adm.logOut();
        // Configuration.holdBrowserOpen = true;
    }

}

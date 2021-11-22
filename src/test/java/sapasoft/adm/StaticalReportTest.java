package sapasoft.adm;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import sapasoft.adm.pages.Adm;
import sapasoft.adm.testconfigs.BaseSetings;

public class StaticalReportTest extends BaseSetings {

    @Test
    @DisplayName("Деактивация права")
    public void t1DeactivationRight(){
        Adm adm =new Adm();
        adm.logIn(login, password);
        adm.staticalReport().open();
//        adm.rightsManagment().extendedSearch();
//        adm.rightsManagment().fillSearchStatus("Активна"); // Ищем права со статусом Активна
//        adm.rightsManagment().applySearch();
//        adm.rightsManagment().checkSearchStatus("Активна");
//        adm.rightsManagment().openRight();
//        adm.rightsManagment().deactivateRight();
        //adm.logOut();
       // Configuration.holdBrowserOpen = true;
    }

}

package sapasoft.adm;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sapasoft.adm.pages.Adm;
import sapasoft.adm.testconfigs.BaseSetings;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("Раздел \"Управление заявками\"")
public class ApplicationManagementTest extends BaseSetings {


    @Test
    @DisplayName("Деактивация права")
    public void t2DeactivationRight(){
        Adm adm =new Adm();
        adm.logIn(login, password);
        adm.applicationManagement().open();
//        adm.rightsManagment().extendedSearch();
//        adm.rightsManagment().fillSearchStatus("Активна"); // Ищем права со статусом Активна
//        adm.rightsManagment().applySearch();
//        adm.rightsManagment().checkSearchStatus("Активна");
//        adm.rightsManagment().openRight();
//        adm.rightsManagment().deactivateRight();
        //adm.logOut();
        Configuration.holdBrowserOpen = true;
    }
}

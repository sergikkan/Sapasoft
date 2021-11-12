package sapasoft.adm;


import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sapasoft.adm.pages.Adm;
import sapasoft.adm.testconfigs.BaseSetings;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("Раздел \"Подача дополнительной заявки на предоставление роли и прав\"")
public class AdditionalApplicationTest extends BaseSetings {
    @Test
    @DisplayName("Деактивация права")
    public void t1DeactivationRight(){
        Adm adm =new Adm();
        adm.logIn(login, password);
        adm.additionalApplication().open();
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

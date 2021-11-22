package sapasoft.adm;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import sapasoft.adm.pages.Adm;
import sapasoft.adm.testconfigs.BaseSetings;

public class RegistrationTest extends BaseSetings {

    private String date=date1();

    @Test
    @DisplayName("Регистрация сотрудника")
    public void t7RegisrtionUser() {
        Adm adm = new Adm();
        adm.registration();
        adm.registrationUser().fillIIN("900522000605");
        adm.registrationUser().pressSearch();
        adm.registrationUser().fillIPadress("234.545");
        adm.registrationUser().fillNumnerOfdDocunent();
        adm.registrationUser().chooseDate(date);
        adm.registrationUser().chooseModule("Администрирование и мониторинг");
        adm.registrationUser().uploadFile();
        adm.registrationUser().chooseRights();
        adm.registrationUser().checkThatButtonActive();
        adm.registrationUser().pressCancel();
    }

}

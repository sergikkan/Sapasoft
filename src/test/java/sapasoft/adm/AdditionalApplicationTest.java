package sapasoft.adm;


import io.qameta.allure.junit4.DisplayName;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sapasoft.adm.pages.Adm;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("Раздел \"Подача дополнительной заявки на предоставление роли и прав\"")
public class AdditionalApplicationTest extends BaseTest {

    String dateFrom = date();


    @Test
    @DisplayName("Подача дополнительной заявки на предоставление роли и прав")
    public void t1AdditionalApplication() {
        Adm adm = new Adm();
        adm.logIn(LOGIN, PASSWORD);
        adm.additionalApplication().open();
        adm.additionalApplication().choosePeriod(dateFrom);
        adm.additionalApplication().chooseModule("Реабилитация и банкротство");
        adm.additionalApplication().uploadFile();
        adm.additionalApplication().chooseRole();
        adm.additionalApplication().chooseRight();
        adm.additionalApplication().agreementText();
        adm.additionalApplication().checkSignButton();
        adm.logOut();
    }
}

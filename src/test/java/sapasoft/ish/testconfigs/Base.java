package sapasoft.ish.testconfigs;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;


public class Base {
    protected String login= "ish_admin";
    protected String password= "ish_admin";


    @Before
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    {
        Configuration.baseUrl = "https://esb.sapasoft.kz";
        Configuration.timeout= 8000;
        //Configuration.startMaximized = true;
    }
}

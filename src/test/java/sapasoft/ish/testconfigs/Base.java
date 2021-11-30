package sapasoft.ish.testconfigs;

import com.codeborne.selenide.Configuration;


public class Base {
    protected String login= "ish_admin";
    protected String password= "ish_admin";

    {
        Configuration.baseUrl = "http://ish-dev.sapasoft.kz";
        Configuration.timeout= 8000;
        //Configuration.startMaximized = true;
    }
}

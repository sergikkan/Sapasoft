package sapasoft.adm.testconfigs;

import com.codeborne.selenide.Configuration;

import java.util.Random;

public class BaseSetings {
    protected String login= "admin";
    protected String password= "admin";

    {
        Configuration.baseUrl = "https://arm.sapasoft.kz";
        Configuration.timeout= 12000;
        //Configuration.startMaximized = true;
    }

    /*Генерация случайной строки русских букв*/
    protected static Random sRandom = new Random();
    protected static char[] sAlphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();
    protected static int sLength = sAlphabet.length;

    protected static char getRandomChar() {
        return sAlphabet[sRandom.nextInt(sLength)];
    }

    protected static String str() {
        String str = "";
        for (int i=0; i<5; i++) {
            str= str + getRandomChar();
        }
        return str;
    }
}

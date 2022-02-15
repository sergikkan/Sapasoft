package sapasoft.adm.testconfigs;

import com.codeborne.selenide.Configuration;

import java.io.File;
import java.util.Objects;

public class BaseSetings {

    /**
     Данная константа нужна для возможности очистки папки со скриншотами упавших тестов
     */
    public static final Boolean CLEAR_REPORTS_DIR = false;

    /**
     * Конфигурация проекта:
     * Выбор браузера
     * Основной URL
     * Время максимального ожидания появления элемента
     * Разрешение экрана
     * Запуск тестов без открывания браузера, используется для Jenkins. Для Jenkins должна быть true
     * Реализация очистки папки со скриншотами ошибок
     */
    static {

        Configuration.browser = "chrome"; //firefox, edge,opera, ie
        Configuration.baseUrl = "https://arm.sapasoft.kz";
        Configuration.timeout= 8000;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
        Configuration.holdBrowserOpen = false;

        if (CLEAR_REPORTS_DIR) {
            File allureScreenShots = new File("build/reports/tests");
            for (File item : Objects.requireNonNull(allureScreenShots.listFiles()))
                item.delete();
        }
    }

}
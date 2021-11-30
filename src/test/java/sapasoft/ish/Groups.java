package sapasoft.ish;

import sapasoft.ish.pages.Ish;
import sapasoft.ish.testconfigs.Base;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static com.codeborne.selenide.Selenide.confirm;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Groups extends Base {

                                        /* РАЗДЕЛ ГРУППЫ  */

    private String code= "newGroup"+System.currentTimeMillis(); // Код группы для создания
    private String newCode= "newGroup"+System.currentTimeMillis(); // Код группы для редактирования
    private String existcode= "_Test_Group_"; // Код группы, которая существует в системе
    private String intcode = "ТестГрупСерик";  // Код группы, которая используется во взаимодействии

    // Создание новой группы
    @Test
    public void t1CreateNewGroup(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.groups().open();
        ish.groups().add();
        ish.groups().fillCodeOfGroup(code);
        ish.groups().save();
        ish.groups().checkGroupWasCreated(code);
        ish.logOut();

    }

    // Проверка невозможности создания группы с имеющимся кодом
    @Test
    public void t2TryToCreateExistCode(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.groups().open();
        ish.groups().add();
        ish.groups().fillExistCode();
        ish.groups().save();
        ish.groups().checkGroupExist();
        ish.groups().cancel();
        confirm();
        ish.logOut();
    }

    // Проверка невозможности сохранения имеющегося кода при редактировании
    @Test
    public void t3TryEditExistCodeGroup(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.groups().open();
        ish.groups().edit();
        ish.groups().clearFieldGroup();
        ish.groups().fillExistCode();
        ish.groups().save();
        ish.groups().checkGroupExist();
        ish.groups().cancel();
        confirm();
        ish.logOut();
    }

    // Проверка создания пустой формы группы
    @Test
    public void t4CreateEmptyFieldCode(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.groups().open();
        ish.groups().add();
        ish.groups().save();
        ish.groups().checkThatFieldIsEmpty();
        ish.groups().cancel();
        ish.logOut();
    }

    // Проверка сохранения пустой формы группы при редактировании
    @Test
    public void t5EditEmptyFieldCode(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.groups().open();
        ish.groups().edit();
        ish.groups().clearFieldGroup();
        ish.groups().save();
        ish.groups().checkThatFieldIsEmpty();
        ish.groups().cancel();
        confirm();
        ish.logOut();
    }

    // Редактирование группы
    @Test
    public void t6EditGroups(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.groups().open();
        ish.groups().edit();
        ish.groups().clearFieldGroup();
        ish.groups().fillNewCode(newCode);
        ish.groups().save();
        ish.groups().checkGroupWasChanged(newCode);
        ish.groups().cancel();
        ish.logOut();
    }

    // Удаление группы

    @Test
    public void t7DeleteGroup(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.groups().open();
        ish.groups().delete();
        ish.logOut();
    }

    // Проверка невозможности удаления группы, которая используется во взаимодействии

    @Test
    public void t8DeleteIntegrationGroup(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.groups().open();
        ish.groups().searchExistResult(intcode);
        ish.groups().deleteInteger(intcode);
        ish.logOut();
    }

    //Поиск группы
    @Test
    public void t9SearchGroup(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.groups().open();
        ish.groups().searchWrongResult();
        ish.groups().clearSearchField();
        ish.groups().searchExistResult(intcode);
        ish.logOut();

    }


}

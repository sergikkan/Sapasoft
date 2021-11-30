package sapasoft.ish;

import sapasoft.ish.pages.Ish;
import sapasoft.ish.testconfigs.Base;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static com.codeborne.selenide.Selenide.confirm;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Members extends Base {

    /* Участники */

    String memberCode="member"+System.currentTimeMillis(); // создание нового кода участника
    String membername="member"+System.currentTimeMillis(); // создание нового наименования участника
    String memberUsername="member"+System.currentTimeMillis(); // создание новго имени пользователя участника
    String memberCodeNew="newmember"+System.currentTimeMillis(); // создание нового кода участника
    String membernameNew="newmember"+System.currentTimeMillis(); // создание нового наименования участника
    String memberUsernameNew="newmember"+System.currentTimeMillis(); // создание новго имени пользователя участника
    String memberPassword="Code23432!"; // Значение пароль состоит из букв верхнего и нижнего регистра, цифр и специальных символов
    String memberGroup="ТестГрупСерик"; // Группа используется во взаимодействии
    String existMember = "ПЭП И ИСНА";  // Существующий участник для проверки поля поиска

    // Создание нового участника
    //
    //Тест создает, участник сразу появляется, вручную нет
    @Test
    public void t1СreateNewMember(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.members().open();
        ish.members().add();
        ish.members().fillCodeOfMember(memberCode);
        ish.members().fillNameOfMember(membername);
        ish.members().fillUsernameOfMember(memberUsername);
        ish.members().fillPasswordOfMember(memberPassword);
        ish.members().chooseGroup(memberGroup);
        ish.members().save();
        ish.members().checkMemberWasCreated(membername);
        ish.logOut();
    }

    @Test

    // +++
    public void t2editMember(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.members().open();
        ish.members().edit();
        ish.members().clearAllFields();
        ish.members().fillCodeOfMember(memberCodeNew);
        ish.members().fillNameOfMember(membernameNew);
        ish.members().fillUsernameOfMember(memberUsernameNew);
        ish.members().chooseGroup(memberGroup);
        ish.members().save();
        ish.members().checkMemberWasCreated(membernameNew);
        ish.logOut();
    }

    // Удаление участника  ---
    @Test
    public void t31DeleteMember(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.members().open();
        ish.members().delete();
        ish.logOut();
    }

    // Проверка создания пустой формы +++
    @Test
    public void t4CreateMemberRequiredFields(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.members().open();
        ish.members().add();
        ish.members().save();
        ish.members().checkRequiredFields();
        ish.members().cancel();
        ish.logOut();
    }

    //Проверка сохранения пустой формы при редактировании++++++
    @Test
    public void t5EditMemberRequiredFields(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.members().open();
        ish.members().edit();
        ish.members().clearAllFields();
        ish.members().save();
        ish.members().checkRequiredFieldsEdit();
        ish.members().cancel();
        confirm();
        ish.logOut();

    }

    @Test
    public void t6CheckUniqueCodeCreate(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.members().open();
        ish.members().add();
        ish.members().fillExistCode();
        ish.members().fillNameOfMember(membername);
        ish.members().fillUsernameOfMember(memberUsername);
        ish.members().fillPasswordOfMember(memberPassword);
        ish.members().chooseGroup(memberGroup);
        ish.members().save();
        ish.members().checkUniqueCode();
        ish.members().cancel();
        confirm();
        ish.logOut();

    }

    @Test
    public void t7CheckUniqueNameCreate(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.members().open();
        ish.members().add();
        ish.members().fillCodeOfMember(memberCode);
        ish.members().fillExistName();
        ish.members().fillUsernameOfMember(memberUsername);
        ish.members().fillPasswordOfMember(memberPassword);
        ish.members().chooseGroup(memberGroup);
        ish.members().save();
        ish.members().checkUniqueName();
        ish.members().cancel();
        confirm();
        ish.logOut();

    }

    @Test
    public void t8CheckUniqueUsernameCreate(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.members().open();
        ish.members().add();
        ish.members().fillCodeOfMember(memberCode);
        ish.members().fillNameOfMember(membername);
        ish.members().fillExistUsername();
        ish.members().fillPasswordOfMember(memberPassword);
        ish.members().chooseGroup(memberGroup);
        ish.members().save();
        ish.members().checkUniqueUsername();
        ish.members().cancel();
        confirm();
        ish.logOut();
    }

    @Test
    public void t9SearchMember(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.members().open();
        ish.members().searchWrongMember();
        ish.members().clearSearchField();
        ish.members().searchExistMember(existMember);
        ish.logOut();
    }
}

package sapasoft.ish.pages;

public class Ish {
    public void logIn(String login, String password){
        new Autorization().logIn(login, password);
    }
    public void logOut(){
        new Autorization().logOut();
    }


    public Integrations integrations() {
        Integrations integrations = new Integrations();
        return integrations;
    }
    public Members members() {
        Members members = new Members();
        return members;
    }

    public Groups groups() {
        Groups groups = new Groups();
        return groups;
    }
    public Journals journals() {
        Journals journals = new Journals();
        return journals;
    }





}

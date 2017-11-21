package ru.kupchenkov;

public class LoginExample {

    @Login
    private String login;
    private String name;

    public LoginExample(String login, String name){
        this.login = login;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }
}

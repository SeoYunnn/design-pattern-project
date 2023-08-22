package login;

public class LoginManager {
    private static LoginStrategy loginStrategy;

    public LoginManager(LoginStrategy loginStrategy) {
        this.loginStrategy = loginStrategy;
    }

    public static User performLogin() {
        return loginStrategy.login();
    }
}

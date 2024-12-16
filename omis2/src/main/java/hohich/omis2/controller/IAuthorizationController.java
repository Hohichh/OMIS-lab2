package hohich.omis2.controller;

public interface IAuthorizationController {
    void authorize(String username, String password);
    void endSession(int id);
    void checkSession(int id);
}

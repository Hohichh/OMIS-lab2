package hohich.omis2.model.repositories;

import hohich.omis2.model.data.IUser;

import java.util.List;

public interface IUserRepository {
    IUser getUser(int id);
    List<IUser> getAllUsers();
    void saveUser(IUser user);
    void deleteUser(int id);
    void updateUser(IUser user);
    int authorize(String login, String password);
}

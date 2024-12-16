package hohich.omis2.controller;

import hohich.omis2.model.data.IUser;
import org.springframework.ui.Model;

import java.util.List;

public interface IUserController {
    List<IUser> getAllUsers();
    List<IUser> getAllResidents();
    List<IUser> getAllAdmins();
    IUser getUserById(int id);
    void updateUser(IUser user);
    void addUser(IUser user);
}

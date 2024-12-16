package hohich.omis2.model.repositories.StrRepositories;

import lombok.AllArgsConstructor;
import hohich.omis2.model.data.IUser;
import hohich.omis2.model.repositories.IUserRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository

public class UserRepository implements IUserRepository {
    List<IUser> users;

    public UserRepository() {
        users = new ArrayList<>();
    }

    @Override
    public IUser getUser(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<IUser> getAllUsers() {
        return users;
    }

    @Override
    public void saveUser(IUser user) {
        users.add(user);
    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public void updateUser(IUser userIn) {
        users.stream()
                .filter(user -> user.getId() == userIn.getId())
                .findFirst()
                .ifPresent(user -> {
                    user.setName(userIn.getName());
                    user.setEmail(userIn.getEmail());
                    user.setRole(userIn.getRole());
                });
    }

    @Override
    public int authorize(String username, String password) {
        return 0;
    }
}

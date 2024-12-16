package hohich.omis2.controller.StrControllers;

import hohich.omis2.model.data.User.StandartUser;
import hohich.omis2.model.repositories.StrRepositories.UserRepository;
import lombok.AllArgsConstructor;
import hohich.omis2.controller.IUserController;
import hohich.omis2.model.data.IUser;
import hohich.omis2.model.repositories.IUserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/omis2/users")
public class UserController implements IUserController {
    private IUserRepository userRepository;

    // Получение всех пользователей

    @GetMapping
    public String getAllUsers(@RequestParam(value = "filter", defaultValue = "all") String filter, Model model) {
        List<IUser> users;

        if ("admins".equals(filter)) {
            users = getAllAdmins(); // Вызов метода для администраторов
            model.addAttribute("filter", "Администраторы");
        } else if ("residents".equals(filter)) {
            users = getAllResidents(); // Вызов метода для жителей
            model.addAttribute("filter", "Жители");
        } else {
            users = getAllUsers(); // Все пользователи
            model.addAttribute("filter", "Все");
        }
        model.addAttribute("users", users);
        return "users"; // Возвращает шаблон с пользователями
    }

    @Override
    public List<IUser> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public List<IUser> getAllResidents() {
        return userRepository.getAllUsers().stream()
                .filter(user -> user.getRole().equals("RESIDENT"))
                .collect(Collectors.toList());
    }

    @Override
    public List<IUser> getAllAdmins() {
        return userRepository.getAllUsers().stream()
                .filter(user -> user.getRole().equals("ADMINISTRATOR"))
                .collect(Collectors.toList());
    }

    @GetMapping("/add")
    public String showAddUserForm() {
        return "addUser"; // Страница для добавления пользователя
    }

    // Добавление нового пользователя
    @PostMapping("/add")
    public String addUserFromForm(@ModelAttribute("user") StandartUser user) {
        addUser(user);
        System.out.println(user.getId());// Добавление пользователя через сервис
        return "redirect:/omis2/users"; // Перенаправление на страницу с пользователями
    }

    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable("id") int id, Model model) {
        IUser user = getUserById(id); // Получаем пользователя по ID
        model.addAttribute("user", user); // Передаем данные пользователя в форму
        return "updUser"; // Страница для редактирования пользователя
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") int id, @ModelAttribute("user") StandartUser user) {
        user.setId(id); // Устанавливаем ID пользователя для обновления
        updateUser(user); // Обновление данных пользователя
        System.out.println(user.getId());
        return "redirect:/omis2/users"; // Перенаправление на список пользователей
    }

    @Override
    public IUser getUserById(int id) {
        // Получение пользователя по ID
        return userRepository.getUser(id);// Страница с деталями пользователя
    }

    @Override
    public void updateUser(IUser user) {
        // Логика для обновления пользователя
        userRepository.updateUser(user); // Сохранение изменений// Перенаправление на список пользователей
    }

    @Override
    public void addUser(IUser user) {
        // Логика для добавления пользователя
        userRepository.saveUser(user); // Сохранение нового пользователя// Перенаправление на страницу с пользователями
    }
}



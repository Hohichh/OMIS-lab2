package hohich.omis2.controller.StrControllers;


import hohich.omis2.controller.IAuthorizationController;
import hohich.omis2.model.repositories.IUserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omis2/auth")
public class AuthorizationController implements IAuthorizationController {

    private final IUserRepository userRepository;

    // Внедрение зависимости через конструктор
    public AuthorizationController(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void authorize(String username, String password) {
        // Реализация логики авторизации
        if (username == null || password == null || username.isBlank() || password.isBlank()) {
            throw new IllegalArgumentException("Имя пользователя или пароль пусты");
        }

        // Пример проверки (замените на логику из вашего репозитория)
        boolean userExists = true;
        if (!userExists) {
            throw new SecurityException("Неверные учетные данные");
        }
    }

    @Override
    public void endSession(int id) {
        // Реализация завершения сессии
    }

    @Override
    public void checkSession(int id) {
        // Реализация проверки сессии
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Обработчик POST-запроса для авторизации
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        try {
            authorize(username, password);
            // Перенаправляем на домашнюю страницу (например, /home)
            return "redirect:/omis2/users";
        } catch (SecurityException e) {
            model.addAttribute("error", true); // Передаем флаг ошибки в модель
            return "login"; // Возвращаем страницу логина с ошибкой
        }
    }
}




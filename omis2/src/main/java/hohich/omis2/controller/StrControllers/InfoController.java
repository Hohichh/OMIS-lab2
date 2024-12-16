package hohich.omis2.controller.StrControllers;

import hohich.omis2.model.data.IUser;
import hohich.omis2.model.data.Notification.StandartNotification;
import hohich.omis2.model.data.Report.StandartReport;
import hohich.omis2.model.repositories.IConsumingRepository;
import hohich.omis2.model.repositories.IUserRepository;
import hohich.omis2.model.repositories.StrRepositories.ConsumingRepository;
import hohich.omis2.model.repositories.StrRepositories.UserRepository;
import lombok.AllArgsConstructor;
import hohich.omis2.controller.IInfoController;
import hohich.omis2.model.data.INotification;
import hohich.omis2.model.data.IReport;

import java.time.LocalDate;
import java.util.List;

import hohich.omis2.model.repositories.INotificationRepository;
import hohich.omis2.model.repositories.IReportRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/omis2/information")
public class InfoController implements IInfoController {
    private final INotificationRepository notificationRepository;
    private final IReportRepository reportRepository;
    private final IUserRepository userRepository;

    public InfoController(INotificationRepository notificationRepository,
                          IReportRepository reportRepository,
                          IUserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.reportRepository = reportRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String showReports(Model model) {
        List<IReport> reports = getAllReports();
        model.addAttribute("reports", reports);
        model.addAttribute("infoType", "report");
        return "information";
    }

    @GetMapping("/add")
    public String showReportForm(Model model){
        model.addAttribute("users", userRepository.getAllUsers());
        return "addReport";
    }

    @PostMapping("/add")
    public String addReportFromForm(
            @RequestParam("userId") int userId,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam("description") String message,
            Model model) {

        IUser user = userRepository.getUser(userId);
        if (user == null) {
            // Обработка случая, если пользователь не найден
            model.addAttribute("error", "Пользователь не найден");
            return "addReport";
        }

        StandartReport report = new StandartReport();
        report.setUser(user);
        report.setDate(date);
        report.setDescription(message);

        createReport(report);
        return "redirect:/omis2/information";
    }

    @GetMapping("/edit/{id}")
    public String showReportEditForm(@PathVariable("id") int id, Model model) {
        IReport report = getReportById(id);
        model.addAttribute("report", report);
        model.addAttribute("users", userRepository.getAllUsers());
        return "updReport";
    }

    @PostMapping("/edit/{id}")
    public String editReport(@PathVariable("id") int id,
                             @RequestParam("userId") int userId,
                             @ModelAttribute("report") StandartReport report) {
        report.setId(id);

        // Найдите пользователя по ID
        IUser user = userRepository.getUser(userId); // Метод должен возвращать IUser
        if (user == null) {
            throw new RuntimeException("User not found with ID: " + userId);
        }
        report.setUser(user);
        System.out.println(report.getUser().getName());

        updateReport(report);

        return "redirect:/omis2/information";
    }


    @GetMapping("/notifications")
    public String showNotifications(Model model) {
        List<INotification> notifications = getAllNotifications();
        model.addAttribute("notifications", notifications);
        model.addAttribute("infoType", "notification");
        return "information";
    }

    // Метод для получения всех уведомлений
    @Override
    public List<INotification> getAllNotifications() {
        return notificationRepository.getAllNotifications();
    }

    @GetMapping("/notifications/add")
    public String showNotificationForm(Model model){
        model.addAttribute("users", userRepository.getAllUsers());
        return "addNotification";
    }

    @PostMapping("/notifications/add")
    public String addNotificationFromForm(
            @RequestParam("userId") int userId,
            @RequestParam("message") String message,
            Model model) {

        IUser user = userRepository.getUser(userId);
        if (user == null) {
            // Обработка случая, если пользователь не найден
            model.addAttribute("error", "Пользователь не найден");
            return "addNotification";
        }
        StandartNotification notification = new StandartNotification();
        notification.setUser(user);
        notification.setMessage(message);

        createNotification(notification);
        return "redirect:/omis2/information/notifications";
    }

    @GetMapping("/notifications/edit/{id}")
    public String showNotificationEditForm(@PathVariable("id") int id, Model model) {
        INotification notification = getNotificationById(id);
        model.addAttribute("notification", notification);
        model.addAttribute("users", userRepository.getAllUsers());
        return "updNotification";
    }

    @PostMapping("/notifications/edit/{id}")
    public String editNotification(@PathVariable("id") int id,
                             @RequestParam("userId") int userId,
                             @ModelAttribute("notification") StandartNotification notification) {
        notification.setId(id);

        // Найдите пользователя по ID
        IUser user = userRepository.getUser(userId); // Метод должен возвращать IUser
        if (user == null) {
            throw new RuntimeException("User not found with ID: " + userId);
        }

        notification.setUser(user);
        System.out.println(notification.getUser().getName());

        updateNotification(notification);

        return "redirect:/omis2/information/notifications";
    }

    // Метод для получения уведомления по ID
    @Override
    public INotification getNotificationById(int id) {
        return notificationRepository.getNotification(id);
    }

    // Метод для создания нового уведомления
    @Override
    public void createNotification(INotification notification) {
        notificationRepository.saveNotification(notification);
    }

    // Метод для обновления уведомления
    @Override
    public void updateNotification(INotification notification) {
        notificationRepository.updateNotification(notification);
    }

    // Метод для удаления уведомления
    @Override
    public void deleteNotification(int id) {
        notificationRepository.deleteNotification(id);
    }

    // Метод для получения всех отчетов
    @Override
    public List<IReport> getAllReports() {
        return reportRepository.getAllReports();
    }

    // Метод для получения отчета по ID
    @Override
    public IReport getReportById(int id) {
        return reportRepository.getReport(id);
    }

    // Метод для создания нового отчета
    @Override
    public void createReport(IReport report) {
        reportRepository.saveReport(report);
    }

    // Метод для обновления отчета
    @Override
    public void updateReport(IReport report) {
        reportRepository.updateReport(report);
    }

    // Метод для удаления отчета
    @Override
    public void deleteReport(int id) {
        reportRepository.deleteReport(id);
    }
}


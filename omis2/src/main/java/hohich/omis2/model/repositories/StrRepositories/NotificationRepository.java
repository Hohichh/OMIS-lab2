package hohich.omis2.model.repositories.StrRepositories;

import lombok.AllArgsConstructor;
import hohich.omis2.model.data.INotification;
import hohich.omis2.model.repositories.INotificationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository

public class NotificationRepository implements INotificationRepository {
    private List<INotification> notifications;

    public NotificationRepository() {
        notifications = new ArrayList<>();
    }

    @Override
    public INotification getNotification(int id) {
        return notifications.stream().filter(notification -> notification.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<INotification> getAllNotifications() {
        return notifications;
    }

    @Override
    public void saveNotification(INotification notification) {
        notifications.add(notification);
    }

    @Override
    public void deleteNotification(int id) {

    }

    @Override
    public void updateNotification(INotification notificationIn) {
        notifications.stream().filter(notification -> notification.getId() == notificationIn.getId())
                .findFirst()
                .ifPresent(notification -> {
                    notification.setId(notificationIn.getId());
                    notification.setDate(notificationIn.getDate());
                    notification.setMessage(notificationIn.getMessage());
                    notification.setUser(notificationIn.getUser());
                });
    }
}

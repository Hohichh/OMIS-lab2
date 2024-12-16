package hohich.omis2.model.repositories;

import hohich.omis2.model.data.INotification;

import java.util.List;

public interface INotificationRepository {
    INotification getNotification(int id);
    List<INotification> getAllNotifications();
    void saveNotification(INotification notification);
    void deleteNotification(int id);
    void updateNotification(INotification notification);
}

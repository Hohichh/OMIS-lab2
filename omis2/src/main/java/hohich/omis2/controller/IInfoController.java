package hohich.omis2.controller;

import java.util.List;

import hohich.omis2.model.data.INotification;
import hohich.omis2.model.data.IReport;

public interface IInfoController {
    List<INotification> getAllNotifications();
    INotification getNotificationById(int id);
    void createNotification(INotification notification);
    void updateNotification(INotification notification);
    void deleteNotification(int id);
    List<IReport> getAllReports();
    IReport getReportById(int id);
    void createReport(IReport report);
    void updateReport(IReport report);
    void deleteReport(int id);
}

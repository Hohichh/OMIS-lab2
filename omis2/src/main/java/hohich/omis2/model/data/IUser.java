package hohich.omis2.model.data;

import java.util.List;

public interface IUser {
     int getId();
     String getName();
     String getEmail();
     String getPassword();
     String getRole();
     List<IReport> getReports();
     List<INotification> getNotifications();

     void setId(int id);
     void setName(String name);
     void setEmail(String email);
     void setPassword(String password);
     void setRole(String role);
     void setReports(List<IReport> reports);
     void setNotifications(List<INotification> notifications);
}

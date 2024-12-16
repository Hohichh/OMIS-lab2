package hohich.omis2.model.data;

import java.time.LocalDate;

public interface INotification {
     int getId();
     IUser getUser();
     LocalDate getDate();
     String getMessage();

     void setId(int id);
     void setUser(IUser user);
     void setDate(LocalDate date);
     void setMessage(String message);
}

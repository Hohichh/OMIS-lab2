package hohich.omis2.model.data;

import java.time.LocalDate;

public interface IReport {
     int getId();
     IUser getUser();
     IConsuming getConsuming();
     LocalDate getDate();
     String getDescription();

     void setId(int id);
     void setUser(IUser user);
     void setConsuming(IConsuming consuming);
     void setDate(LocalDate date);
     void setDescription(String description);
}

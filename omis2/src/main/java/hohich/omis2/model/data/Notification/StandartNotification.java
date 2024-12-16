package hohich.omis2.model.data.Notification;

import hohich.omis2.model.data.INotification;
import hohich.omis2.model.data.IUser;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
@AllArgsConstructor

public class StandartNotification implements INotification {
    int id;
    private IUser user;
    private LocalDate date;
    private String message;

    public StandartNotification(){
        id = UUID.randomUUID().hashCode();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public IUser getUser() {
        return user;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setUser(IUser user) {
        this.user = user;
    }

    @Override
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}

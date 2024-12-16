package hohich.omis2.model.data.User;

import java.util.UUID;
import hohich.omis2.model.data.INotification;
import hohich.omis2.model.data.IReport;
import hohich.omis2.model.data.IUser;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor

public class StandartUser implements IUser {
    private int id;
    private String fullName;
    private String email;
    private String password;
    private String role;
    private List<IReport> reports;
    private List<INotification> notifications;

    public StandartUser(){
        this.id = UUID.randomUUID().hashCode();
    }

    @Override
    public int getId(){
        return id;
    }

    @Override
    public String getName() {
        return fullName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public List<IReport> getReports() {
        return reports;
    }

    @Override
    public List<INotification> getNotifications() {
        return notifications;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        fullName = name;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public void setReports(List<IReport> reports) {
        this.reports = reports;
    }

    @Override
    public void setNotifications(List<INotification> notifications) {
        this.notifications = notifications;
    }
}

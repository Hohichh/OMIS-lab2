package hohich.omis2.model.data.Report;

import hohich.omis2.model.data.IConsuming;
import hohich.omis2.model.data.IReport;
import hohich.omis2.model.data.IUser;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
@AllArgsConstructor
public class StandartReport implements IReport {
    private int id;
    private IUser user;
    private IConsuming consuming;
    private LocalDate date;
    private String description;

    public StandartReport(){
        id = UUID.randomUUID().hashCode();
    }

    @Override
    public int getId(){
        return id;
    }

    @Override
    public IUser getUser() {
        return user;
    }

    @Override
    public IConsuming getConsuming() {
        return consuming;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public String getDescription() {
        return description;
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
    public void setConsuming(IConsuming consuming) {
        this.consuming = consuming;
    }

    @Override
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}

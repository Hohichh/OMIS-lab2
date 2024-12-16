package hohich.omis2.model.repositories.StrRepositories;

import lombok.AllArgsConstructor;
import hohich.omis2.model.data.IReport;
import hohich.omis2.model.repositories.IReportRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ReportRepository implements IReportRepository {
    private List<IReport> reports;

    public ReportRepository() {
        this.reports = new ArrayList<>();
    }

    @Override
    public IReport getReport(int id) {
        return reports.stream().filter(r -> r.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<IReport> getAllReports() {
        return reports;
    }

    @Override
    public void saveReport(IReport report) {
        reports.add(report);
    }

    @Override
    public void deleteReport(int id) {

    }

    @Override
    public void updateReport(IReport report) {
        reports.stream().filter(r -> r.getId() == report.getId())
                .findFirst()
                .ifPresent(r -> {
                    r.setDate(report.getDate());
                    r.setDescription(report.getDescription());
                    r.setUser(report.getUser());
                });
    }
}

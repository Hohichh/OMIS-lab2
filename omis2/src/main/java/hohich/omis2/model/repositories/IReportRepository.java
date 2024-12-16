package hohich.omis2.model.repositories;

import hohich.omis2.model.data.IReport;

import java.util.List;

public interface IReportRepository {
    IReport getReport(int id);
    List<IReport> getAllReports();
    void saveReport(IReport report);
    void deleteReport(int id);
    void updateReport(IReport report);
}

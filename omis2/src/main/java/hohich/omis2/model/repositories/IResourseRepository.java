package hohich.omis2.model.repositories;

import hohich.omis2.model.data.IEnergyResourse;

import java.util.List;

public interface IResourseRepository {
    IEnergyResourse getResourse(int id);
    List<IEnergyResourse> getAllResourses();
    void saveResourse(IEnergyResourse resourse);
    void deleteResourse(int id);
    void updateResourse(IEnergyResourse resourse);
}

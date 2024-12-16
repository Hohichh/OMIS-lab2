package hohich.omis2.model.repositories.StrRepositories;

import lombok.AllArgsConstructor;
import hohich.omis2.model.data.IEnergyResourse;
import hohich.omis2.model.repositories.IResourseRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ResourseRepository implements IResourseRepository {
    List<IEnergyResourse> resourseList;

    public ResourseRepository(){
        resourseList = new ArrayList<>();
    }

    @Override
    public IEnergyResourse getResourse(int id) {
        return resourseList.stream().filter(resource -> resource.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<IEnergyResourse> getAllResourses() {
        return resourseList;
    }

    @Override
    public void saveResourse(IEnergyResourse resourse) {
        resourseList.add(resourse);
        System.out.println(resourse.getType() + " " + resourse.getCostPerTimeUnit());
    }

    @Override
    public void deleteResourse(int id) {

    }

    @Override
    public void updateResourse(IEnergyResourse resourseIn) {

        resourseList.stream().filter(resource -> resource.getId() == resourseIn.getId())
                .findFirst()
                .ifPresent( resource -> {
                    resource.setType(resourseIn.getType());
                    resource.setCostPerTimeUnit(resourseIn.getCostPerTimeUnit());
                });
    }
}

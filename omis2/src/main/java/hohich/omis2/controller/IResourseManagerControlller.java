package hohich.omis2.controller;

import hohich.omis2.model.data.IConsuming;
import hohich.omis2.model.data.IEnergyResourse;

import java.util.List;

public interface IResourseManagerControlller {
    List<IEnergyResourse> getAllResources();
    IEnergyResourse getResourseById(int id);
    void createResourse(IEnergyResourse resourse);
    void updateResourse(IEnergyResourse resourse);
    void deleteResourse(int id);
    List<IConsuming> getAllConsumings();
    IConsuming getConsumingById(int id);
    void createConsuming(IConsuming consuming);
    void updateConsuming(IConsuming consuming);
    void deleteConsuming(int id);
}

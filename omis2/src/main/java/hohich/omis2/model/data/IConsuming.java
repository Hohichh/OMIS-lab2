package hohich.omis2.model.data;

import hohich.omis2.utils.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


//public interface IConsuming {
//     int getId();
//     Pair<LocalDate, LocalDate> getTimePeriod();
//     List<IEnergyResourse> getEnergyResourses();
//     Map<IEnergyResourse, Integer> getCommonResourseCost();
//
//     void setId(int id);
//     void setTimePeriod(Pair<LocalDate, LocalDate> timePeriod);
//     void setEnergyResourses(List<IEnergyResourse> energyResourses);
//     void setCommonResourseCost(Map<IEnergyResourse, Integer> commonResourseCost);
//}

public interface IConsuming{
     int getId();
     Pair<LocalDate, LocalDate> getPeriod();
     double getCost();

     void setId(int id);
     void setPeriod(Pair<LocalDate, LocalDate> timePeriod);
     void setCost(double cost);
}

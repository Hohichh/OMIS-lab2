package hohich.omis2.model.data.Consuming;

import hohich.omis2.model.data.IConsuming;
import hohich.omis2.model.data.IEnergyResourse;
import hohich.omis2.utils.Pair;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


//public class StandartConsuming implements IConsuming {
//    private int id;
//    private Pair<LocalDate, LocalDate> period;
//    private List<IEnergyResourse> energyResourses;
//    private Map<IEnergyResourse, Integer> CommonResourseCost;
//
//    public StandartConsuming(){
//        id = UUID.randomUUID().hashCode();
//    }
//
//    @Override
//    public int getId() {
//        return id;
//    }
//
//    @Override
//    public Pair<LocalDate, LocalDate> getTimePeriod() {
//        return period;
//    }
//
//    @Override
//    public List<IEnergyResourse> getEnergyResourses() {
//        return energyResourses;
//    }
//
//    @Override
//    public Map<IEnergyResourse, Integer> getCommonResourseCost() {
//        return CommonResourseCost;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    @Override
//    public void setTimePeriod(Pair<LocalDate, LocalDate> timePeriod) {
//        period = timePeriod;
//    }
//
//    @Override
//    public void setEnergyResourses(List<IEnergyResourse> energyResourses) {
//        this.energyResourses = energyResourses;
//    }
//
//    @Override
//    public void setCommonResourseCost(Map<IEnergyResourse, Integer> commonResourseCost) {
//        this.CommonResourseCost = commonResourseCost;
//    }
//}
@Component
@AllArgsConstructor
public class StandartConsuming implements IConsuming{
    private int id;
    private Pair<LocalDate, LocalDate> period;
    private double cost;

    public StandartConsuming() {
        id = UUID.randomUUID().hashCode();
        period = new Pair<>(LocalDate.now(), LocalDate.now().plusDays(7));
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Pair<LocalDate, LocalDate> getPeriod() {
        return period;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setPeriod(Pair<LocalDate, LocalDate> timePeriod) {
        this.period = timePeriod;
    }

    @Override
    public void setCost(double cost) {
        this.cost = cost;
    }
}

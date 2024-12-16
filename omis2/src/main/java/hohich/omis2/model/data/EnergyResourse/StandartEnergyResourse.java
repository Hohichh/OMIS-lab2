package hohich.omis2.model.data.EnergyResourse;

import hohich.omis2.model.data.IEnergyResourse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class StandartEnergyResourse implements IEnergyResourse {
    private int id;
    private String type;
    private double costPerTimeUnit;

    public StandartEnergyResourse(){
        id = UUID.randomUUID().hashCode();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public double getCostPerTimeUnit() {
        return costPerTimeUnit;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void setCostPerTimeUnit(double costPerTimeUnit) {
        this.costPerTimeUnit = costPerTimeUnit;
    }
}

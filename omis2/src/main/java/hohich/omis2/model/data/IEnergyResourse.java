package hohich.omis2.model.data;

import java.time.LocalDate;

public interface IEnergyResourse {
     int getId();
     String getType();
     double getCostPerTimeUnit();

     void setId(int id);
     void setType(String type);
     void setCostPerTimeUnit(double costPerTimeUnit);
}

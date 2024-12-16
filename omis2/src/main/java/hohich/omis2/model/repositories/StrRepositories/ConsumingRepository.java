package hohich.omis2.model.repositories.StrRepositories;

import lombok.AllArgsConstructor;
import hohich.omis2.model.data.IConsuming;
import hohich.omis2.model.repositories.IConsumingRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ConsumingRepository implements IConsumingRepository {
    List<IConsuming> consumingList;

    public ConsumingRepository() {
        consumingList = new ArrayList<>();
    }

    @Override
    public IConsuming getConsuming(int id) {
        return consumingList.stream().filter(consuming -> consuming.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<IConsuming> getAllConsumings() {
        return consumingList;
    }

    @Override
    public void saveConsuming(IConsuming consuming) {
        consumingList.add(consuming);
    }

    @Override
    public void deleteConsuming(IConsuming consuming) {

    }

    @Override
    public void updateConsuming(IConsuming consumingIn) {
        consumingList.stream().filter(consuming -> consuming.getId() == consumingIn.getId())
                .findFirst()
                .ifPresent(consuming -> {
                    consuming.setPeriod(consumingIn.getPeriod());
                    consuming.setCost(consumingIn.getCost());
                });
    }
}

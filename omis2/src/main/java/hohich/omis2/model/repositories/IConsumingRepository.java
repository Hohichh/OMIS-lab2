package hohich.omis2.model.repositories;

import hohich.omis2.model.data.IConsuming;

import java.util.List;

public interface IConsumingRepository {
    IConsuming getConsuming(int id);
    List<IConsuming> getAllConsumings();
    void saveConsuming(IConsuming consuming);
    void deleteConsuming(IConsuming consuming);
    void updateConsuming(IConsuming consuming);
}

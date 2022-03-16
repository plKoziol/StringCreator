package pl.koziol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.koziol.model.InputData;

import java.util.List;

@Repository
public interface InputRepository extends JpaRepository<InputData, Integer> {
    @Query("select InputData from InputData where InputData.id=max(InputData.id)")
    InputData findByMaxId ();

    List<InputData> findByTerminated(boolean terminated);
}

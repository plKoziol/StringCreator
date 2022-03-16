package pl.koziol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.koziol.model.InputData;
import pl.koziol.model.UniqueString;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<UniqueString, Integer> {

    List<UniqueString> findByProcessId(Integer processId);
}

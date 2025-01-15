package jonas.exambyte.adapter.db;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SpringDataExambyteRepository extends CrudRepository<Quiz, Long>{
    List<Quiz> findAll();
    
    Quiz findById(long id);

    Quiz save(Quiz obj);

    void deleteQuizById(long id);
}

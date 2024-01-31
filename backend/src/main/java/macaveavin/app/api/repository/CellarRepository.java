package macaveavin.app.api.repository;

import macaveavin.app.api.entity.Cellar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CellarRepository extends CrudRepository<Cellar, Long> {
}

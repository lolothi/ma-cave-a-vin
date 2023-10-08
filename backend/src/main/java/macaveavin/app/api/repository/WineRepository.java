package macaveavin.app.api.repository;

import macaveavin.app.api.entity.Wine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineRepository extends CrudRepository <Wine, Long>  {
}

package macaveavin.app.api.repository;

import macaveavin.app.api.entity.MyWine;
import org.springframework.data.repository.CrudRepository;

public interface MyWineRepository extends CrudRepository<MyWine, Long> {
}

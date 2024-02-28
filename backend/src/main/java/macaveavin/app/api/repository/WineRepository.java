package macaveavin.app.api.repository;

import macaveavin.app.api.entity.Wine;
import macaveavin.app.api.entity.WineTypeEnum;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WineRepository extends CrudRepository <Wine, Long>  {
    @Query("SELECT w FROM Wine w WHERE w.type = :wineType")
    List<Wine> getWinesByType(@Param("wineType") Optional<WineTypeEnum> wineType);
}

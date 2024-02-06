package macaveavin.app.api.repository;

import macaveavin.app.api.entity.CellarPlace;
import macaveavin.app.api.entity.CellarPlaceWine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CellarPlaceWineRepository extends CrudRepository<CellarPlaceWine, Long> {

    @Query("SELECT SUM(cpw.quantityBottle) FROM CellarPlaceWine cpw WHERE cpw.cellarPlace.cellar_place_id = :cellar_place_id")
    Integer getBottlesQuantityByCellarPlaceByPosition(@Param("cellar_place_id")Long cellar_place_id);

}

package macaveavin.app.api.repository;

import macaveavin.app.api.entity.CellarPlace;
import macaveavin.app.api.entity.CellarPlaceWine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CellarPlaceWineRepository extends CrudRepository<CellarPlaceWine, Long> {

//    boolean existsByCellarPlaceIdAndWineId(Long cellarPlaceId, Long wineId);

    @Query("SELECT COALESCE(SUM(cpw.quantityBottle), 0) FROM CellarPlaceWine cpw WHERE cpw.cellarPlace.cellar_place_id = :cellar_place_id")
    Integer getBottlesQuantityByCellarPlaceByPosition(@Param("cellar_place_id")Long cellar_place_id);



}

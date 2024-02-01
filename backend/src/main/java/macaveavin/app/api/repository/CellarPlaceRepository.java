package macaveavin.app.api.repository;

import macaveavin.app.api.entity.CellarPlace;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CellarPlaceRepository extends CrudRepository<CellarPlace, Long> {
    @Query("SELECT cp FROM CellarPlace cp WHERE cp.positionX = :newPositionX and cp.positionY = :newPositionY and cp.positionZ = :newPositionZ")
    List<CellarPlace> getCellarPlaceByPosition(@Param("newPositionX")Integer newPositionX, @Param("newPositionY")Integer newPositionY, @Param("newPositionZ")Integer newPositionZ);

}

package macaveavin.app.api.service.mapper;

import macaveavin.app.api.dto.CellarPlaceDto;
import macaveavin.app.api.entity.Cellar;
import macaveavin.app.api.entity.CellarPlace;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class CellarPlaceMapper {
    public CellarPlaceDto convertToDto(CellarPlace cellarPlace) {
        return new CellarPlaceDto(cellarPlace.getCellar_place_id(), cellarPlace.getPositionX(), cellarPlace.getPositionY(),
                cellarPlace.getPositionZ(), cellarPlace.getPositionOpt(), cellarPlace.getQuantityBottleMax(),
                cellarPlace.getCellar().getCellar_id());
    }

    public CellarPlace convertToEntity(CellarPlaceDto cellarPlaceDto, Cellar cellar) {
        return new CellarPlace(cellarPlaceDto.getPositionX(), cellarPlaceDto.getPositionY(), cellarPlaceDto.getPositionZ(), cellarPlaceDto.getPositionOpt(),
                cellarPlaceDto.getQuantityBottleMax(), cellar);
    }

}

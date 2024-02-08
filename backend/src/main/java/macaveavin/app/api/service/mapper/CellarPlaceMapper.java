package macaveavin.app.api.service.mapper;

import macaveavin.app.api.dto.CellarPlaceDto;
import macaveavin.app.api.entity.Cellar;
import macaveavin.app.api.entity.CellarPlace;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class CellarPlaceMapper {
    public CellarPlaceDto convertToDto(Optional<CellarPlace> cellarPlace) {
        return cellarPlace.map(place -> new CellarPlaceDto(place.getCellar_place_id(), place.getPositionX(), place.getPositionY(),
                place.getPositionZ(), place.getPositionOpt(), place.getQuantityBottleMax(),
                place.getCellar().getCellar_id())).orElse(null);
    }

    public CellarPlace convertToEntity(CellarPlaceDto cellarPlaceDto, Cellar cellar) {
        return new CellarPlace(cellarPlaceDto.getPositionX(), cellarPlaceDto.getPositionY(), cellarPlaceDto.getPositionZ(), cellarPlaceDto.getPositionOpt(),
                cellarPlaceDto.getQuantityBottleMax(), cellar);
    }

}

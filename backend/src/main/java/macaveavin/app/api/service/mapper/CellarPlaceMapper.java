package macaveavin.app.api.service.mapper;

import macaveavin.app.api.dto.CellarPlaceDto;
import macaveavin.app.api.entity.CellarPlace;
import macaveavin.app.api.entity.Wine;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CellarPlaceMapper {
    public CellarPlaceDto convertToDto(Optional<CellarPlace> cellarPlace) {
        return new CellarPlaceDto(cellarPlace.get().getCellar_place_id(), cellarPlace.get().getPosition(), cellarPlace.get().getPosition_opt(), cellarPlace.get().getQuantity(), cellarPlace.get().getWine());
    }

    public CellarPlace convertToEntity(CellarPlaceDto cellarPlaceDto, Wine wine) {
        return new CellarPlace(cellarPlaceDto.getPosition(), cellarPlaceDto.getPosition_opt(), cellarPlaceDto.getQuantity(), wine);
    }
}

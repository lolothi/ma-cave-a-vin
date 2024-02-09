package macaveavin.app.api.service.mapper;

import macaveavin.app.api.dto.CellarPlaceWineDto;
import macaveavin.app.api.dto.CellarPlaceWineSetDto;
import macaveavin.app.api.entity.CellarPlace;
import macaveavin.app.api.entity.CellarPlaceWine;
import macaveavin.app.api.entity.Wine;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CellarPlaceWineMapper {
    public CellarPlaceWineDto convertToDto(Optional<CellarPlaceWine> cellarPlaceWine) {
        if (cellarPlaceWine.isPresent()) {
            return new CellarPlaceWineDto(cellarPlaceWine.get().getCellar_place_wine_id(), cellarPlaceWine.get().getWine(), cellarPlaceWine.get().getCellarPlace(), cellarPlaceWine.get().getQuantityBottle());
        }
        return null;
    }

    public CellarPlaceWine convertToEntity(CellarPlaceWineSetDto cellarPlaceWineSetDto, CellarPlace cellarPlace, Wine wine) {
        return new CellarPlaceWine(cellarPlace, wine, cellarPlaceWineSetDto.getQuantityBottle());
    }

}

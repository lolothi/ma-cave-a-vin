package macaveavin.app.api.service.mapper;

import macaveavin.app.api.dto.CellarPlaceWineDto;
import macaveavin.app.api.entity.CellarPlaceWine;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CellarPlaceWineMapper {
    public CellarPlaceWineDto convertToDto(Optional<CellarPlaceWine> cellarPlaceWine) {
        return new CellarPlaceWineDto(cellarPlaceWine.get().getCellar_place_wine_id(), cellarPlaceWine.get().getWine(), cellarPlaceWine.get().getCellarPlace(), cellarPlaceWine.get().getQuantityBottle());
    }

    public CellarPlaceWine convertToEntity(CellarPlaceWineDto cellarPlaceWineDto) {
        return new CellarPlaceWine(cellarPlaceWineDto.getCellarPlace(), cellarPlaceWineDto.getWine(), cellarPlaceWineDto.getQuantityBottle());
    }

}

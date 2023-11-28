package macaveavin.app.api.service.mapper;

import macaveavin.app.api.dto.WineDto;
import macaveavin.app.api.entity.Wine;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WineMapper {
    public WineDto convertToDto(Optional<Wine> wine) {
        return wine.map(value -> new WineDto(value.getWine_id(), value.getName(), value.getAvailable_year(), value.getType(), value.getCountry(), value.getProducer(), value.getVariety(),
                value.getDesignation(), value.getEan(), value.getPicture_link(), value.getWith_food(), value.getNote(), value.getComments(),
                value.getTag(), value.getQuantity_tot(), value.getQuantity_in_wine_Cellar())).orElse(null);
    }

    public Wine convertToEntity(WineDto wineDto) {
        return new Wine(wineDto.getName(), wineDto.getAvailable_year(), wineDto.getType(), wineDto.getCountry(), wineDto.getProducer(), wineDto.getVariety(),
                wineDto.getDesignation(), wineDto.getEan(), wineDto.getPicture_link(), wineDto.getWith_food(), wineDto.getNote(), wineDto.getComments(),
                wineDto.getTag(), wineDto.getQuantity_tot(), wineDto.getQuantity_in_wine_Cellar());
    }
}

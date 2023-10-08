package macaveavin.app.api.service.mapper;

import macaveavin.app.api.dto.WineDto;
import macaveavin.app.api.entity.Wine;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WineMapper {
    public WineDto convertToDto(Optional<Wine> wine) {
        return wine.map(value -> new WineDto(value.getWine_id(), value.getName(), value.getYear(), value.getType(), value.getCountry(), value.getEan(), value.getComments())).orElse(null);
    }

    public Wine convertToEntity(WineDto wineDto) {
        return new Wine(wineDto.getName(), wineDto.getYear(), wineDto.getType(), wineDto.getCountry(), wineDto.getEan(), wineDto.getComments());
    }
}

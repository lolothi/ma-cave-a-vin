package macaveavin.app.api.service.mapper;

import macaveavin.app.api.dto.WineDto;
import macaveavin.app.api.entity.Wine;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WineMapper {
    public WineDto convertToDto(Optional<Wine> wine) {
        return wine.map(value -> new WineDto(value.getWineId(), value.getName(), value.getAvailableYear(), value.getType(), value.getCountry(), value.getProducer(), value.getVariety(),
                value.getDesignation(), value.getEan(), value.getPictureLink(), value.getWithFood(), value.getNote(), value.getComments(),
                value.getTag(), value.getQuantityTot(), value.getQuantityInWineCellar())).orElse(null);
    }

    public Wine convertToEntity(WineDto wineDto) {
        return new Wine(wineDto.getName(), wineDto.getAvailableYear(), wineDto.getType(), wineDto.getCountry(), wineDto.getProducer(), wineDto.getVariety(),
                wineDto.getDesignation(), wineDto.getEan(), wineDto.getPictureLink(), wineDto.getWithFood(), wineDto.getNote(), wineDto.getComments(),
                wineDto.getTag(), wineDto.getQuantityTot(), wineDto.getQuantityInWineCellar());
    }
}

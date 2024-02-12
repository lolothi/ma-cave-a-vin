package macaveavin.app.api.service.mapper;

import macaveavin.app.api.dto.WineDto;
import macaveavin.app.api.entity.Wine;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WineMapper {
    public WineDto convertToDto(Wine wine) {
        return new WineDto(wine.getWineId(), wine.getName(), wine.getAvailableYear(), wine.getType(), wine.getCountry(), wine.getProducer(), wine.getVariety(),
                wine.getDesignation(), wine.getEan(), wine.getPictureLink(), wine.getWithFood(), wine.getNote(), wine.getComments(),
                wine.getTag(), wine.getQuantityTot(), wine.getQuantityInWineCellar());

    }

    public Wine convertToEntity(WineDto wineDto) {
        return new Wine(wineDto.getName(), wineDto.getAvailableYear(), wineDto.getType(), wineDto.getCountry(), wineDto.getProducer(), wineDto.getVariety(),
                wineDto.getDesignation(), wineDto.getEan(), wineDto.getPictureLink(), wineDto.getWithFood(), wineDto.getNote(), wineDto.getComments(),
                wineDto.getTag(), wineDto.getQuantityTot(), wineDto.getQuantityInWineCellar());
    }
}

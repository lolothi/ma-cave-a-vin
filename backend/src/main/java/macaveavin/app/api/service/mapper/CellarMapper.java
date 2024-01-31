package macaveavin.app.api.service.mapper;

import macaveavin.app.api.dto.CellarDto;
import macaveavin.app.api.entity.Cellar;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CellarMapper {

    public CellarDto convertToDto(Optional<Cellar> optionalCellar) {
        return new CellarDto(optionalCellar.get().getCellar_id(), optionalCellar.get().getName(), optionalCellar.get().getQuantity_location_x(), optionalCellar.get().getQuantity_location_y(), optionalCellar.get().getQuantity_location_z(), optionalCellar.get().getQuantity_bottle_max());
    }

    public  Cellar convertToEntity(CellarDto cellarDto) {
        return new Cellar(cellarDto.getName(), cellarDto.getQuantity_location_x(), cellarDto.getQuantity_location_y(), cellarDto.getQuantity_location_z(), cellarDto.getQuantity_bottle_max());
    }

}

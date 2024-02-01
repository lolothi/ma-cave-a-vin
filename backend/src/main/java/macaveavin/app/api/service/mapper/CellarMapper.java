package macaveavin.app.api.service.mapper;

import macaveavin.app.api.dto.CellarDto;
import macaveavin.app.api.entity.Cellar;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CellarMapper {

    public CellarDto convertToDto(Optional<Cellar> optionalCellar) {
        return new CellarDto(optionalCellar.get().getCellar_id(), optionalCellar.get().getName(), optionalCellar.get().getQuantityLocationX(), optionalCellar.get().getQuantityLocationY(), optionalCellar.get().getQuantityLocationZ(), optionalCellar.get().getQuantityBottleMax());
    }

    public  Cellar convertToEntity(CellarDto cellarDto) {
        return new Cellar(cellarDto.getName(), cellarDto.getQuantityLocationX(), cellarDto.getQuantityLocationY(), cellarDto.getQuantityLocationZ(), cellarDto.getQuantityBottleMax());
    }

}

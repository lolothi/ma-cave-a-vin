package macaveavin.app.api.service.mapper;

import macaveavin.app.api.dto.CellarDto;
import macaveavin.app.api.entity.Cellar;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CellarMapper {

    public CellarDto convertToDto(Cellar optionalCellar) {
        return new CellarDto(optionalCellar.getCellar_id(), optionalCellar.getName(), optionalCellar.getQuantityLocationX(), optionalCellar.getQuantityLocationY(), optionalCellar.getQuantityLocationZ(), optionalCellar.getQuantityBottleMax());
    }

    public  Cellar convertToEntity(CellarDto cellarDto) {
        return new Cellar(cellarDto.getName(), cellarDto.getQuantityLocationX(), cellarDto.getQuantityLocationY(), cellarDto.getQuantityLocationZ(), cellarDto.getQuantityBottleMax());
    }

}

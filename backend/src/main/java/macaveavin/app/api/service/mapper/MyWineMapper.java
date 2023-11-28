package macaveavin.app.api.service.mapper;

import macaveavin.app.api.dto.MyWineDto;
import macaveavin.app.api.entity.MyWine;
import macaveavin.app.api.entity.Wine;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MyWineMapper {
    public MyWineDto convertToDto(Optional<MyWine> myWine) {
        return new MyWineDto(myWine.get().getMy_wine_id(), myWine.get().getPosition(), myWine.get().getPosition_opt(), myWine.get().getQuantity(), myWine.get().getWine());
    }

    public MyWine convertToEntity(MyWineDto myWineDto, Wine wine) {
        return new MyWine(myWineDto.getPosition(), myWineDto.getPosition_opt(), myWineDto.getQuantity(), wine);
    }
}

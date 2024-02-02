package macaveavin.app.api.service;

import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class SharedServices {

    public void updateFields(Object objectToUpdate, Object updatedDto){
        Field[] fields = updatedDto.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(updatedDto);
                if (value != null) {
                    Field wineField = objectToUpdate.getClass().getDeclaredField(field.getName());
                    wineField.setAccessible(true);
                    wineField.set(objectToUpdate, value);
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

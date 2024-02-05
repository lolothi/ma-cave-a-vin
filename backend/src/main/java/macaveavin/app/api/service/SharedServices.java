package macaveavin.app.api.service;

import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class SharedServices {

    /**
     * Update fields of the entity according to DTO updated Field only.
     * MAYBE NOT USE WITH DTO WITH FOREIGN KEY
     * @param objectToUpdate
     * @param updatedDto
     */
    public void updateFields(Object objectToUpdate, Object updatedDto){
        Field[] fields = updatedDto.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("fields: "+field);
            try {
                field.setAccessible(true);
                Object value = field.get(updatedDto);
                if (value != null) {
                    Field objectField = objectToUpdate.getClass().getDeclaredField(field.getName());
                    objectField.setAccessible(true);
                    objectField.set(objectToUpdate, value);
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

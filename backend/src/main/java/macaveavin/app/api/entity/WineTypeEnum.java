package macaveavin.app.api.entity;

import lombok.Getter;

@Getter
public enum WineTypeEnum {

    ROUGE(1),
    BLANC(2),
    ROSE(3),
    DEFAULT_VALUE(0);

    private final int value;
    WineTypeEnum(int value) {
        this.value = value;
    }

}

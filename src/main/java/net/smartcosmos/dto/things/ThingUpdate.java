package net.smartcosmos.dto.things;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.beans.ConstructorProperties;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ThingUpdate {

    private static final int VERSION = 1;
    @Setter(AccessLevel.NONE)
    private int version = VERSION;

    private Boolean active;

    @Builder
    @ConstructorProperties({"active"})
    public ThingUpdate(Boolean active) {
        this.active = active;

        this.version = VERSION;
    }
}

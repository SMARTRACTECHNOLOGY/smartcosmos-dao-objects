package net.smartcosmos.dto.things;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ThingCreate {

    private static final int VERSION = 1;
    @Setter(AccessLevel.NONE)
    private int version = VERSION;

    private String urn;
    private String type;
    private Boolean active;

    @Builder
    @ConstructorProperties({"urn", "type", "active"})
    public ThingCreate(String urn, String type, Boolean active)
    {
        this.urn = urn;

        this.type = type;
        this.active = active != null ? active : true;

        this.version = VERSION;
    }
}

package net.smartcosmos.dto.things;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ThingUpdate {

    private static final int VERSION = 1;
    @Setter(AccessLevel.NONE)
    private int version = VERSION;

    private String id;
    private String urn;
    private String type;
    private Boolean activeFlag;

    @Builder
    @ConstructorProperties({"id", "urn", "type", "activeFlag"})
    public ThingUpdate(String id, String urn, String type, Boolean activeFlag) {
        this.id = id;
        this.urn = urn;
        this.type = type;
        this.activeFlag = activeFlag;

        this.version = VERSION;
    }
}

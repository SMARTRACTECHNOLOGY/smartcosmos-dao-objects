package net.smartcosmos.dto.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectUpdate {

    private static final int VERSION = 1;
    @Setter(AccessLevel.NONE)
    private int version = VERSION;

    private String objectUrn;
    private String urn;
    private String type;
    private String name;
    private String description;
    private Boolean activeFlag;
    private String moniker;

    @Builder
    @ConstructorProperties({"objectUrn", "urn", "type", "name", "description", "activeFlag", "moniker"})
    public ObjectUpdate(String objectUrn, String urn, String type, String name, String description, Boolean activeFlag, String moniker) {
        this.objectUrn = objectUrn;
        this.urn = urn;
        this.type = type;
        this.name = name;
        this.description = description;
        this.activeFlag = activeFlag;
        this.moniker = moniker;

        this.version = VERSION;
    }
}

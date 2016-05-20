package net.smartcosmos.dto.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import net.smartcosmos.data.constraint.NotEmpty;

import java.beans.ConstructorProperties;

/**
 * @author voor
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectCreate {
    @NotEmpty
    private String objectUrn;
    @NotEmpty
    private String type;
    @NotEmpty
    private String name;
    private String description;
    private Boolean activeFlag;
    private String moniker;

    @Builder
    @ConstructorProperties({"objectUrn", "type", "name", "description", "activeFlag", "moniker"})
    public ObjectCreate(String objectUrn, String type, String name, String description, Boolean activeFlag, String moniker)
    {
        this.objectUrn = objectUrn;
        this.type = type;
        this.name = name;
        this.description = description;
        this.activeFlag = activeFlag != null ? activeFlag : true;
        this.moniker = moniker;
    }
}

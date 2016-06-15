package net.smartcosmos.dto.things;

import java.beans.ConstructorProperties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"version"})
@ApiModel(description = "Response received when querying for Things.")
public class ThingResponse {

    private static final int VERSION = 1;
    @Setter(AccessLevel.NONE)
    private int version = VERSION;

    @ApiModelProperty(required = true, dataType = "String",
                      value = "The system generated ID of the thing. The size is constrained by the database implementation being used.")
    private final String id;

    @ApiModelProperty(required = true, dataType = "String",
                      value = "The user specified URN of the thing. The size is constrained by the database implementation being used.")
    private final String urn;

    @ApiModelProperty(required = true, dataType = "String",
                      value = "The user defined type of the thing.  The size is constrained by the database implementation being used.")
    private final String type;

    @ApiModelProperty(required = true, dataType = "String", value = "The tenant ID of the owning account of the thing.")
    private final String tenantId;

    @ApiModelProperty(required = true, dataType = "Boolean", value = "Is the thing \"active\", defaults to true.")
    private Boolean active;

    @Builder
    @ConstructorProperties({"id", "urn", "type", "tenantId", "active"})
    public ThingResponse(String id, String urn, String type, String tenantId, Boolean active) {
        this.id = id;
        this.urn = urn;
        this.type = type;
        this.active = active;
        this.tenantId = tenantId;

        this.version = VERSION;
    }
}

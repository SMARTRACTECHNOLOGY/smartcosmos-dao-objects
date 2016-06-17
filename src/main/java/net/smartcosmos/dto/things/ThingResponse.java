package net.smartcosmos.dto.things;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"version"})
@ApiModel(description = "Response received when querying for Things.")
public class ThingResponse {

    private static final int VERSION = 1;
    @Setter(AccessLevel.NONE)
    private int version = VERSION;

    @ApiModelProperty(required = true, dataType = "String",
                      value = "The user specified URN of the thing. The size is constrained by the database implementation being used.")
    private final String urn;

    @ApiModelProperty(required = true, dataType = "String",
                      value = "The user defined type of the thing.  The size is constrained by the database implementation being used.")
    private final String type;

    @ApiModelProperty(required = true, dataType = "String", value = "The tenant ID of the owning account of the thing.")
    private final String tenantUrn;

    @ApiModelProperty(required = true, dataType = "Boolean", value = "Is the thing \"active\", defaults to true.")
    private Boolean active;

    @Builder
    @ConstructorProperties({"urn", "type", "tenantUrn", "active"})
    public ThingResponse(String urn, String type, String tenantUrn, Boolean active) {
        this.urn = urn;
        this.type = type;
        this.active = active;
        this.tenantUrn = tenantUrn;

        this.version = VERSION;
    }
}

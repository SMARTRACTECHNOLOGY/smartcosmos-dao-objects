package net.smartcosmos.dto.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.org.apache.xpath.internal.operations.String;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author voor
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description = "Response received when querying for things.")
public class ObjectResponse {
    @ApiModelProperty(required = true, value = "The system URN of the thing. The size is constrained to by the database implementation being used.",
                      dataType = "String")
    private final String urn;
    @ApiModelProperty(required = true, value = "The user specified URN of the thing. The size is constrained to by the database implementation being used.", dataType = "String")
    private final String objectUrn;
    @ApiModelProperty(required = true, value = "The user defined type of the thing.  The size is constrained to by the database implementation being used.", dataType = "String")
    private final String type;
    @ApiModelProperty(required = true, value = "The account URN of the owning account of the thing.", dataType = "String")
    private final String accountUrn;
    @ApiModelProperty(required = true, value = "The user defined name of the thing. The size is constrained to by the database implementation being" +
                                               " used.", dataType = "String")
    private final String name;
    @ApiModelProperty(required = true, value = "The time the thing was last updated.", dataType = "long")
    private Long lastModifiedTimestamp;
    @ApiModelProperty(value = "The user defined moniker of the thing. The size is constrained to by the database implementation being used. " +
                              "Default: null.", dataType = "String")
    private String moniker;
    @ApiModelProperty(value = "The user defined description of the thing. The size is constrained to by the database implementation being used. " +
                              "Default: null.", dataType = "String")
    private String description;
    @ApiModelProperty(required = true, value = "Is the thing \"active\", defaults to true.", dataType = "Boolean")
    private Boolean activeFlag;
}

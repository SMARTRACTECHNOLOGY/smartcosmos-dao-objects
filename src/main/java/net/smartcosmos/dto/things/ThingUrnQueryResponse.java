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
import java.util.Collection;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"version"})
@ApiModel(description = "Response received when querying for Things by a list of URNs.")
public class ThingUrnQueryResponse {

    private static final int VERSION = 1;
    @Setter(AccessLevel.NONE)
    private int version = VERSION;

    @ApiModelProperty(required = true, dataType = "Collection of ThingResponse",
        value = "The collection of found things.")
    private final Collection<ThingResponse> data;

    @ApiModelProperty(required = true, dataType = "Collection of String",
        value = "The collection of URNs that could not be found.")
    private final Collection<String> notFound;

    @Builder
    @ConstructorProperties({"data", "notFound"})
    public ThingUrnQueryResponse(Collection<ThingResponse> data, Collection<String> notFound) {

        this.data = data;
        this.notFound = notFound;

        this.version = VERSION;
    }
}

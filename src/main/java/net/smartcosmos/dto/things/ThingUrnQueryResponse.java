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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    private final List<ThingResponse> data;

    @ApiModelProperty(required = true, dataType = "Collection of String",
        value = "The collection of URNs that could not be found.")
    private final List<String> notFound;

    @Builder
    @ConstructorProperties({"data", "notFound"})
    public ThingUrnQueryResponse(Collection<ThingResponse> data, Collection<String> notFound) {

        this.data = new ArrayList<>();
        if (data != null) {
            this.data.addAll(data);
        }

        this.notFound = new ArrayList<>();
        if (notFound != null) {
            this.notFound.addAll(notFound);
        }

        this.version = VERSION;
    }
}

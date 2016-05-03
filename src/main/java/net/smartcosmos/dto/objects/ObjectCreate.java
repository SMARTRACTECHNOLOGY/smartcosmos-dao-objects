package net.smartcosmos.dto.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author voor
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Builder
public class ObjectCreate {
    @NotNull
    private String objectUrn;
    @NotNull
    private String type;
    @NotNull
    private String name;
    private String description;
    private Boolean activeFlag = true;
    private String moniker;
}

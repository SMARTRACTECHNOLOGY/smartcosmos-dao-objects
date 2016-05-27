package net.smartcosmos.dto.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Builder
public class ObjectUpdate {
    private String objectUrn;
    private String urn;
    private String type;
    private String name;
    private String description;
    private Boolean activeFlag;
    private String moniker;
}

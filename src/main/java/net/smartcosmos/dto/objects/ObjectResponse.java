package net.smartcosmos.dto.objects;

import lombok.Builder;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author voor
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ObjectResponse {
    private final String urn;

    private final String objectUrn;

    private String type;

    private final String accountUrn;
    private String name;
    private Long lastModifiedTimestamp;
    private String moniker;
    private String description;

    private Boolean activeFlag;
}

package net.smartcosmos.dto.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"version"})
public class ObjectResponse {

    private static final int VERSION = 1;
    @Setter(AccessLevel.NONE)
    private int version = VERSION;

    private final String urn;

    private final String objectUrn;

    private final String type;

    private final String accountUrn;
    private final String name;
    private Long lastModifiedTimestamp;
    private String moniker;
    private String description;

    private Boolean activeFlag;

    @Builder
    @ConstructorProperties({"urn", "objectUrn", "type", "accountUrn", "name", "lastModifiedTimestamp", "moniker", "description", "activeFlag"})
    public ObjectResponse(String urn, String objectUrn, String type, String accountUrn, String name, Long lastModifiedTimestamp, String moniker, String description, Boolean activeFlag) {
        this.urn = urn;
        this.objectUrn = objectUrn;
        this.type = type;
        this.accountUrn = accountUrn;
        this.name = name;
        this.lastModifiedTimestamp = lastModifiedTimestamp;
        this.moniker = moniker;
        this.description = description;
        this.activeFlag = activeFlag;

        this.version = VERSION;
    }
}

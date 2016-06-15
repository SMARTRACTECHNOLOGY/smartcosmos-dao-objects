package net.smartcosmos.dto.things;

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
public class ThingResponse {

    private static final int VERSION = 1;
    @Setter(AccessLevel.NONE)
    private int version = VERSION;

    private final String id;
    private final String urn;
    private final String type;
    private final String tenantId;
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

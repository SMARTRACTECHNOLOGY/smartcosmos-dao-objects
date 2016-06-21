package net.smartcosmos.dto.things;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel(description = "Paged response received when querying for Things.")
@Builder
public class PageInformation {
    private final Integer size;
    private final Long totalElements;
    private final Integer totalPages;
    private final Integer number;
}

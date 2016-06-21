package net.smartcosmos.dto.things;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.Collection;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"version"})
@ApiModel(description = "Paged response received when querying for Things.")
public class Page<T> {

    private final Collection<T> data;
    private final PageInformation page;

    @Builder
    @ConstructorProperties({"data", "page"})
    public Page(Collection<T> data, PageInformation page) {
        this.data = new ArrayList<>();
        if (data != null) {
            this.data.addAll(data);
        }

        this.page = page;
    }
}

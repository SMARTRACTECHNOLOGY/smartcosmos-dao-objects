package net.smartcosmos.dao.objects;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import net.smartcosmos.dto.objects.ObjectCreate;
import net.smartcosmos.dto.objects.ObjectResponse;

/**
 * @author voor
 */
public interface IObjectDao {

    ObjectResponse create(String accountUrn, ObjectCreate objectCreate);

    Optional<ObjectResponse> findByObjectUrn(String accountUrn, String objectUrn);

    List<ObjectResponse> getObjects();

    List<ObjectResponse> findByQueryParameters(String accountUrn, Map<String, Object> parameters);
}

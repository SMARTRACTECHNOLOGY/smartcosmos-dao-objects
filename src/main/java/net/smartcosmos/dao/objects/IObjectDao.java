package net.smartcosmos.dao.objects;

import net.smartcosmos.dto.objects.ObjectCreate;
import net.smartcosmos.dto.objects.ObjectUpdate;
import net.smartcosmos.dto.objects.ObjectResponse;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author voor
 */
public interface IObjectDao {

    ObjectResponse create(String accountUrn, ObjectCreate objectCreate);

    Optional<ObjectResponse> update(String accountUrn, ObjectUpdate objectUpdate);

    Optional<ObjectResponse> findByObjectUrn(String accountUrn, String objectUrn);

    Optional<ObjectResponse> findByUrn(String accountUrn, String urn);

    List<ObjectResponse> getObjects();

    List<ObjectResponse> findByQueryParameters(String accountUrn, Map<String, Object> parameters);

}

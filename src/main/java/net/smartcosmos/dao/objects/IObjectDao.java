package net.smartcosmos.dao.objects;

import java.util.List;
import java.util.Optional;

import net.smartcosmos.dto.objects.CreateObjectRequest;
import net.smartcosmos.dto.objects.GetObjectResponse;

/**
 * @author voor
 */
public interface IObjectDao {

    GetObjectResponse create(String accountUrn, CreateObjectRequest createObjectRequest);

    Optional<GetObjectResponse> findByObjectUrn(String accountUrn, String objectUrn);

    List<GetObjectResponse> getObjects();
}

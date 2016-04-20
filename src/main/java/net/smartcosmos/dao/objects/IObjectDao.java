package net.smartcosmos.dao.objects;

import net.smartcosmos.dto.objects.CreateObjectDto;
import net.smartcosmos.dto.objects.GetObjectDto;

import java.util.List;
import java.util.Optional;

/**
 * @author voor
 */
public interface IObjectDao {

    GetObjectDto create(String accountUrn, CreateObjectDto createObjectDto);

    Optional<GetObjectDto> findByObjectUrn(String accountUrn, String objectUrn);

    List<GetObjectDto> getObjects();
}

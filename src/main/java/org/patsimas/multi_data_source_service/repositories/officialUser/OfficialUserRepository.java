package org.patsimas.multi_data_source_service.repositories.officialUser;

import org.patsimas.multi_data_source_service.domain.officialUser.OfficialUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficialUserRepository extends JpaRepository<OfficialUser, Long> {
}

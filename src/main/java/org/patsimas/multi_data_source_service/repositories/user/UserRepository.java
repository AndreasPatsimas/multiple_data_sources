package org.patsimas.multi_data_source_service.repositories.user;

import org.patsimas.multi_data_source_service.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

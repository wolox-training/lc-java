package com.wolox.servingwebcontent.packages;

import com.wolox.servingwebcontent.models.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findFirstByUsername(String username);
}

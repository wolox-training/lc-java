package com.wolox.servingwebcontent.packages;

import com.wolox.servingwebcontent.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}

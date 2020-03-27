package com.wolox.servingwebcontent.packages;

import com.wolox.servingwebcontent.models.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {

}

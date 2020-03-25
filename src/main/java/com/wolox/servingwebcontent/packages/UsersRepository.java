package com.wolox.servingwebcontent.packages;

import com.wolox.servingwebcontent.models.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Long> { }

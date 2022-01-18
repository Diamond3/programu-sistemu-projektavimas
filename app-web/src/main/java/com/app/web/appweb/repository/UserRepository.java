package com.app.web.appweb.repository;

import com.app.web.appweb.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}

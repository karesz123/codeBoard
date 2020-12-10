package com.codeBoard.repository;

import com.codeBoard.model.entity.AccountUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<AccountUser, Long> {

    Optional<AccountUser> findByUserName(String userName);

}

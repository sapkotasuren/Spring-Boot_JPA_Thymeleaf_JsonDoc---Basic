package com.softnp.db.springbootmysql.repository;

import com.softnp.db.springbootmysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by suren on 01/02/2018.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}

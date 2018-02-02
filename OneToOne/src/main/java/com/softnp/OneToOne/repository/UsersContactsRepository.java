package com.softnp.OneToOne.repository;

import com.softnp.OneToOne.model.UsersContacts;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by suren on 02/02/2018.
 */
public interface UsersContactsRepository extends JpaRepository<UsersContacts, Integer> {
}

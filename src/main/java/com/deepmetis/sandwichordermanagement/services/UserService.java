package com.deepmetis.sandwichordermanagement.services;

import com.deepmetis.sandwichordermanagement.domain.entities.User;

public interface UserService {

    User save(User user);

    User findByEmail(String email);

    boolean existsByEmail(String email);

}

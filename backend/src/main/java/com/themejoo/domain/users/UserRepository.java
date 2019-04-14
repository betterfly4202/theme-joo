package com.themejoo.domain.users;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by betterfly
 * Date : 2019.04.15
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String name);
}

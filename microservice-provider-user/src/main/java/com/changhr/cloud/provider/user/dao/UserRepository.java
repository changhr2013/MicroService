package com.changhr.cloud.provider.user.dao;

import com.changhr.cloud.provider.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chang
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

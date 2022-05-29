package io.github.anantharajuc.aes.domain.repository;

import io.github.anantharajuc.aes.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

}

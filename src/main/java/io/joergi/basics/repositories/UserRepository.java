package io.joergi.basics.repositories;

import io.joergi.basics.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findUserByUsername(String username);

    User findUserByEmail(String email);

    User findUserByUsernameAndPassword(String username, String password);

    User findUserByEmailAndPassword(String email, String password);
}

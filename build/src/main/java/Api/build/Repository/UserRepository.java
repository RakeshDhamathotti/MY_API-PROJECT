package Api.build.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Api.build.Entity.User;


public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findByUserName(String userName);
    
}

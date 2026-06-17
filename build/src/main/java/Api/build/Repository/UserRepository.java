<<<<<<< HEAD
package Api.build.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Api.build.Entity.User;


public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findByUserName(String userName);
    
}
=======
package Api.build.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Api.build.Entity.User;


public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findByUserName(String userName);
    
}
>>>>>>> 606cd7d39036706b88a9651523fd3ec9a3d8ac67

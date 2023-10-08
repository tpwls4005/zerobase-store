
package Repository;

import Model.User;
import org.springframework.data.jpa.repository.JpaRepository;



    // UserRepository.java
    public interface UserRepository extends JpaRepository<User, Long> {
        User findByUsername(String username);
    }

    // UserService.java (다른 패키지에 위치)




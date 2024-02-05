package community.portal.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import community.portal.Entity.UsersEntity;
import java.util.List;


public interface Users extends CrudRepository<UsersEntity, Long> 
{
    UsersEntity findByUsername(String username);

    @Query(value = "SELECT * FROM users u WHERE u.firstname LIKE %?1% AND u.status = 'active'", nativeQuery = true)
    List<UsersEntity> findByFirstname(String firstname);

    @Query(value = "SELECT * FROM users u WHERE u.lastname LIKE %?1% AND u.status = 'active'", nativeQuery = true)
    List<UsersEntity> findByLastname(String lastname);

    @Query(value = "SELECT * FROM users u WHERE u.city LIKE %?1% AND u.status = 'active'", nativeQuery = true)
    List<UsersEntity> findByCity(String city);

    @Query(value = "SELECT * FROM users u WHERE u.email LIKE %?1% AND u.status = 'active'", nativeQuery = true)
    List<UsersEntity> findByEmail(String email);

    @Query(value = "SELECT * FROM users u WHERE u.firstname LIKE %?1% AND NOT status = 'pending'", nativeQuery = true)
    List<UsersEntity> findByFirstnameAdmin(String firstname);

    @Query(value = "SELECT * FROM users u WHERE u.lastname LIKE %?1% AND NOT status = 'pending'", nativeQuery = true)
    List<UsersEntity> findByLastnameAdmin(String lastname);

    @Query(value = "SELECT * FROM users u WHERE u.city LIKE %?1% AND NOT status = 'pending'", nativeQuery = true)
    List<UsersEntity> findByCityAdmin(String city);

    @Query(value = "SELECT * FROM users u WHERE u.email LIKE %?1% AND NOT status = 'pending'", nativeQuery = true)
    List<UsersEntity> findByEmailAdmin(String email);

    @Query(value = "SELECT * FROM users u WHERE u.id = ?1 AND u.status = ?2", nativeQuery = true)
    UsersEntity findUserWithId(String id, String status);

    @Query(value = "SELECT * FROM users u WHERE u.id = ?1 AND NOT status = 'pending'", nativeQuery = true)
    UsersEntity findUserWithIdAdmin(String id);

    @Query(value = "SELECT * FROM users u WHERE u.username = ?1 AND u.verify_code = ?2 AND u.status = ?3", nativeQuery = true)
    UsersEntity findPendingUser(String username, String token, String status);

    @Query(value = "SELECT * FROM users u WHERE u.email = ?1 AND u.status = ?2", nativeQuery = true)
    UsersEntity findActiveEmail(String email, String status);
}

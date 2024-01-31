package community.portal.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import community.portal.Entity.RoleEntity;

@Repository
public interface Roles extends CrudRepository<RoleEntity, Long> 
{
    RoleEntity findByRoles(String role);
}

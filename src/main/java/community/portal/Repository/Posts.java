package community.portal.Repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import community.portal.Entity.PostEntity;

@Repository
public interface Posts extends CrudRepository<PostEntity, Long>, JpaSpecificationExecutor<PostEntity> 
{
    @Query(value = "SELECT * FROM posts WHERE status = 'active' ORDER BY post_id DESC", nativeQuery = true)
    List<PostEntity> findAllDesc();
}

package community.portal.Repository;

import java.util.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import community.portal.Entity.CommentEntity;

public interface Comments extends CrudRepository<CommentEntity, Long>  
{
    @Query(value = "SELECT * FROM comments c WHERE c.post_id =?1 AND c.status = 'active' ORDER BY comment_id DESC", nativeQuery = true)
    List<CommentEntity> findAllByIdDesc(String post_id);
    
    @Query(value = "SELECT * FROM comments c WHERE c.post_id =?1 AND c.status = 'active'", nativeQuery = true)
    List<CommentEntity> findAllByPostId(String post_id);
}

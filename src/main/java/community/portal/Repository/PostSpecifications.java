package community.portal.Repository;

import org.springframework.data.jpa.domain.Specification;

import community.portal.Entity.PostEntity;

public class PostSpecifications 
{
    public static Specification<PostEntity> findByContent(String content)
    {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.<String>get("content"), "%" + content + "%");
    }     
}

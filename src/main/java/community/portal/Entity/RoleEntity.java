package community.portal.Entity;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RoleEntity 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 255, nullable = false, unique = true)
    String roles;

    @ManyToMany(mappedBy = "roles")
    Set<UsersEntity> users;

    public Long getId() 
    {
        return this.id;
    }

    public Long setId(Long id) 
    {
        this.id = id;
        return this.id;
    }

    public String getRoles() 
    {
        return this.roles;
    }

    public String setRole(String roles) 
    {
        this.roles = roles;
        return this.roles;
    }
}

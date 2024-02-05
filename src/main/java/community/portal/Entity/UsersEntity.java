package community.portal.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import community.portal.Repository.Comments;


@Entity
@Table(name = "users")
public class UsersEntity 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 255, nullable = false)
    String username;

    @Column(length = 255, nullable = false)
    String password;

    @Column(length = 255, nullable = false)
    String firstname;

    @Column(length = 255, nullable = false)
    String lastname;

    @Column(length = 255, nullable = false)
    String image;

    @Column(length = 255, nullable = true)
    String company_name;

    @Column(length = 255, nullable = true)
    String city;

    @Column(length = 255, nullable = true)
    String otp;

    @Column(length = 255, nullable = true)
    String verify_code;

    @Column(length = 255, nullable = true)
    String status;

    @Column(length = 255, nullable = true)
    String email;

    @ManyToMany(mappedBy = "users")
    Set<PostEntity> posts = new HashSet<PostEntity>();

    @ManyToMany(mappedBy = "users")
    Set<CommentEntity> comments = new HashSet<CommentEntity>();

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<RoleEntity> roles = new HashSet<RoleEntity>();

    public Long getId() 
    {
        return this.id;
    }

    public Long setId(Long id) 
    {
        this.id = id;
        return this.id;
    }

    public String getUsername() 
    {
        return this.username;
    }

    public String setUsername(String username) 
    {
        this.username = username;
        return this.username;
    }

    public String getPassword() 
    {
        return this.password;
    }

    public String setPassword(String password) 
    {
        this.password = password;
        return this.password;
    }

    public String getFirstname() 
    {
        return this.firstname;
    }

    public String setFirstname(String firstname) 
    {
        this.firstname = firstname;
        return this.firstname;
    }

    public String getLastname() 
    {
        return this.lastname;
    }

    public String setLastname(String lastname) 
    {
        this.lastname = lastname;
        return this.lastname;
    }

    public String getImage() 
    {
        return this.image;
    }

    public String setImage(String image) 
    {
        this.image = image;
        return this.image;
    }

    public String getCompany_name() 
    {
        return this.company_name;
    }

    public String setCompany_name(String company_name) 
    {
        this.company_name = company_name;
        return this.company_name;
    }

    public String getCity() 
    {
        return this.city;
    }

    public String setCity(String city) 
    {
        this.city = city;
        return this.city;
    }

    public String getOtp() 
    {
        return this.otp;
    }

    public String setOtp(String otp) 
    {
        this.otp = otp;
        return this.otp;
    }

    public String getVerify_code() 
    {
        return this.verify_code;
    }

    public String setVerify_code(String verify_code) 
    {
        this.verify_code = verify_code;
        return this.verify_code;
    }

    public String getStatus() 
    {
        return this.status;
    }

    public String setStatus(String status) 
    {
        this.status = status;
        return this.status;
    }

    public String getEmail() 
    {
        return this.email;
    }

    public String setEmail(String email) 
    {
        this.email = email;
        return this.email;
    }

    public Set<RoleEntity> getRoles()
    {
        return this.roles;
    }

    public void setRoles(RoleEntity roles)
    {
        this.roles.add(roles);
    }

}

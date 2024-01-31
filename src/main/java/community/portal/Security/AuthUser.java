package community.portal.Security;

import java.util.Collection;
import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import community.portal.Entity.RoleEntity;
import community.portal.Entity.UsersEntity;

public class AuthUser implements UserDetails
{
    private UsersEntity user;

    public AuthUser(UsersEntity user)
    {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() 
    {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        for(RoleEntity role: this.user.getRoles())
        {
            authorities.add(new SimpleGrantedAuthority(role.getRoles()));
        }
    
        return authorities;
    }

    @Override
    public String getPassword() 
    {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() 
    {
        return this.user.getId().toString();
    }

    @Override
    public boolean isAccountNonExpired() 
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() 
    {
        return true;
    }
    

    @Override
    public boolean isCredentialsNonExpired() 
    {
        return true;
    }

    @Override
    public boolean isEnabled() 
    {
        return true;
    }
    
}

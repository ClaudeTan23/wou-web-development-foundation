package community.portal.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import community.portal.Entity.UsersEntity;
import community.portal.Repository.Users;

@Service
public class CustomUserDetails implements UserDetailsService
{
    @Autowired
    private Users user;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
    {
        UsersEntity AuthUser = user.findByUsername(username);

        if(AuthUser != null && AuthUser.getStatus().equals("active"))
        {
            return new AuthUser(AuthUser);
            
        } else 
        {
            throw new UsernameNotFoundException(username);
        }
    }
    
}

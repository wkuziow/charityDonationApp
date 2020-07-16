package pl.coderslab.charity.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class SpringDataUserDetailsService implements UserDetailsService {
 
    private UserService userService;
 
    @Autowired
    public void setUserRepository(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userService.findByUsernameAndEnabled(username);
        if (user == null) {throw new UsernameNotFoundException(username); }
       Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
       grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
        return new CurrentUser(user.getEmail(),user.getPassword(),
                grantedAuthorities, user);

    }
}
package com.themejoo.domain.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.04.15
 */
@Service
public class UserService implements UserDetailsService  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @PostConstruct
    public void init(){
        User defaultUser = userRepository.findByUserName("betterFLY");
        if(defaultUser == null){
            User user = new User();
            user.setUserName("betterFLY");
            user.setUserPassword("1234");
            User makeUser = this.save(user);
            System.out.println(makeUser.toString());
        }

    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
         User user = userRepository.findByUserName(userName);
         return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(), getAuthorities());
    }

    private Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }
}

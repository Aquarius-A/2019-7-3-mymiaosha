package com.mooc.miaosha.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fukang.yang 791934683@qq.com  fukang.yang@transwarp.io
 * @date 2019/7/1 15:48
 */
public abstract class MyUserDetailsService implements UserDetailsService {
//    @Autowired
//    private UsersRepository userRepository;
//
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Users> users = userRepository.findByName(username);
//        if (!users.isPresent()) {
//            throw new UsernameNotFoundException("user not exists.");
//        }
//        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
//        authList.add(new SimpleGrantedAuthority("ROLE_USER"));
//        UserDetails userDetail = new User(users.get().getName(), users.get().getPassword(), authList);
//        return userDetail;
//    }
}

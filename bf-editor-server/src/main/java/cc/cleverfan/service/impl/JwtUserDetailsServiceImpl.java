package cc.cleverfan.service.impl;

import cc.cleverfan.common.JwtUserFactory;
import cc.cleverfan.entity.Users;
import cc.cleverfan.repository.UsersRepository;
import cc.cleverfan.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author chengfan
 * @create 2017-05-03 上午9:01
 */
@Service
public class JwtUserDetailsServiceImpl implements JwtUserDetailsService, UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}

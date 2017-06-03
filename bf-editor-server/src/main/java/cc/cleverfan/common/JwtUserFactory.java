package cc.cleverfan.common;

import cc.cleverfan.entity.Users;
import cc.cleverfan.module.JwtUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chengfan
 * @create 2017-05-03 上午8:51
 */
public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(Users user) {
        return new JwtUser(
                user.getId(),
                user.getUserName(),
                user.getUserPassword(),
                user.getUserEmail(),
                mapToGrantedAuthorities(user.getUserRole()),
                user.getLastPasswordResetDate()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(String userRole) {
        List<String> list = new ArrayList<>();
        list.add(userRole);
        return list.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}

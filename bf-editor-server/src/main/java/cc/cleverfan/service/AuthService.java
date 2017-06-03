package cc.cleverfan.service;

import cc.cleverfan.entity.Users;

/**
 * Created by chengfan on 2017/5/3.
 */
public interface AuthService {
    Users register(Users userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);
}

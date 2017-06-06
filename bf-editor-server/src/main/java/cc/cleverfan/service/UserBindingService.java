package cc.cleverfan.service;

import cc.cleverfan.entity.UserBinding;

import java.util.List;

/**
 * Created by chengfan on 2017/6/6.
 */
public interface UserBindingService {

    List<UserBinding> getUserBindingsByUserId(int userId);
}

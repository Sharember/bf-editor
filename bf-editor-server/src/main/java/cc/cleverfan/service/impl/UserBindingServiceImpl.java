package cc.cleverfan.service.impl;

import cc.cleverfan.entity.UserBinding;
import cc.cleverfan.repository.UserBindingRepository;
import cc.cleverfan.service.UserBindingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chengfan
 * @create 2017-06-06 下午3:07
 */
@Service
public class UserBindingServiceImpl implements UserBindingService {
    @Autowired
    private UserBindingRepository userBindingRepository;

    @Override
    public List<UserBinding> getUserBindingsByUserId(int userId) {
        return userBindingRepository.findBindingsByFkUserId(userId);
    }
}

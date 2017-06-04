package cc.cleverfan.service.impl;

import cc.cleverfan.entity.UserDir;
import cc.cleverfan.repository.UserDirRepository;
import cc.cleverfan.service.UserDirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chengfan
 * @create 2017-06-04 下午7:34
 */
@Service
public class UserDirServiceImpl implements UserDirService {

    @Autowired
    private UserDirRepository userDirRepository;

    @Override
    public UserDir getUserDir(int id) {
        return userDirRepository.findOne(id);
    }

    @Override
    public List<UserDir> getUserDirsByFkUserId(int fkUserId) {
        return userDirRepository.findUserDirsByFkUserId(fkUserId);
    }
}

package cc.cleverfan.service;

import cc.cleverfan.entity.UserDir;

import java.util.List;

/**
 * Created by chengfan on 2017/6/4.
 */

public interface UserDirService {

    UserDir getUserDir(int id);

    List<UserDir> getUserDirsByFkUserId(int fkUserId);
}

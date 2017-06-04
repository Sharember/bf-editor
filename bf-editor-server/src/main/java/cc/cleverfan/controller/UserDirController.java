package cc.cleverfan.controller;

import cc.cleverfan.entity.UserDir;
import cc.cleverfan.repository.UserDirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chengfan
 * @create 2017-06-04 下午7:36
 */
@RestController
@RequestMapping("/userDir")
@PreAuthorize("hasRole('USER','ADMIN')")
public class UserDirController {

    @Autowired
    private UserDirRepository userDirRepository;

    @RequestMapping(value = "/userId", method = RequestMethod.GET)
    public List<UserDir> getUserDirsById(int userId){
        return userDirRepository.findUserDirsByFkUserId(userId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserDir saveUserDir(UserDir userDir){
         return userDirRepository.save(userDir);
    }

}

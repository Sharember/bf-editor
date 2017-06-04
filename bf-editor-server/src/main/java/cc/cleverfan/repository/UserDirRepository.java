package cc.cleverfan.repository;

import cc.cleverfan.entity.UserDir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chengfan on 2017/6/4.
 */
@Repository
public interface UserDirRepository extends JpaRepository<UserDir, Integer> {

    /**
     *
     * @param fkUserId
     * @return
     */
    List<UserDir> findUserDirsByFkUserId(int fkUserId);
}

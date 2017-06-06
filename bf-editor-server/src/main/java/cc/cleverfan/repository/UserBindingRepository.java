package cc.cleverfan.repository;

import cc.cleverfan.entity.UserBinding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chengfan on 2017/6/6.
 */
@Repository
public interface UserBindingRepository extends JpaRepository<UserBinding, Integer> {
    List<UserBinding> findBindingsByFkUserId(int fkUserId);
}

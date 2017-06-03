package cc.cleverfan.repository;

import cc.cleverfan.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chengfan on 2017/5/3.
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
    Users findByUserName(String userName);

    @Override
    List<Users> findAll();

    @Override
    Users save(Users userToAdd);


}

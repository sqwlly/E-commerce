package com.ecommerce.demo.Repository;

import com.ecommerce.demo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String > {
    @Override
    public void delete(User user);
    public User findByUserNameAndPassWord(String userName, String passWord);
}

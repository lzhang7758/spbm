package com.zl.spbm;

import com.zl.spbm.entity.User;
import org.junit.Test;

import java.util.Optional;

/**
 * @Author: lzhang
 * @Date: 2019/9/20 11:30
 */
public class OptionalTest {


    public User getUserById(){
        return null;
    }

    public User getUserById(Integer id){
        return new User(1,"Jack 01");
    }

    @Test
    public void ifPresentTest (){
        Optional<User> user = Optional.ofNullable(getUserById(1));
        user.ifPresent(u -> System.out.println(u.getUserName()));
    }

    @Test
    public void orEles(){
        User user = Optional.ofNullable(getUserById()).orElse(new User(1,"tom"));
        System.out.println(user.getUserName());
    }

    @Test
    public void orElesGet() {
        User user = Optional.ofNullable(getUserById()).orElseGet(() -> new User(0, "Unknown"));
        System.out.println("userName is :" + user.getUserName());
    }

    @Test
    public void mapTest(){
        String username = Optional.ofNullable(getUserById(1))
                .map(user -> user.getUserName())
                .orElse("Unknown");
        System.out.println(username);

        Optional<String> name = Optional.of(Optional.ofNullable(getUserById(1))
                .map(user -> user.getUserName())
                .map(userName -> userName.toLowerCase())
                .map(userName -> userName.replace(" ", "_"))
                .orElse("Unknown"));

        System.out.println("name =" + name);
    }


}

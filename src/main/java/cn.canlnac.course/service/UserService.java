package cn.canlnac.course.service;

/**
 * Created by cecil on 2016/9/20.
 */
public interface UserService {
    int create(String username, String password, String userStatus);
}
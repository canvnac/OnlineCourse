package cn.canlnac.course.dao;

import cn.canlnac.course.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 登录用户的数据接口
 */
@Component
public interface UserDao {
    /**
     * 创建用户
     * @param username      用户名
     * @param password      密码
     * @param userStatus    用户类型：老师，学生，管理员
     * @return              返回创建的用户ID
     */
    int create(@Param("username") String username, @Param("password") String password, @Param("userStatus") String userStatus);

    /**
     * 根据用户ID，获取该用户登录信息
     * @param id    用户ID
     * @return      登录用户数据
     */
    User findByID(@Param("id") int id);

    /**
     * 根据条件获取登录用户列表
     * @param start         分页开始位置
     * @param count         分页返回数目
     * @param conditions    过滤条件，status数组，userStatus数组，username数组
     * @return              登录用户数据列表
     */
    List<User> getList(@Param("start") int start, @Param("count") int count, @Param("conditions") Map<String, Object> conditions);

    /**
     * 根据条件，统计登录用户数目
     * @param conditions    过滤条件，status数组，userStatus数组，username数组
     * @return              登录用户列表的数目
     */
    int count(@Param("conditions") Map<String, Object> conditions);

    /**
     * 更新登录用户的字段
     * @param id        用户ID
     * @param fields    字段和值
     * @return          更新的数目
     */
    int update(@Param("id") int id, @Param("fields") Map<String, Object> fields);

    /**
     * 临时封号，永久封号
     * @param id        用户ID
     * @param status    修改的状态，lock，dead
     * @param lockDate  封号开始时间
     * @param endDate   封号结束时间，dead状态，可以省略
     * @return          更新的数目
     */
    int lock(@Param("id") int id, @Param("status") String status, @Param("lockDate") Date lockDate, @Param("endDate") Date endDate);

    /**
     * 对用户继续解封
     * @param id    用户ID
     * @return      更新的数目
     */
    int unlock(@Param("id") int id);
}

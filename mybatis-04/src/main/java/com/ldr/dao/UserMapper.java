package com.ldr.dao;

import com.ldr.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //使用注解来映射简单语句会使代码显得更加简洁，
    // 然而对于稍微复杂一点的语句，Java 注解就力不从心了，并且会显得更加混乱。
    // 因此，如果你需要完成很复杂的事情，那么最好使用 XML 来映射语句。

    //选择何种方式来配置映射，以及认为映射语句定义的一致性是否重要，
    // 这些完全取决于你和你的团队。
    // 换句话说，永远不要拘泥于一种方式，你可以很轻松的在基于注解和 XML 的语句映射方式间自由移植和切换。

    @Select("select * from user")
    List<User> getUserS();

    //方法存在多个参数，所有参数前面必须加上@Param("id")注解
    @Select("select * from user where id = #{id} ")
    //下面两条语句效果一样，@param中的字段只是形参，只需要和对应sql语句一致就行
    //User getUserById(@Param("id2") int id2);
    User getUserById(@Param("id") int id);

    @Insert("insert into user(id,name,pwd) value (#{id}, #{name}, #{password})")
    int addUser(User user);

    @Update("update user set name =#{name},pwd =#{password} where id = #{id}")
    int updateUser(User user);
}

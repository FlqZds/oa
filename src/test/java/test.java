import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.util.DateUtils;
import com.fcfz.oa.common.info;
import com.fcfz.oa.common.utils.MySqlSessionFactory;
import com.fcfz.oa.entity.Log;
import com.fcfz.oa.entity.Role;
import com.fcfz.oa.entity.User;
import com.fcfz.oa.mapper.LogMapper;
import com.fcfz.oa.mapper.RoleMapper;
import com.fcfz.oa.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class test {

    @Test
    public void tt()
    {
        User user = new User();
        String s = JSON.toJSONString(new info("400", "errInfo.getErrMessage()", user,null));
        System.out.println(s);
    }


//    测时间
    @Test
    public void testTime(){
        Date date = new Date();
        System.out.println(date);
        String date1 = DateUtils.format(date);
        System.out.print("当前时间:"+date1);

    }


    @Test
    public void testFind() {
        System.out.println("hello");
        System.setProperty("jdk.tls.client.protocols", "TLSv1.2");

        try {
            SqlSession session = MySqlSessionFactory.getSession();
            LogMapper mapper = session.getMapper(LogMapper.class);
            UserMapper userMapper = session.getMapper(UserMapper.class);
            RoleMapper roleMapper = session.getMapper(RoleMapper.class);

            Log log = mapper.selectByPrimaryKey(1);

            User user = userMapper.selectByPrimaryKey(1);

            Role role = roleMapper.selectByPrimaryKey(1);

            System.out.println("当前日志：" + log);
            System.out.println("当前用户：" + user);
            System.out.println("当前权限：" + role);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            MySqlSessionFactory.closeSession();
        }

    }

}

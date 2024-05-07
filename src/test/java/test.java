import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.util.DateUtils;
import com.fcfz.oa.common.info;
import com.fcfz.oa.common.utils.MySqlSessionFactory;
import com.fcfz.oa.entity.User;
import com.fcfz.oa.mapper.LogMapper;
import com.fcfz.oa.mapper.RoleMapper;
import com.fcfz.oa.mapper.UserMapper;
import com.fcfz.oa.service.impl.PowerRoleShow;
import com.fcfz.oa.service.impl.login;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class test {

    @Test
    public void tt()
    {
        User user = new User();
        String s = JSON.toJSONString(new info("400", "errInfo.getErrMessage()", user,null,null));
        System.out.println(s);
    }


//    测时间
    @Test
    public void testTime(){
        Date date = new Date();
        System.out.println(date);
        String date1 = DateUtils.format(date);
        System.out.println("当前时间:"+date1);

        String userid="a";
        System.out.println(StringUtils.isNumeric(userid));

    }

    @Test
    public void testSHowRole() {
        PowerRoleShow powerRoleShow = new PowerRoleShow();
        info info = powerRoleShow.showRole("1", "2");
        System.out.println(info);


    }


    //    测用户注册
    @Test
    public void testInsert(){
        SqlSession session = MySqlSessionFactory.getSession();
        login login=new login();
        try {

            info info = login.registerUser("zds", "123456", "zds13579", "13570897076");


            String s = JSON.toJSONString(info);

            System.out.println(s);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            MySqlSessionFactory.closeSession();
        }

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

            List<User> userList = userMapper.selectAllUser();

            String s = JSON.toJSONString(userList);

            System.out.println(s);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            MySqlSessionFactory.closeSession();
        }

    }

}

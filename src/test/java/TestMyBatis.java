import com.alibaba.fastjson.JSON;
import com.gemini.ssm.model.User;
import com.gemini.ssm.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author: linyijin
 * @Date: Created in 2018/2/6 10:47
 * @Description:
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestMyBatis {
    private static Logger logger = Logger.getLogger(TestMyBatis.class);

    @Resource
    private UserService userService = null;


    @Test
    public void test() {
        User user = userService.getUserByID(1);
        System.out.println(user.getUserName());
        // logger.info("值："+user.getUserName());
        logger.info(JSON.toJSONString(user));
    }
}

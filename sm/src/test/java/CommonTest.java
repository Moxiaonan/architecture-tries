import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.mxn.architecture.tries.sm.biz.HelloBiz;
import org.mxn.architecture.tries.sm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * TODO
 *
 * @author moxiaonan
 * @since 2020/11/25
 */
public class CommonTest {
    @Autowired
    HelloBiz helloBiz;
    @Test
    public void split(){
        String str = "get one  billion   dollar";
        String[] split = StringUtils.split(str,StringUtils.SPACE);
        for (String s : split) {
            System.out.println(String.format("{%s}",s));
        }
    }
    @Test
    public void optional(){
        List<User> a = Arrays.asList(new User(1, "a"));
        User a1 = Optional.ofNullable(a).map(lu -> lu.get(1)).orElseGet(() -> new User(0, "default"));
        System.out.println(a1);
    }
    @Test
    public void endBeginDay(){
        DateUtil.endOfDay(new Date());
    }

}

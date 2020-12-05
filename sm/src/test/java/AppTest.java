import org.junit.Test;
import org.junit.runner.RunWith;
import org.mxn.architecture.tries.sm.App;
import org.mxn.architecture.tries.sm.biz.HelloBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
public class AppTest {
    @Autowired
    HelloBiz helloBiz;

    @Test
    public void trans(){
        try {
            helloBiz.codeTrans();
        } catch (Exception e) {
            System.out.println("-----error----");
        }
    }
}

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mxn.architecture.tries.sm.App;
import org.mxn.architecture.tries.sm.biz.HelloBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

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

    @Test
    public void playsOff(){
        helloBiz.outPlaysOff();
    }

    @Test
    public void playsOffGirls(){
        helloBiz.outPlaysOffGirls();
    }

    @Test
    public void nets(){
        try {
            helloBiz.outManager();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void oom(){
        ArrayList<Byte[]> list = new ArrayList<>();
        while (true){
            System.out.println(list.size());
            list.add(new Byte[1024 * 1024 * 10]);
        }
    }

    @Test
    public void oom2(){
        while (true){
            byte[] bytes = new byte[1024 * 1024 * 10];
        }
    }
}

import cn.codemao.cloud.core.common.result.Result;
import cn.codemao.service.platform.supplychain.common.client.WaybillClient;
import cn.codemao.service.platform.supplychain.common.client.domain.LogisticsDetailItemResponse;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mxn.architecture.tries.sm.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * TODO
 *
 * @author moxiaonan
 * @since 2020/11/24
 */
@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
public class FeignTest {
    @Autowired
    WaybillClient waybillClient;
    @Test
    public void get(){
        Result<List<LogisticsDetailItemResponse>> deliveryWaybillNo = waybillClient.getLogisticsByDeliveryWaybillNo("JDVC05795779572","JDL");
        System.out.println(deliveryWaybillNo);
    }
}

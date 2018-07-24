package cn.tk.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author : itw_xieyy
 * @date : Created in 2018/7/23
 * @description :
 */

@Component
public class ScheduleTask {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleTask.class);

    public void sayHello() {
        logger.info("哈哈哈哈哈");
    }
}

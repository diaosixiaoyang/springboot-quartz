package cn.tk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : itw_xieyy
 * @date : Created in 2018/7/23
 * @description :
 */
@SpringBootApplication
public class SpringbootQuartzApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringbootQuartzApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringbootQuartzApplication.class, args);
        logger.info("定时任务系统已经启动。。。");
    }
}

package com.flyapi.web.listener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 * Author: qfwang
 * Date: 2017-11-21 上午10:51
 */
@Service
public class StartListener implements ApplicationListener<ContextRefreshedEvent>
{

    private static final String[] BANNER = new String[]{"", "  __  _                       _ ", " / _|| |                     (_)", "| |_ | | _   _   __ _  _ __   _ ", "|  _|| || | | | / _` || '_ \\ | |", "| |  | || |_| || (_| || |_) || |","|_|  |_| \\__, | \\__,_|| .__/ |_|","          __/ |       | |       ","         |___/        |_|       "};
    private static final String FLYAPI = " :: flyapi :: ";

    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        if(event.getApplicationContext().getParent() == null)
        {
            //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
            for (String s : BANNER){
                System.out.println(s);
            }
            System.out.println(FLYAPI);

        }
    }

}

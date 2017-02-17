package com.flyhero.flyapi.utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class UuidUtil {

	public static String get32UUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}
	public static long getUniqueId() {
		
		long cur = new Date().getTime();
//		System.out.println("time"+cur);
		int random = new Random().nextInt(1000000);
//		System.out.println("random"+random);
		return Long.valueOf(cur + random);
	}
	 // 2.获取客户端mac地址  
    // 调用window的命令，在后台Bean里实现 通过ip来获取mac地址。方法如下：  
  
    // 运行速度【快】  
    public static String getMAC() {  
        String mac = null;  
        try {  
            Process pro = Runtime.getRuntime().exec("cmd.exe /c ipconfig/all");  
  
            InputStream is = pro.getInputStream();  
            BufferedReader br = new BufferedReader(new InputStreamReader(is));  
            String message = br.readLine();  
  
            int index = -1;  
            while (message != null) {  
                if ((index = message.indexOf("Physical Address")) > 0) {  
                    mac = message.substring(index + 36).trim();  
                    break;  
                }  
                message = br.readLine();  
            }  
            System.out.println(mac);  
            br.close();  
            pro.destroy();  
        } catch (IOException e) {  
            System.out.println("Can't get mac address!");  
            return null;  
        }  
        return mac;  
    }  
  
    // 运行速度【慢】  
    public static String getMAC(String ip) {  
        String str = null;  
        String macAddress = null;  
        try {  
            Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);  
            InputStreamReader ir = new InputStreamReader(p.getInputStream(),"GBK");  
            LineNumberReader input = new LineNumberReader(ir);  
            for (; true;) {  
                str = input.readLine();  
                System.out.println("111111");
                if (str != null) {  
                	System.out.println("22222"+str);
                    if (str.indexOf("MAC Address") > 1) {  
                        macAddress = str.substring(str.indexOf("MAC Address") + 14);
                        System.out.println("333333"+macAddress);
                        break;  
                    }  
                }  
            }  
        } catch (IOException e) {  
            e.printStackTrace(System.out);  
            return null;  
        }  
        return macAddress;  
    }  
	
	public static void main(String[] args) {
		System.out.println(getUniqueId()+"get32UUID"+get32UUID());
//		System.out.println(UUID.randomUUID().toString().trim().replaceAll("-", ""));
		/*for(int i= 0; i < 100; i++){
			System.out.println(getUniqueId());
		}*/
//		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	//	System.out.println(getMAC());
//		System.out.println(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getRemoteHost());
	}
}


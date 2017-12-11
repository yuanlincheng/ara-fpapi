package com.aratek.utils;

import com.aratek.constant.FingerConstant;

import java.io.IOException;
import java.util.Properties;

/**
 *  @Title AfisFingerLibraryUtil
 *  @note 指纹动态库获取工具类
 *  @note Copyright 2017 by Aratek . All rights reserved
 *  @author yanp
 *  @version 0.0.1
 *  @time 2017/9/29 13:51
 *  @modify（）
 *  @time 2017/9/29 13:51
 **/
public class AfisFingerLibraryUtil {
    public static String getLibraryPath(String systemType){
        //获取DLL的绝对路径
//        String filePath = AfisFingerLibraryUtil.class.getResource("").getPath().replaceFirst("/", "").replaceAll("%20", " ").replace("utils","dll") + "win64/yj/Ara_TrustAFIS_CRJ_BW";
        Properties prop = new Properties();
        try {
            prop.load(AfisFingerLibraryUtil.class.getClassLoader().getResourceAsStream("fingerCfg.properties"));
            if (systemType.equals(FingerConstant.Finger_SYSTEM_TYPE_WIN64)){
                return prop.getProperty("WIN64_DLL_NAME","Ara_TrustAFIS_CRJ_YJ");
            }else if(systemType.equals(FingerConstant.Finger_SYSTEM_TYPE_LINUX)){
                return prop.getProperty("LINUX_SO_NAME","Ara_TrustAFIS_CRJ_BW");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

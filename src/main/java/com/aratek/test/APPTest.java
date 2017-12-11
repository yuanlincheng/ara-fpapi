package com.aratek.test;

import com.aratek.constant.FingerConstant;
import com.aratek.exception.FingerDllSoException;
import com.aratek.model.FingerInfo;
import com.aratek.model.ResultInfo;
import com.aratek.service.AfisFingerServiceAPI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Create by IntelliJ IDEA.
 * Author: yanp
 * Date: 2017/9/29
 * Describe:
 * To change this template use File | Settings | File and Code Templates.
 */
public class APPTest implements Runnable{

    public static void main(String[] args) throws IOException {
        //单独功能测试
        //araFingerValidate();

        //多线程测试
        threadsFingerValidate();
    }

    //多线程测试
    private static void threadsFingerValidate(){
        APPTest appTest = new APPTest();
        int count =1000;
        Thread[] threads = new Thread[count];
        for(int i=0;i<count;i++){
            threads[i] = new Thread(appTest);
            threads[i].start();
        }
        /*for (Thread thread:threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }



    //JNA指纹功能函数测试
    private static void araFingerValidate() throws IOException {
        Properties PROPERTIES = new Properties(System.getProperties());
        String systemName = PROPERTIES.getProperty("os.name");
        String filePath = "";
        if (systemName.contains("Windows")){
            //Windows环境测试
            filePath = "E:/img/7.wsq";//文件路径
        }else if(systemName.contains("Linux")){
            //Linux环境测试
            filePath = "/img/7.wsq";
        }
        // 读取图片文件
        File file = new File(filePath);
        InputStream inStream = new FileInputStream(file);
        byte[] imgData = new byte[(int) file.length()];
        inStream.read(imgData);
        FingerInfo fingerInfo = new FingerInfo();
        fingerInfo.setFingerSrcData(imgData);
        fingerInfo.setFingerSrcType(FingerConstant.Finger_Type_WSQ);
        fingerInfo.setFingerDesType(FingerConstant.Finger_Type_BMP);
        try {
            ResultInfo resultInfo = AfisFingerServiceAPI.araFPImgConvert(fingerInfo);
            System.out.println("araFPImgConvert:"+resultInfo.getResultCode());
        } catch (FingerDllSoException e) {
            e.printStackTrace();
        }
        try {
            ResultInfo resultInfo = AfisFingerServiceAPI.araFPGetImgQuality(fingerInfo);
            System.out.println("araFPGetImgQuality:"+resultInfo.getResultCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ResultInfo resultInfo = AfisFingerServiceAPI.araFPGetImgTemplate(fingerInfo);
            System.out.println("araFPGetImgTemplate:"+resultInfo.getResultCode());
        } catch (FingerDllSoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++) {
            try {
                araFingerValidate();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

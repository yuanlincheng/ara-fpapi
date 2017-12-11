package com.aratek.service;

import com.aratek.constant.FingerConstant;
import com.aratek.exception.FingerDllSoException;
import com.aratek.model.FingerInfo;
import com.aratek.model.ResultInfo;
import com.aratek.service.library.finger.AfisFingerLibraryFactory;
import com.sun.jna.ptr.IntByReference;
import org.apache.commons.codec.binary.Base64;

import java.util.Properties;

/**
 *  @Title AfisFingerServiceAPI
 *  @note 指纹动态库功能接口API实现
 *  @note Copyright 2017 by Aratek . All rights reserved
 *  @author yanp
 *  @version 0.0.1
 *  @time 2017/9/29 11:58
 *  @modify（）
 *  @time 2017/9/29 11:58
 **/
public class AfisFingerServiceAPI {
    /**
     * 指纹图像建模功能函数
     * @param fingerInfo：指纹数据结构体
     * @return ResultInfo:返回结果码resultCode与fingerTemplate模板
     * @throws FingerDllSoException
     */
    public static ResultInfo araFPGetImgTemplate(FingerInfo fingerInfo)throws FingerDllSoException {
        //指纹图像源数据
        byte[] pImgData = fingerInfo.getFingerSrcData();
        //指纹图像源数据长度
        int nImgLength = pImgData.length;
        //指纹图像宽度
        int nImgWidth = 0;
        //指纹图像高度
        int nImgHeight = 0;
        //指纹图像源格式
        String pImgType = fingerInfo.getFingerSrcType();
        if (pImgType.equals(FingerConstant.Finger_Type_RAW)){
            nImgWidth = 400;
            nImgHeight = 400;
        }
        //指纹图像DPI,默认DPI为500
        int nImgDPI = 500;
        //指纹精度,默认精度进行建模0
        int nPrecision = 0;
        //指纹特征模板数据
        byte[] pTemplate = new byte[800*800+1078];
        //指纹特征模板数据长度
        IntByReference pnTemplateLength = new IntByReference(800*800+1078);
        //指纹图像质量分数
        IntByReference pnScore = new IntByReference(100);
        int resultCode = AfisFingerLibraryFactory.getAfisCrjLibrary(getSystemType()).AraFPGetImgTemplate(pImgType, pImgData, nImgLength, nImgWidth, nImgHeight, nImgDPI, nPrecision, pTemplate, pnTemplateLength, pnScore);
        byte[] da = Base64.decodeBase64(pTemplate);
        fingerInfo.setFingerTemplate(da);
        String resultContent = "指纹图像建模成功！";
        return  new ResultInfo(resultCode,resultContent,fingerInfo);
    }
    
    /**
     * 指纹图像建模功能函数
     * @param fingerInfo：指纹数据结构体
     * @return ResultInfo:返回结果码resultCode与fingerTemplate模板
     * @throws FingerDllSoException
     */
    public static ResultInfo araFPGetImgTemplateNoHead(FingerInfo fingerInfo)throws FingerDllSoException {
        //指纹图像源数据
        byte[] pImgData = fingerInfo.getFingerSrcData();
        //指纹图像源数据长度
        int nImgLength = pImgData.length;
        //指纹图像宽度
        int nImgWidth = 0;
        //指纹图像高度
        int nImgHeight = 0;
        //指纹图像源格式
        String pImgType = fingerInfo.getFingerSrcType();
        if (pImgType.equals(FingerConstant.Finger_Type_RAW)){
            nImgWidth = 400;
            nImgHeight = 400;
        }
        //指纹图像DPI,默认DPI为500
        int nImgDPI = 500;
        //指纹精度,默认精度进行建模0
        int nPrecision = 0;
        //指纹特征模板数据
        byte[] pTemplate = new byte[800*800+1078];
        //指纹特征模板数据长度
        IntByReference pnTemplateLength = new IntByReference(800*800+1078);
        //指纹图像质量分数
        IntByReference pnScore = new IntByReference(100);
        int resultCode = AfisFingerLibraryFactory.getAfisCrjLibrary(getSystemType()).AraFPGetImgTemplate(pImgType, pImgData, nImgLength, nImgWidth, nImgHeight, nImgDPI, nPrecision, pTemplate, pnTemplateLength, pnScore);
        byte[] da = Base64.decodeBase64(pTemplate);
        if(resultCode == 0){
            //去掉格式头 AUF开头25字节
            if(da[0] == 0x41 && da[1] == 0x55 && da[2] == 0x46){
                byte[] fdata2 = new byte[da.length-25];
                System.arraycopy(da,25,fdata2,0,da.length-25);
                fingerInfo.setFingerTemplate(fdata2);
            }else {
                fingerInfo.setFingerTemplate(da);
            }
        }
        String resultContent = "指纹图像建模成功！";
        return new ResultInfo(resultCode,resultContent,fingerInfo);
    }
    
    
    /**
     *指纹图像格式转换函数
     * @param fingerInfo：指纹数据结构体
     * @return ResultInfo：返回结果码resultCode与fingerDesData模板
     * @throws FingerDllSoException
     */
    public static ResultInfo araFPImgConvert(FingerInfo fingerInfo) throws FingerDllSoException {
        //指纹图像源数据
        byte[] pSrcImgData = fingerInfo.getFingerSrcData();
        //指纹数据源长度
        int nSrcImgLength = pSrcImgData.length;
        //指纹图像宽度
        int nSrcImgWidth = 0;
        //指纹图像高度
        int nSrcImgHeight = 0;
        //指纹图像源格式
        String pSrcImgType = fingerInfo.getFingerSrcType();
        if (pSrcImgType.equals(FingerConstant.Finger_Type_RAW)){
            nSrcImgWidth = 400;
            nSrcImgHeight = 400;
        }
        //指纹图像目标格式
        String pDesImgType = fingerInfo.getFingerDesType();
        if (pSrcImgType.equals(pDesImgType)){
            return new ResultInfo(100,"格式转换，源数据类型与目标数据类型不能相同！");
        }
        //指纹图像DPI,默认DPI为500
        int nSrcImgDPI = 500;
        //指纹图像转换后目标数据
        byte[] pDesImgData = new byte[800*800+1078];
        //指纹图像目标数据
        IntByReference pnDesImgLength = new IntByReference(800*800+1078);
//        System.out.println("pSrcImgType："+pSrcImgType+"===>pSrcImgData:"+pSrcImgData+"===>nSrcImgLength:"+nSrcImgLength+"===>nSrcImgWidth:"+nSrcImgWidth+"===>nSrcImgHeight:"+nSrcImgHeight+"===>nSrcImgDPI:"+ nSrcImgDPI+"===>pDesImgType:"+pDesImgType+"===>pDesImgData:"+pDesImgData+"===>pnDesImgLength:"+pnDesImgLength);
        int resultCode = AfisFingerLibraryFactory.getAfisCrjLibrary(getSystemType()).AraFPImgConvert(pSrcImgType, pSrcImgData, nSrcImgLength, nSrcImgWidth, nSrcImgHeight, nSrcImgDPI, pDesImgType, pDesImgData, pnDesImgLength);
        fingerInfo.setFingerDesData(pDesImgData);
        String resultContent = "指纹图像转换成功！";
        return new ResultInfo(resultCode,resultContent,fingerInfo);
    }
    
    /**
     *指纹图像质量分数获取函数
     * @param fingerInfo：指纹数据结构体
     * @return esultInfo：返回结果码resultCode与fingerQuality指纹质量分数
     * @throws Exception
     */
    public static ResultInfo araFPGetImgQuality(FingerInfo fingerInfo)throws FingerDllSoException{
        //指纹图像源数据
        byte[] pImgData = fingerInfo.getFingerSrcData();
        //指纹图像源长度
        int nImgLength = pImgData.length;
        //指纹图像宽度
        int nImgWidth = 0;
        //指纹图像高度
        int nImgHeight = 0;
        //指纹图像源类型
        String pImgType = fingerInfo.getFingerSrcType();
        if (pImgType.equals(FingerConstant.Finger_Type_RAW)){
            nImgWidth = 400;
            nImgHeight = 400;
        }
        //指纹图像质量分数
        IntByReference pnScore = new IntByReference(100);
//        System.out.println("pImgType："+pImgType+"===>pImgData:"+pImgData+"===>nImgLength:"+nImgLength+"===>nImgWidth:"+nImgWidth+"===>nImgHeight:"+nImgHeight+"===>pnScore:"+ pnScore);
        int resultCode = AfisFingerLibraryFactory.getAfisCrjLibrary(getSystemType()).AraFPGetImgQuality(pImgType, pImgData, nImgLength, nImgWidth, nImgHeight, pnScore);
        fingerInfo.setFingerQuality(pnScore.getValue());
        String resultContent = "指纹图像质量分数获取成功！";
        return new ResultInfo(resultCode,resultContent,fingerInfo);
    }
    
    /**
     * 获取系统类型
     * @return systemType
     */
    private static String getSystemType(){
        Properties PROPERTIES = new Properties(System.getProperties());
        String systemName = PROPERTIES.getProperty("os.name");
        if (systemName.contains("Windows")){
            return FingerConstant.Finger_SYSTEM_TYPE_WIN64;
        }else if(systemName.contains("Linux")){
            return FingerConstant.Finger_SYSTEM_TYPE_LINUX;
        }
        return null;
    }
}
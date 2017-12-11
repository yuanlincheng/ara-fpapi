package com.aratek.service.library.finger;

import com.sun.jna.Library;
import com.sun.jna.ptr.IntByReference;

/**
 *  @Title AfisFingerLibrary
 *  @note 指纹动态链接库父接口
 *  @note Copyright 2017 by Aratek . All rights reserved
 *  @author yanp
 *  @version 0.0.1
 *  @time 2017/9/29 11:52
 *  @modify（）
 *  @time 2017/9/29 11:52
 **/
public interface AfisFingerLibrary extends Library{
    //指纹图片建模
    int AraFPGetImgTemplate(String pImgType, byte[] pImgData, int nImgLength, int nImgWidth, int nImgHeight, int nImgDPI, int nPrecision, byte[] pTemplate, IntByReference pnTemplateLength, IntByReference pnScore );
    //指纹图片类型转换
    int AraFPImgConvert(String pSrcImgType, byte[] pSrcImgData, int nSrcImgLength, int nSrcImgWidth, int nSrcImgHeight, int nSrcImgDPI, String pDesImgType, byte[] pDesImgData, IntByReference pnDesImgLength);
    //指纹图片质量评价
    int AraFPGetImgQuality(String pImgType, byte[] pImgData, int nImgLength, int nImgWidth, int nImgHeight, IntByReference pnScore);
}

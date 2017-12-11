package com.aratek.service.library.finger;

import com.aratek.constant.FingerConstant;
import com.aratek.exception.FingerDllSoException;
import com.aratek.utils.AfisFingerLibraryUtil;
import com.sun.jna.Native;

/**
 *  @Title AfisFingerLibraryFactory
 *  @note 工厂模式调用动态链接库
 *  @note Copyright 2017 by Aratek . All rights reserved
 *  @author yanp
 *  @version 0.0.1
 *  @time 2017/9/29 11:58
 *  @modify（）
 *  @time 2017/9/29 11:58
 **/
public class AfisFingerLibraryFactory {
    public static AfisFingerLibrary getAfisCrjLibrary(String SystemType) throws FingerDllSoException {
        switch (SystemType) {
            case  FingerConstant.Finger_SYSTEM_TYPE_WIN64:
                return getAfisCrjLibraryBySystemType(SystemType);
            case FingerConstant.Finger_SYSTEM_TYPE_LINUX:
                return getAfisCrjLibraryBySystemType(SystemType);
            default:
                throw new FingerDllSoException("没有该种调用方式!");
        }
    }

    /**
     * 根据系统类型返回动态库的接口实例
     * @param systemType
     * @return
     */
    private static AfisFingerLibrary getAfisCrjLibraryBySystemType(String systemType) {
        if (systemType.equals(FingerConstant.Finger_SYSTEM_TYPE_WIN64)){
            return (AfisFingerDll64Library) Native.loadLibrary(AfisFingerLibraryUtil.getLibraryPath(FingerConstant.Finger_SYSTEM_TYPE_WIN64), AfisFingerDll64Library.class);
        }else if(systemType.equals(FingerConstant.Finger_SYSTEM_TYPE_LINUX)){
            return (AfisFingerSoLibrary) Native.loadLibrary(AfisFingerLibraryUtil.getLibraryPath(FingerConstant.Finger_SYSTEM_TYPE_LINUX), AfisFingerSoLibrary.class);
        }else {
            return null;
        }
    }
}

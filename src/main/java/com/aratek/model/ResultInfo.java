package com.aratek.model;

/**
 *  @Title ResultInfo
 *  @note 指纹动态库返回结果类
 *  @note Copyright 2017 by Aratek . All rights reserved
 *  @author yanp
 *  @version 0.0.1
 *  @time 2017/9/28 16:32
 *  @modify（）
 *  @time 2017/9/28 16:32
 **/
public class ResultInfo {
    //结果码
    private Integer resultCode;
    //结果内容
    private String resultContent;
    //指纹对象
    private FingerInfo fingerInfo;

    public ResultInfo() {
    }

    public ResultInfo(Integer resultCode, String resultContent) {
        this.resultCode = resultCode;
        this.resultContent = resultContent;
    }

    public ResultInfo(Integer resultCode, String resultContent, FingerInfo fingerInfo) {
        this.resultCode = resultCode;
        this.resultContent = resultContent;
        this.fingerInfo = fingerInfo;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public FingerInfo getFingerInfo() {
        return fingerInfo;
    }

    public void setFingerInfo(FingerInfo fingerInfo) {
        this.fingerInfo = fingerInfo;
    }

    public String getResultContent() {
        return resultContent;
    }

    public void setResultContent(String resultContent) {
        this.resultContent = resultContent;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "resultCode=" + resultCode +
                ", resultContent='" + resultContent + '\'' +
                ", fingerInfo=" + fingerInfo +
                '}';
    }
}

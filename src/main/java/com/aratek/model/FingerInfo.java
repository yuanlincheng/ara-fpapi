package com.aratek.model;

import java.util.Arrays;
/**
 *  @Title FingerInfo
 *  @note 指纹结构体类
 *  @note Copyright 2017 by Aratek . All rights reserved
 *  @author yanp
 *  @version 0.0.1
 *  @time 2017/9/28 17:37
 *  @modify（）
 *  @time 2017/9/28 17:37
 **/
public class FingerInfo {
    private byte[] fingerSrcData;
    private String fingerName;
    private String fingerSrcType;
    private String fingerDesType;
    private Integer fingerQuality;
    private Integer fingerSrcSize;
    private Integer fingerDesSize;
    private Integer fingerNo;
    private String fingerPosition;
    private byte[] fingerTemplate;
    private byte[] fingerDesData;

    public FingerInfo() {
    }

    public FingerInfo(byte[] fingerSrcData, String fingerName, String fingerSrcType, String fingerDesType, Integer fingerQuality, Integer fingerSrcSize, Integer fingerDesSize, Integer fingerNo, String fingerPosition, byte[] fingerTemplate, byte[] fingerDesData) {
      this.fingerSrcData = fingerSrcData;
      this.fingerName = fingerName;
      this.fingerSrcType = fingerSrcType;
      this.fingerDesType = fingerDesType;
      this.fingerQuality = fingerQuality;
      this.fingerSrcSize = fingerSrcSize;
      this.fingerDesSize = fingerDesSize;
      this.fingerNo = fingerNo;
      this.fingerPosition = fingerPosition;
      this.fingerTemplate = fingerTemplate;
      this.fingerDesData = fingerDesData;
    }

    public byte[] getFingerSrcData() {
      return fingerSrcData;
    }

    public void setFingerSrcData(byte[] fingerSrcData) {
      this.fingerSrcData = fingerSrcData;
    }

    public String getFingerName() {
      return fingerName;
    }

    public void setFingerName(String fingerName) {
      this.fingerName = fingerName;
    }

    public String getFingerSrcType() {
      return fingerSrcType;
    }

    public void setFingerSrcType(String fingerSrcType) {
      this.fingerSrcType = fingerSrcType;
    }

    public String getFingerDesType() {
      return fingerDesType;
    }

    public void setFingerDesType(String fingerDesType) {
      this.fingerDesType = fingerDesType;
    }

    public Integer getFingerQuality() {
      return fingerQuality;
    }

    public void setFingerQuality(Integer fingerQuality) {
      this.fingerQuality = fingerQuality;
    }

    public Integer getFingerSrcSize() {
      return fingerSrcSize;
    }

    public void setFingerSrcSize(Integer fingerSrcSize) {
      this.fingerSrcSize = fingerSrcSize;
    }

    public Integer getFingerDesSize() {
      return fingerDesSize;
    }

    public void setFingerDesSize(Integer fingerDesSize) {
      this.fingerDesSize = fingerDesSize;
    }

    public Integer getFingerNo() {
      return fingerNo;
    }

    public void setFingerNo(Integer fingerNo) {
      this.fingerNo = fingerNo;
    }

    public String getFingerPosition() {
      return fingerPosition;
    }

    public void setFingerPosition(String fingerPosition) {
      this.fingerPosition = fingerPosition;
    }

    public byte[] getFingerTemplate() {
      return fingerTemplate;
    }

    public void setFingerTemplate(byte[] fingerTemplate) {
      this.fingerTemplate = fingerTemplate;
    }

    public byte[] getFingerDesData() {
      return fingerDesData;
    }

    public void setFingerDesData(byte[] fingerDesData) {
      this.fingerDesData = fingerDesData;
    }

    @Override
    public String toString() {
      return "FingerInfo{" +
              "fingerSrcData=" + Arrays.toString(fingerSrcData) +
              ", fingerName='" + fingerName + '\'' +
              ", fingerSrcType='" + fingerSrcType + '\'' +
              ", fingerDesType='" + fingerDesType + '\'' +
              ", fingerQuality=" + fingerQuality +
              ", fingerSrcSize=" + fingerSrcSize +
              ", fingerDesSize=" + fingerDesSize +
              ", fingerNo=" + fingerNo +
              ", fingerPosition='" + fingerPosition + '\'' +
              ", fingerTemplate=" + Arrays.toString(fingerTemplate) +
              ", fingerDesData=" + Arrays.toString(fingerDesData) +
              '}';
    }
}
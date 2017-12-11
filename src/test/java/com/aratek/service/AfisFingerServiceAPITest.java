package com.aratek.service;

import com.aratek.constant.FingerConstant;
import com.aratek.model.FingerInfo;
import com.aratek.model.ResultInfo;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class AfisFingerServiceAPITest {
    @Test
    public void araFPGetImgTemplate() throws Exception {
        FingerInfo fingerInfo = new FingerInfo();
        byte[] data = FileUtils.readFileToByteArray(new File("C:\\Users\\Administrator\\Desktop\\finger.jpg"));
        fingerInfo.setFingerSrcData(data);
        fingerInfo.setFingerSrcType(FingerConstant.Finger_Type_JPG);
        ResultInfo resultInfo = AfisFingerServiceAPI.araFPGetImgTemplate(fingerInfo);
        System.out.println(resultInfo.getResultContent() + resultInfo.getResultCode());
    }
    
    @Test
    public void araFPGetImgTemplateNoHead() throws Exception {
        FingerInfo fingerInfo = new FingerInfo();
        byte[] data = FileUtils.readFileToByteArray(new File("C:\\Users\\Administrator\\Desktop\\NL2.jpg"));
        fingerInfo.setFingerSrcData(data);
        fingerInfo.setFingerSrcType(FingerConstant.Finger_Type_JPG);
        ResultInfo resultInfo = AfisFingerServiceAPI.araFPGetImgTemplate(fingerInfo);
        FileUtils.writeByteArrayToFile(new File("C:\\Users\\Administrator\\Desktop\\feature_with_head.dat"),resultInfo.getFingerInfo().getFingerTemplate());
        resultInfo = AfisFingerServiceAPI.araFPGetImgTemplateNoHead(fingerInfo);
        FileUtils.writeByteArrayToFile(new File("C:\\Users\\Administrator\\Desktop\\feature_without_head.dat"),resultInfo.getFingerInfo().getFingerTemplate());
    }
}
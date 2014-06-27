package com.service;

import com.domain.StepFourChargeStatusVO;
import com.domain.StepTwoNoticeChargeThirdPartVO;

import java.util.List;

/**
 * Created by wula on 2014/6/23.
 */
public interface GetAndUpdateDataFromDBService {
    List<StepTwoNoticeChargeThirdPartVO> getDataForStepTwo();

    List<StepFourChargeStatusVO> getDataForStepFour();

    void updateFlagForStepTwo(String id, String resText);

    void updateFlagForStepFour(String id, String resText);
}

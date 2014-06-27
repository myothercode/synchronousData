package com.service.impl;

import com.domain.StepFourChargeStatusVO;
import com.domain.StepTwoNoticeChargeThirdPartVO;
import com.service.GetAndUpdateDataFromDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wula on 2014/6/23.
 */
@Service("getAndUpdateDataFromDBService")
public class GetAndUpdateDataFromDBServiceImpl implements GetAndUpdateDataFromDBService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**获取第二步需要的数据，一次提取20条 todo 需要完善sql
     * */
    @Override
    public List<StepTwoNoticeChargeThirdPartVO> getDataForStepTwo(){
        String sql="";
        List<StepTwoNoticeChargeThirdPartVO> list=jdbcTemplate.query(sql,new DataMapperD());
        if(list==null || list.isEmpty())return new ArrayList<StepTwoNoticeChargeThirdPartVO>();
        return list;
    }
    /**为jdbctemp组装list*/
    class DataMapperD implements RowMapper {
        public StepTwoNoticeChargeThirdPartVO mapRow(ResultSet rs,int rowNum) throws SQLException {
            StepTwoNoticeChargeThirdPartVO sm=new StepTwoNoticeChargeThirdPartVO();
            //sm.setServiceid(rs.getString("serviceid"));
            return sm;
        }
    }

    /**获取第四步需要的数据，一次提取20条
     * todo 需要完善sql*/
    @Override
    public List<StepFourChargeStatusVO> getDataForStepFour(){
        String sql="";
        List<StepFourChargeStatusVO> list=jdbcTemplate.query(sql,new DataMapperE());
        if(list==null || list.isEmpty())return new ArrayList<StepFourChargeStatusVO>();
        return list;
    }
    /**为jdbctemp组装list*/
    class DataMapperE implements RowMapper {
        public StepFourChargeStatusVO mapRow(ResultSet rs,int rowNum) throws SQLException {
            StepFourChargeStatusVO sm=new StepFourChargeStatusVO();
            //sm.setServiceid(rs.getString("serviceid"));
            return sm;
        }
    }

    /**发送数据后更新状态*/
    @Override
    public void updateFlagForStepTwo(String id,String resText){
        String sql="update sms_send_tb set flag=flag+1,sendTime=getdate() where flag='0' and idnum=?";
        Object[] params = new Object[]{id};
        jdbcTemplate.update(sql,params);
    }
    @Override
    public void updateFlagForStepFour(String id,String resText){
        String sql="";
        Object[] params = new Object[]{id};
        jdbcTemplate.update(sql,params);
    }
}

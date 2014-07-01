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
import java.util.Date;
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
        String sql="select top 20 message_id , createdate, mobile_no,upload_message,serviceid " +
                " from sms_send_tb" +
                " where flag='9' and post_flag='0'" +
                " order by idnum desc";
        List<StepTwoNoticeChargeThirdPartVO> list=jdbcTemplate.query(sql,new DataMapperD());
        if(list==null || list.isEmpty())return new ArrayList<StepTwoNoticeChargeThirdPartVO>();
        return list;
    }
    /**为jdbctemp组装list*/
    class DataMapperD implements RowMapper {
        public StepTwoNoticeChargeThirdPartVO mapRow(ResultSet rs,int rowNum) throws SQLException {
            StepTwoNoticeChargeThirdPartVO sm=new StepTwoNoticeChargeThirdPartVO();
            //sm.setServiceid(rs.getString("serviceid"));
            sm.setMO_MESSAGE_ID(rs.getString("message_id"));
            Date rdate=rs.getDate("createdate");
            sm.setRECEIVE_TIME(rdate.getTime());
            sm.setMSISDN(rs.getString("mobile_no"));
            sm.setMESSAGE(rs.getString("upload_message"));
            sm.setSERVICE_CODE(rs.getString("serviceid"));
            return sm;
        }
    }

    /**获取第四步需要的数据，一次提取20条
     * todo 需要完善sql*/
    @Override
    public List<StepFourChargeStatusVO> getDataForStepFour(){
        String sql="select  top 20  b.stat, a.message_id , a.createdate, a.mobile_no,a.createDate,a.sendTime,a.response_msg" +
                " from sms_send_tb a,sms_log_new b" +
                " where a.mobile_no=b.mobile_no and a.reserve=b.reserve " +
                " and b.reserve is not null and a.message_id is not null" +
                " and a.flag='0' and a.post_flag='1'" +
                " order by a.idnum desc";
        List<StepFourChargeStatusVO> list=jdbcTemplate.query(sql,new DataMapperE());
        if(list==null || list.isEmpty())return new ArrayList<StepFourChargeStatusVO>();
        return list;
    }
    /**为jdbctemp组装list*/
    class DataMapperE implements RowMapper {
        public StepFourChargeStatusVO mapRow(ResultSet rs,int rowNum) throws SQLException {
            StepFourChargeStatusVO sm=new StepFourChargeStatusVO();
            //sm.setServiceid(rs.getString("serviceid"));
            sm.setMSISDN(rs.getString("mobile_no"));
            sm.setMO_MESSAGE_ID(rs.getString("message_id"));
            sm.setBUSINESS_CODE(rs.getString("response_msg") );
            String stat=rs.getString("stat");
            sm.setSTATUS("0".equals(stat)?"DELIVRD":"FAILURE");
            sm.setCONNECT_ID(rs.getString("createdate"));
            sm.setSUBMIT_TIME(rs.getString("createdate"));
            return sm;
        }
    }

    /**发送数据后更新状态*/
    @Override
    public void updateFlagForStepTwo(String id,String resText){
        String sql="update sms_send_tb set flag='0',sendTime=getdate(),post_flag='1' where flag='9' and message_id=?";
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

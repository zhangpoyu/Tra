package come.poyu.dao.impl;

import come.poyu.dao.RequsetInfoDao;
import come.poyu.entity.RequestInfo;
import come.poyu.util.JDBCHelper;

public class RequestInfoimpl implements RequsetInfoDao {
    @Override
    public int add(RequestInfo requestInfo)
    {
        Object result = JDBCHelper.executeScalar("select * from t_requestinfo where unrule_record=?",requestInfo.getUnrule_record());
        if(result == null)
        {
            int res =JDBCHelper.executeUpdate("insert into t_requestinfo values(?,?,?,?,?,?,?,?)",null,requestInfo.getEmail(),requestInfo.getCar_number(), requestInfo.getUnrule_record(),requestInfo.getContent(),0,0,0);
            if(res == 1)
            {
                JDBCHelper.executeUpdate("alter table t_car drop column id");
                JDBCHelper.executeUpdate("alter table t_car add id mediumint(8) not null primary key auto_increment first");
                return 1;
            }else{
                return 0;
            }
        }else {
            return 0;
        }
    }
}

package cn.jf180.finance.dao.fin.dao;

import cn.jf180.finance.dao.fin.model.UserCreditApplyPay;
import cn.jf180.finance.dao.fin.model.UserCreditApplyPayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCreditApplyPayMapper {
    long countByExample(UserCreditApplyPayExample example);

    int deleteByExample(UserCreditApplyPayExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserCreditApplyPay record);

    int insertSelective(UserCreditApplyPay record);

    List<UserCreditApplyPay> selectByExample(UserCreditApplyPayExample example);

    UserCreditApplyPay selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserCreditApplyPay record, @Param("example") UserCreditApplyPayExample example);

    int updateByExample(@Param("record") UserCreditApplyPay record, @Param("example") UserCreditApplyPayExample example);

    int updateByPrimaryKeySelective(UserCreditApplyPay record);

    int updateByPrimaryKey(UserCreditApplyPay record);
}
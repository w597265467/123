package test.generator.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import test.generator.model.UserCreditApplyPay;
import test.generator.model.UserCreditApplyPayExample;

public interface UserCreditApplyPayMapper {
    int countByExample(UserCreditApplyPayExample example);

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
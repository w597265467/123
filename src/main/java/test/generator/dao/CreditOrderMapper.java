package test.generator.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import test.generator.model.CreditOrder;
import test.generator.model.CreditOrderExample;

public interface CreditOrderMapper {
    int countByExample(CreditOrderExample example);

    int deleteByExample(CreditOrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(CreditOrder record);

    int insertSelective(CreditOrder record);

    List<CreditOrder> selectByExample(CreditOrderExample example);

    CreditOrder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") CreditOrder record, @Param("example") CreditOrderExample example);

    int updateByExample(@Param("record") CreditOrder record, @Param("example") CreditOrderExample example);

    int updateByPrimaryKeySelective(CreditOrder record);

    int updateByPrimaryKey(CreditOrder record);
}
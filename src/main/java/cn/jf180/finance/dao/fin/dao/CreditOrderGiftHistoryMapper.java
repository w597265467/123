package cn.jf180.finance.dao.fin.dao;

import cn.jf180.finance.dao.fin.model.CreditOrderGiftHistory;
import cn.jf180.finance.dao.fin.model.CreditOrderGiftHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreditOrderGiftHistoryMapper {
    long countByExample(CreditOrderGiftHistoryExample example);

    int deleteByExample(CreditOrderGiftHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CreditOrderGiftHistory record);

    int insertSelective(CreditOrderGiftHistory record);

    List<CreditOrderGiftHistory> selectByExample(CreditOrderGiftHistoryExample example);

    CreditOrderGiftHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CreditOrderGiftHistory record, @Param("example") CreditOrderGiftHistoryExample example);

    int updateByExample(@Param("record") CreditOrderGiftHistory record, @Param("example") CreditOrderGiftHistoryExample example);

    int updateByPrimaryKeySelective(CreditOrderGiftHistory record);

    int updateByPrimaryKey(CreditOrderGiftHistory record);
}
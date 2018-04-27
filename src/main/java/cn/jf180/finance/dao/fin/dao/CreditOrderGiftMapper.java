package cn.jf180.finance.dao.fin.dao;

import cn.jf180.finance.dao.fin.model.CreditOrderGift;
import cn.jf180.finance.dao.fin.model.CreditOrderGiftExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreditOrderGiftMapper {
    long countByExample(CreditOrderGiftExample example);

    int deleteByExample(CreditOrderGiftExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CreditOrderGift record);

    int insertSelective(CreditOrderGift record);

    List<CreditOrderGift> selectByExample(CreditOrderGiftExample example);

    CreditOrderGift selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CreditOrderGift record, @Param("example") CreditOrderGiftExample example);

    int updateByExample(@Param("record") CreditOrderGift record, @Param("example") CreditOrderGiftExample example);

    int updateByPrimaryKeySelective(CreditOrderGift record);

    int updateByPrimaryKey(CreditOrderGift record);
}
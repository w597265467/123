package cn.jf180.finance.dao.fin.dao;

import cn.jf180.finance.dao.fin.model.BjcyGiftCharge;
import cn.jf180.finance.dao.fin.model.BjcyGiftChargeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BjcyGiftChargeMapper {
    long countByExample(BjcyGiftChargeExample example);

    int deleteByExample(BjcyGiftChargeExample example);

    int deleteByPrimaryKey(String chargeSn);

    int insert(BjcyGiftCharge record);

    int insertSelective(BjcyGiftCharge record);

    List<BjcyGiftCharge> selectByExample(BjcyGiftChargeExample example);

    BjcyGiftCharge selectByPrimaryKey(String chargeSn);

    int updateByExampleSelective(@Param("record") BjcyGiftCharge record, @Param("example") BjcyGiftChargeExample example);

    int updateByExample(@Param("record") BjcyGiftCharge record, @Param("example") BjcyGiftChargeExample example);

    int updateByPrimaryKeySelective(BjcyGiftCharge record);

    int updateByPrimaryKey(BjcyGiftCharge record);
}
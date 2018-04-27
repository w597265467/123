package cn.jf180.finance.dao.fin.dao;

import cn.jf180.finance.dao.fin.model.OrderGiftConfig;
import cn.jf180.finance.dao.fin.model.OrderGiftConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderGiftConfigMapper {
    long countByExample(OrderGiftConfigExample example);

    int deleteByExample(OrderGiftConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderGiftConfig record);

    int insertSelective(OrderGiftConfig record);

    List<OrderGiftConfig> selectByExample(OrderGiftConfigExample example);

    OrderGiftConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderGiftConfig record, @Param("example") OrderGiftConfigExample example);

    int updateByExample(@Param("record") OrderGiftConfig record, @Param("example") OrderGiftConfigExample example);

    int updateByPrimaryKeySelective(OrderGiftConfig record);

    int updateByPrimaryKey(OrderGiftConfig record);
}
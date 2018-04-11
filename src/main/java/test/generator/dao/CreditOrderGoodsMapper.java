package test.generator.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import test.generator.model.CreditOrderGoods;
import test.generator.model.CreditOrderGoodsExample;

public interface CreditOrderGoodsMapper {
    int countByExample(CreditOrderGoodsExample example);

    int deleteByExample(CreditOrderGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CreditOrderGoods record);

    int insertSelective(CreditOrderGoods record);

    List<CreditOrderGoods> selectByExample(CreditOrderGoodsExample example);

    CreditOrderGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CreditOrderGoods record, @Param("example") CreditOrderGoodsExample example);

    int updateByExample(@Param("record") CreditOrderGoods record, @Param("example") CreditOrderGoodsExample example);

    int updateByPrimaryKeySelective(CreditOrderGoods record);

    int updateByPrimaryKey(CreditOrderGoods record);
}
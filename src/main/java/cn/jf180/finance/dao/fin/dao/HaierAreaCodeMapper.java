package cn.jf180.finance.dao.fin.dao;

import cn.jf180.finance.dao.fin.model.HaierAreaCode;
import cn.jf180.finance.dao.fin.model.HaierAreaCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaierAreaCodeMapper {
    int countByExample(HaierAreaCodeExample example);

    int deleteByExample(HaierAreaCodeExample example);

    int insert(HaierAreaCode record);

    int insertSelective(HaierAreaCode record);

    List<HaierAreaCode> selectByExample(HaierAreaCodeExample example);

    int updateByExampleSelective(@Param("record") HaierAreaCode record, @Param("example") HaierAreaCodeExample example);

    int updateByExample(@Param("record") HaierAreaCode record, @Param("example") HaierAreaCodeExample example);
}
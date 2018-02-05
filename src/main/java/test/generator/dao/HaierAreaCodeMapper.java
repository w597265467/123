package test.generator.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import test.generator.model.HaierAreaCode;
import test.generator.model.HaierAreaCodeExample;

public interface HaierAreaCodeMapper {
    int countByExample(HaierAreaCodeExample example);

    int deleteByExample(HaierAreaCodeExample example);

    int insert(HaierAreaCode record);

    int insertSelective(HaierAreaCode record);

    List<HaierAreaCode> selectByExample(HaierAreaCodeExample example);

    int updateByExampleSelective(@Param("record") HaierAreaCode record, @Param("example") HaierAreaCodeExample example);

    int updateByExample(@Param("record") HaierAreaCode record, @Param("example") HaierAreaCodeExample example);
}
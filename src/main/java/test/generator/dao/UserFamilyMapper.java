package test.generator.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import test.generator.model.UserFamily;
import test.generator.model.UserFamilyExample;

public interface UserFamilyMapper {
    int countByExample(UserFamilyExample example);

    int deleteByExample(UserFamilyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserFamily record);

    int insertSelective(UserFamily record);

    List<UserFamily> selectByExample(UserFamilyExample example);

    UserFamily selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserFamily record, @Param("example") UserFamilyExample example);

    int updateByExample(@Param("record") UserFamily record, @Param("example") UserFamilyExample example);

    int updateByPrimaryKeySelective(UserFamily record);

    int updateByPrimaryKey(UserFamily record);
}
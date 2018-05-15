package cn.jf180.finance.dao.fin.dao;

import cn.jf180.finance.dao.fin.model.OpPackage;
import cn.jf180.finance.dao.fin.model.OpPackageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpPackageMapper {
    long countByExample(OpPackageExample example);

    int deleteByExample(OpPackageExample example);

    int deleteByPrimaryKey(String id);

    int insert(OpPackage record);

    int insertSelective(OpPackage record);

    List<OpPackage> selectByExample(OpPackageExample example);

    OpPackage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OpPackage record, @Param("example") OpPackageExample example);

    int updateByExample(@Param("record") OpPackage record, @Param("example") OpPackageExample example);

    int updateByPrimaryKeySelective(OpPackage record);

    int updateByPrimaryKey(OpPackage record);
}
package test.generator.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import test.generator.model.CmEmpowerRecord;
import test.generator.model.CmEmpowerRecordExample;

public interface CmEmpowerRecordMapper {
    int countByExample(CmEmpowerRecordExample example);

    int deleteByExample(CmEmpowerRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmEmpowerRecord record);

    int insertSelective(CmEmpowerRecord record);

    List<CmEmpowerRecord> selectByExample(CmEmpowerRecordExample example);

    CmEmpowerRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmEmpowerRecord record, @Param("example") CmEmpowerRecordExample example);

    int updateByExample(@Param("record") CmEmpowerRecord record, @Param("example") CmEmpowerRecordExample example);

    int updateByPrimaryKeySelective(CmEmpowerRecord record);

    int updateByPrimaryKey(CmEmpowerRecord record);
}
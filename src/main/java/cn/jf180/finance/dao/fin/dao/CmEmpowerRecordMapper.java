package cn.jf180.finance.dao.fin.dao;

import cn.jf180.finance.dao.fin.model.CmEmpowerRecord;
import cn.jf180.finance.dao.fin.model.CmEmpowerRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmEmpowerRecordMapper {
    long countByExample(CmEmpowerRecordExample example);

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
package cn.jf180.finance.dao.fin.dao;

import cn.jf180.finance.dao.fin.model.BjcyOrderGiftRecord;
import cn.jf180.finance.dao.fin.model.BjcyOrderGiftRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BjcyOrderGiftRecordMapper {
    long countByExample(BjcyOrderGiftRecordExample example);

    int deleteByExample(BjcyOrderGiftRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BjcyOrderGiftRecord record);

    int insertSelective(BjcyOrderGiftRecord record);

    List<BjcyOrderGiftRecord> selectByExample(BjcyOrderGiftRecordExample example);

    BjcyOrderGiftRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BjcyOrderGiftRecord record, @Param("example") BjcyOrderGiftRecordExample example);

    int updateByExample(@Param("record") BjcyOrderGiftRecord record, @Param("example") BjcyOrderGiftRecordExample example);

    int updateByPrimaryKeySelective(BjcyOrderGiftRecord record);

    int updateByPrimaryKey(BjcyOrderGiftRecord record);
}
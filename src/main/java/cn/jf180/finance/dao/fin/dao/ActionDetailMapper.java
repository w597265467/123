package cn.jf180.finance.dao.fin.dao;

import cn.jf180.finance.dao.fin.model.ActionDetail;
import cn.jf180.finance.dao.fin.model.ActionDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActionDetailMapper {
    long countByExample(ActionDetailExample example);

    int deleteByExample(ActionDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActionDetail record);

    int insertSelective(ActionDetail record);

    List<ActionDetail> selectByExample(ActionDetailExample example);

    ActionDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActionDetail record, @Param("example") ActionDetailExample example);

    int updateByExample(@Param("record") ActionDetail record, @Param("example") ActionDetailExample example);

    int updateByPrimaryKeySelective(ActionDetail record);

    int updateByPrimaryKey(ActionDetail record);
}
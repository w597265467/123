package cn.jf180.finance.dao.fin.dao;

import cn.jf180.finance.dao.fin.model.BjcyShareAwardRule;
import cn.jf180.finance.dao.fin.model.BjcyShareAwardRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BjcyShareAwardRuleMapper {
    long countByExample(BjcyShareAwardRuleExample example);

    int deleteByExample(BjcyShareAwardRuleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BjcyShareAwardRule record);

    int insertSelective(BjcyShareAwardRule record);

    List<BjcyShareAwardRule> selectByExample(BjcyShareAwardRuleExample example);

    BjcyShareAwardRule selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BjcyShareAwardRule record, @Param("example") BjcyShareAwardRuleExample example);

    int updateByExample(@Param("record") BjcyShareAwardRule record, @Param("example") BjcyShareAwardRuleExample example);

    int updateByPrimaryKeySelective(BjcyShareAwardRule record);

    int updateByPrimaryKey(BjcyShareAwardRule record);
}
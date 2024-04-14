package indi.gong.xu.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import indi.gong.xu.model.vo.AnswerVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface AnswerMapper {
    @Select("select question, subject, score, section,level, \"选择题\" as type from sys_multi_question " +
            "union select  question, subject, score, section,level, \"判断题\" as type  from sys_judge_question " +
            "union select  question, subject, score, section,level, \"填空题\" as type from sys_fill_question")
    IPage<AnswerVO> findAll(Page page);
}

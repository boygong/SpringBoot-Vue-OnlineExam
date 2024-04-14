package indi.gong.xu.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import indi.gong.xu.model.entity.FillQuestion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//填空题
@Mapper
public interface FillQuestionMapper {

    @Select("select * from sys_fill_question where questionId in (select questionId from sys_paper_manage where questionType = 2 and paperId = #{paperId})")
    List<FillQuestion> findByIdAndType(Integer paperId);

    @Select("select * from sys_fill_question")
    IPage<FillQuestion> findAll(Page page);

    /**
     * 查询最后一条questionId
     * @return FillQuestion
     */
    @Select("select questionId from sys_fill_question order by questionId desc limit 1")
    FillQuestion findOnlyQuestionId();

    @Options(useGeneratedKeys = true,keyProperty ="questionId" )
    @Insert("insert into sys_fill_question(subject,question,answer,analysis,level,section) values " +
            "(#{subject,},#{question},#{answer},#{analysis},#{level},#{section})")
    int add(FillQuestion fillQuestion);

    @Select("select questionId from sys_fill_question where subject = #{subject} order by rand() desc limit #{pageNo}")
    List<Integer> findBySubject(String subject,Integer pageNo);
}

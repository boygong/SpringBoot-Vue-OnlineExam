package indi.gong.xu.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import indi.gong.xu.model.entity.ExamManage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ExamManageMapper {
    @Select("select * from sys_exam_manage")
    List<ExamManage> findAll();

    @Select("select * from sys_exam_manage")
    IPage<ExamManage> findAll(Page page);

    @Select("select * from sys_exam_manage where examCode = #{examCode}")
    ExamManage findById(Integer examCode);

    @Delete("delete from sys_exam_manage where examCode = #{examCode}")
    int delete(Integer examCode);

    @Update("update sys_exam_manage set description = #{description},source = #{source},paperId = #{paperId}," +
            "examDate = #{examDate},totalTime = #{totalTime},grade = #{grade},term = #{term}," +
            "major = #{major},institute = #{institute},totalScore = #{totalScore}," +
            "type = #{type},tips = #{tips} where examCode = #{examCode}")
    int update(ExamManage exammanage);

    @Options(useGeneratedKeys = true,keyProperty = "examCode")
    @Insert("insert into sys_exam_manage(description,source,paperId,examDate,totalTime,grade,term,major,institute,totalScore,type,tips)" +
            " values(#{description},#{source},#{paperId},#{examDate},#{totalTime},#{grade},#{term},#{major},#{institute},#{totalScore},#{type},#{tips})")
    int add(ExamManage exammanage);

    /**
     * 查询最后一条记录的paperId,返回给前端达到自增效果
     * @return paperId
     */
    @Select("select paperId from sys_exam_manage order by paperId desc limit 1")
    ExamManage findOnlyPaperId();
}

package indi.gong.xu.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import indi.gong.xu.model.entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper {

    @Select("select * from sys_teacher")
    IPage<Teacher>  findAll(Page page);

    @Select("select * from sys_teacher")
    public List<Teacher> findAll();

    @Select("select * from sys_teacher where teacherId = #{teacherId}")
    public Teacher findById(Integer teacherId);

    @Delete("delete from sys_teacher where teacherId = #{teacherId}")
    public int deleteById(Integer teacherId);

    @Update("update sys_teacher set teacherName = #{teacherName},sex = #{sex}," +
            "tel = #{tel}, email = #{email},pwd = #{pwd},cardId = #{cardId}," +
            "role = #{role},institute = #{institute},type = #{type} where teacherId = #{teacherId}")
    public int update(Teacher teacher);

    @Options(useGeneratedKeys = true,keyProperty = "teacherId")
    @Insert("insert into sys_teacher(teacherName,sex,tel,email,pwd,cardId,role,type,institute) " +
            "values(#{teacherName},#{sex},#{tel},#{email},#{pwd},#{cardId},#{role},#{type},#{institute})")
    public int add(Teacher teacher);
}

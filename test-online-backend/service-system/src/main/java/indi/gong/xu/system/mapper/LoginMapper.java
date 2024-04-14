package indi.gong.xu.system.mapper;

import indi.gong.xu.model.entity.Admin;
import indi.gong.xu.model.entity.Student;
import indi.gong.xu.model.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    @Select("select adminId,adminName,sex,tel,email,cardId,role from sys_admin where adminId = #{username} and pwd = #{password}")
    public Admin adminLogin(Integer username, String password);

    @Select("select teacherId,teacherName,institute,sex,tel,email,cardId," +
            "type,role from sys_teacher where teacherId = #{username} and pwd = #{password}")
    public Teacher teacherLogin(Integer username, String password);

    @Select("select studentId,studentName,grade,major,clazz,institute,tel," +
            "email,cardId,sex,role from sys_student where studentId = #{username} and pwd = #{password}")
    public Student studentLogin(Integer username,String password);
}

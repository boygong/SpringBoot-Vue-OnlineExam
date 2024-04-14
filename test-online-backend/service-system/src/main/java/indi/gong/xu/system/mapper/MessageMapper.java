package indi.gong.xu.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import indi.gong.xu.model.entity.Message;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MessageMapper {
    @Select("select id,id as temp_id,title,content,time from sys_message order by id desc")
    @Results({
            @Result(property = "replays", column = "temp_id",many = @Many(select = "com.exam.mapper.ReplayMapper.findAllById"))
    })
    IPage<Message> findAll(Page page);

    @Select("select id,title,content,time from sys_message where id = #{id}")
    @Results({
            @Result(property = "replays", column = "id",many = @Many(select = "com.exam.mapper.ReplayMapper.findAllById"))
    })
    Message findById(Integer id);

    @Delete("delete from sys_message where id = #{id}")
    int delete(Integer id);

    @Update("update sys_message set title = #{title}, content = #{content}, time = #{time} where " +
            "id = #{id}")
    int update(Message message);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into sys_message(title, content, time) values(#{title},#{content},#{time})")
    int add(Message message);
}

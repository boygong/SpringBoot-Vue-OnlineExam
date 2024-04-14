package indi.gong.xu.system.mapper;

import indi.gong.xu.model.entity.Replay;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReplayMapper {

    @Select("select messageId,replayId,replay,replayTime from sys_replay")
    List<Replay> findAll();

    @Select("select messageId,replayId,replay,replayTime from sys_replay where messageId = #{messageId}")
    List<Replay> findAllById(Integer messageId);

    @Select("select messageId,replayId,replay,replayTime from sys_replay where messageId = #{messageId}")
    Replay findById(Integer messageId);

    @Delete("delete from sys_replay where replayId = #{replayId}")
    int delete(Integer replayId);

    @Update("update sys_replay set  replay = #{replay}, replayTime = #{replayTime} where replayId = #{replayId}")
    int update(Replay replay);

    @Options(useGeneratedKeys = true,keyProperty = "replayId")
    @Insert("insert into sys_replay(messageId,replay,replayTime) values(#{messageId}, #{replay},#{replayTime})")
    int add(Replay replay);
}

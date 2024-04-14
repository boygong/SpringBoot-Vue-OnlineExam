package indi.gong.xu.system.controller;


import indi.gong.xu.common.util.ApiResultHandler;
import indi.gong.xu.model.entity.ApiResult;
import indi.gong.xu.model.entity.Replay;
import indi.gong.xu.system.serviceimpl.ReplayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReplayController {

    @Autowired
    private ReplayServiceImpl replayService;

    @PostMapping("/replay")
    public ApiResult add(@RequestBody Replay replay) {
        int data = replayService.add(replay);
        if (data != 0) {
            return ApiResultHandler.buildApiResult(200,"添加成功！",data);
        } else {
            return ApiResultHandler.buildApiResult(400,"添加失败！",null);
        }
    }

    @GetMapping("/replay/{messageId}")
    public ApiResult findAllById(@PathVariable("messageId") Integer messageId) {
        List<Replay> res = replayService.findAllById(messageId);
        return ApiResultHandler.buildApiResult(200,"根据messageId查询",res);
    }
}

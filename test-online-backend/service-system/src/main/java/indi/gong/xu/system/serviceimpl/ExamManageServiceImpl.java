package indi.gong.xu.system.serviceimpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import indi.gong.xu.model.entity.ExamManage;
import indi.gong.xu.system.mapper.ExamManageMapper;
import indi.gong.xu.system.service.ExamManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamManageServiceImpl implements ExamManageService {
    @Autowired
    private ExamManageMapper examManageMapper;


    @Override
    public List<ExamManage> findAll() {
        return examManageMapper.findAll();
    }

    @Override
    public IPage<ExamManage> findAll(Page<ExamManage> page) {
        return examManageMapper.findAll(page);
    }

    @Override
    public ExamManage findById(Integer examCode) {
        return examManageMapper.findById(examCode);
    }

    @Override
    public int delete(Integer examCode) {
        return examManageMapper.delete(examCode);
    }

    @Override
    public int update(ExamManage exammanage) {
        return examManageMapper.update(exammanage);
    }

    @Override
    public int add(ExamManage exammanage) {
        return examManageMapper.add(exammanage);
    }

    @Override
    public ExamManage findOnlyPaperId() {
        return examManageMapper.findOnlyPaperId();
    }
}

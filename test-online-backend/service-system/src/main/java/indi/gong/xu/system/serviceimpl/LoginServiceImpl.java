package indi.gong.xu.system.serviceimpl;

import indi.gong.xu.model.entity.Admin;
import indi.gong.xu.model.entity.Student;
import indi.gong.xu.model.entity.Teacher;
import indi.gong.xu.system.mapper.LoginMapper;
import indi.gong.xu.system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Admin adminLogin(Integer username, String password) {
        return loginMapper.adminLogin(username,password);
    }

    @Override
    public Teacher teacherLogin(Integer username, String password) {
        return loginMapper.teacherLogin(username,password);
    }

    @Override
    public Student studentLogin(Integer username, String password) {
        return loginMapper.studentLogin(username,password);
    }
}

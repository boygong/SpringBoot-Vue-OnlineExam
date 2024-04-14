package indi.gong.xu.system.service;


import indi.gong.xu.model.entity.Admin;
import indi.gong.xu.model.entity.Student;
import indi.gong.xu.model.entity.Teacher;

public interface LoginService {

    public Admin adminLogin(Integer username, String password);

    public Teacher teacherLogin(Integer username, String password);

    public Student studentLogin(Integer username, String password);
}

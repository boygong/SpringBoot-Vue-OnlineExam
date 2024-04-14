package indi.gong.xu.system.service;



import indi.gong.xu.model.entity.Admin;

import java.util.List;

public interface AdminService{

    public List<Admin> findAll();

    public Admin findById(Integer adminId);

    public int deleteById(int adminId);

    public int update(Admin admin);

    public int add(Admin admin);
}

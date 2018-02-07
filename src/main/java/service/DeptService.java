package service;

import entity.Dept;

import java.util.List;

public interface DeptService {

    int adddept(Dept dept);
    List<Dept> querydept(Dept dept);
}

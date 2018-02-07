package dao;

import entity.Dept;

import java.util.List;

public interface DeptMapper {
    int adddept(Dept dept);
    List<Dept> querydept(Dept dept);
}

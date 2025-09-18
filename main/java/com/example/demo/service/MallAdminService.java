package com.example.demo.service;

import com.example.demo.entity.MallAdmin;

import java.util.List;

public interface MallAdminService {
    MallAdmin createMallAdmin(MallAdmin mallAdmin);
    MallAdmin getMallAdminById(Long id);
    List<MallAdmin> getAllMallAdmins();
    MallAdmin updateMallAdmin(Long id, MallAdmin mallAdmin);
    void deleteMallAdmin(Long id);
}

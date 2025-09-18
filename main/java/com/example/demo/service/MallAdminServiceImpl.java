package com.example.demo.service;

import com.example.demo.entity.MallAdmin;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.MallAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MallAdminServiceImpl implements MallAdminService {

    private final MallAdminRepository mallAdminRepository;

    @Autowired
    public MallAdminServiceImpl(MallAdminRepository mallAdminRepository) {
        this.mallAdminRepository = mallAdminRepository;
    }

    @Override
    public MallAdmin createMallAdmin(MallAdmin mallAdmin) {
        // Optionally: validate duplicates, etc.
        return mallAdminRepository.save(mallAdmin);
    }

    @Override
    public MallAdmin getMallAdminById(Long id) {
        return mallAdminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MallAdmin not found with id " + id));
    }

    @Override
    public List<MallAdmin> getAllMallAdmins() {
        return mallAdminRepository.findAll();
    }

    @Override
    public MallAdmin updateMallAdmin(Long id, MallAdmin mallAdmin) {
        MallAdmin existing = mallAdminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MallAdmin not found with id " + id));
        // update fields
        if (mallAdmin.getName() != null) {
            existing.setName(mallAdmin.getName());
        }
        if (mallAdmin.getEmail() != null) {
            existing.setEmail(mallAdmin.getEmail());
        }
        if (mallAdmin.getPhone() != null) {
            existing.setPhone(mallAdmin.getPhone());
        }
        // any other fields...
        return mallAdminRepository.save(existing);
    }

    @Override
    public void deleteMallAdmin(Long id) {
        MallAdmin existing = mallAdminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MallAdmin not found with id " + id));
        mallAdminRepository.delete(existing);
    }
}

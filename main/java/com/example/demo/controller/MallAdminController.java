package com.example.demo.controller;

import com.example.demo.entity.MallAdmin;
import com.example.demo.service.MallAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mall-admins")
public class MallAdminController {

    private final MallAdminService mallAdminService;

    @Autowired
    public MallAdminController(MallAdminService mallAdminService) {
        this.mallAdminService = mallAdminService;
    }

    @PostMapping
    public ResponseEntity<MallAdmin> createMallAdmin(@RequestBody MallAdmin mallAdmin) {
        MallAdmin created = mallAdminService.createMallAdmin(mallAdmin);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MallAdmin> getMallAdminById(@PathVariable Long id) {
        MallAdmin admin = mallAdminService.getMallAdminById(id);
        return ResponseEntity.ok(admin);
    }

    @GetMapping
    public ResponseEntity<List<MallAdmin>> getAllMallAdmins() {
        return ResponseEntity.ok(mallAdminService.getAllMallAdmins());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MallAdmin> updateMallAdmin(@PathVariable Long id, @RequestBody MallAdmin mallAdmin) {
        MallAdmin updated = mallAdminService.updateMallAdmin(id, mallAdmin);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMallAdmin(@PathVariable Long id) {
        mallAdminService.deleteMallAdmin(id);
        return ResponseEntity.noContent().build();
    }
}

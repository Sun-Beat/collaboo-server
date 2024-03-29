package com.example.collaboo.controller;

import com.example.collaboo.dto.RoleDTO;
import com.example.collaboo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/projects")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/{projectId}/roles")
    public ResponseEntity<String> addRole(@PathVariable Long projectId, @RequestBody RoleDTO roleDTO) {
        try {
            roleService.addRole(projectId, roleDTO);
            return ResponseEntity.ok("역할이 성공적으로 추가되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("역할 추가 중 오류가 발생했습니다.");
        }
    }

    @GetMapping("/{projectId}/roles")
    public ResponseEntity<List<RoleDTO>> getAllRolesByProjectId(@PathVariable Long projectId) {
        List<RoleDTO> roles = roleService.getAllRolesByProjectId(projectId);
        return ResponseEntity.ok(roles);
    }
    @PutMapping("/{projectId}/roles/{roleId}")
    public ResponseEntity<String> updateRole(
            @PathVariable Long projectId,
            @PathVariable Long roleId,
            @RequestBody RoleDTO roleDTO) {
        try {
            roleService.updateRole(projectId, roleId, roleDTO);
            return ResponseEntity.ok("역할이 성공적으로 수정되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("역할 수정 중 오류가 발생했습니다.");
        }
    }
    @DeleteMapping("/{projectId}/roles/{roleId}")
    public ResponseEntity<String> deleteRole(
            @PathVariable Long projectId,
            @PathVariable Long roleId) {
        try {
            roleService.deleteRole(projectId, roleId);
            return ResponseEntity.ok("역할이 성공적으로 삭제되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("역할 삭제 중 오류가 발생했습니다.");
        }
    }
}
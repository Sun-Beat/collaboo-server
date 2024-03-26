// TaskController.java
package com.example.collaboo.controller;

import com.example.collaboo.dto.TaskDTO;
import com.example.collaboo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/projects")
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/{projectId}/tasks")
    public ResponseEntity<String> createTask(@PathVariable Long projectId, @RequestBody TaskDTO taskDTO) {
        try {
            taskService.createTask(projectId, taskDTO);
            return ResponseEntity.ok("투두 리스트가 성공적으로 추가되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("투두 리스트 추가 중 오류가 발생했습니다.");
        }
    }
}

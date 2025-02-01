package com.user.evaluation.controllers;

import com.user.evaluation.core.EvaluationService;
import com.user.evaluation.dto.UserEvaluationModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/evaluations")
public class EvaluationController {

    private final EvaluationService evaluationService;

    @GetMapping
    public List<UserEvaluationModel> getAll() {
        return evaluationService.getAll();
    }

    @PostMapping
    public UserEvaluationModel save(@RequestBody UserEvaluationModel model) {
        return evaluationService.save(model);
    }

    @GetMapping("/{id}")
    public UserEvaluationModel save(@PathVariable Long id) {
        return evaluationService.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        evaluationService.delete(id);
    }

}

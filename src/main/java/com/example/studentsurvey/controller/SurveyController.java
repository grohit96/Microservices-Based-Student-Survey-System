package com.example.studentsurvey.controller;

import com.example.studentsurvey.model.Survey;
import com.example.studentsurvey.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/surveys/change")
public class SurveyController {

    @Autowired
    private SurveyRepository repository;

    @PostMapping
    public Survey createSurvey(@RequestBody Survey survey) {
        return repository.save(survey);
    }

    @GetMapping
    public List<Survey> getAllSurveys() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Survey> getSurveyById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    public Survey updateSurvey(@PathVariable Long id, @RequestBody Survey survey) {
        survey.setId(id);
        return repository.save(survey);
    }

    @DeleteMapping("/{id}")
    public void deleteSurvey(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
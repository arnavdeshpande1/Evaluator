package com.example.evaluator.Repository;

import com.example.evaluator.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Integer> {
}

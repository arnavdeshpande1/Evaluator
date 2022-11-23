package com.example.evaluator.Repository;

import com.example.evaluator.Model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Integer> {

//    List<Exam> findByTitleContainingOrContentContaining(String text, String textAgain);
}

package com.example.evaluator.Repository;

import com.example.evaluator.Model.Exam;
import com.example.evaluator.Model.ExamGuideline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Integer> {

//    List<Exam> findByTitleContainingOrContentContaining(String text, String textAgain);

//    boolean findByTestid(int testid);
    List<Exam> findByExamGuideline(ExamGuideline examGuideline);


}

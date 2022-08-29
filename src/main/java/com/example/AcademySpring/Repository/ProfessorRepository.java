package com.example.AcademySpring.Repository;

import com.example.AcademySpring.Model.ProfessorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorModel, Long> {
   public List<ProfessorModel> modalidade (String modalidade);
}

package com.example.AcademySpring.Repository;

import com.example.AcademySpring.Model.TreinoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreinoRepository extends JpaRepository<TreinoModel, Long> {

    List<TreinoModel> level (String level);

}

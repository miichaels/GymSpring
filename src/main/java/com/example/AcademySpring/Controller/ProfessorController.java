package com.example.AcademySpring.Controller;

import com.example.AcademySpring.Model.ProfessorModel;
import com.example.AcademySpring.Repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
@CrossOrigin
public class ProfessorController {

    @Autowired
    public ProfessorRepository repository;

    @GetMapping
    public ResponseEntity<List<ProfessorModel>> GetAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorModel> GetById (@PathVariable Long id){
        return repository.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

   @GetMapping("/modalidade/{modalidade}")
    public ResponseEntity<List<ProfessorModel>> getModalidade (@PathVariable String modalidade){
        return ResponseEntity.ok(repository.modalidade(modalidade));
    }


    @PostMapping
    public ResponseEntity<ProfessorModel> postProf (@RequestBody @Valid ProfessorModel professorModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(professorModel));
    }

    @PutMapping
    public ResponseEntity<ProfessorModel> putProf (@RequestBody @Valid ProfessorModel professorModel){
        return ResponseEntity.ok(repository.save(professorModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        return repository.findById(id).map(resposta -> {repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();})
                .orElse(ResponseEntity.notFound().build());
    }


}

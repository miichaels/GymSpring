package com.example.AcademySpring.Controller;

import com.example.AcademySpring.Model.AlunoModel;
import com.example.AcademySpring.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/aluno")
@CrossOrigin
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @GetMapping
    public ResponseEntity<List<AlunoModel>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<AlunoModel> saveGym(@RequestBody @Valid AlunoModel alunoModel){
         return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(alunoModel));
    }

    @PutMapping
    public ResponseEntity<AlunoModel> putGym (@RequestBody @Valid AlunoModel alunoModel){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(alunoModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delGym (@PathVariable Long id){
        return repository.findById(id).map(resposta -> {repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();})
                .orElse(ResponseEntity.noContent().build());
    }



}

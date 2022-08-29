package com.example.AcademySpring.Controller;

import com.example.AcademySpring.Model.AlunoModel;
import com.example.AcademySpring.Model.TreinoModel;
import com.example.AcademySpring.Repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/treino")
@CrossOrigin
public class TreinoController {

    @Autowired
    private TreinoRepository repository;


    public TreinoController(TreinoRepository repositorio) {
        this.repository = repositorio;
    }

   @GetMapping
    public ResponseEntity<List<TreinoModel>> getAll () {
       return ResponseEntity.ok(repository.findAll());
   }

   @GetMapping("/{id}")
   public ResponseEntity<TreinoModel> GetById (@PathVariable Long id){
        return repository.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
   }

    @GetMapping("/treino/{level}")
    public ResponseEntity<List<TreinoModel>> level (@PathVariable String level){
        return ResponseEntity.ok(repository.level(level));
    }

   @PostMapping
    public ResponseEntity<TreinoModel> post (@Valid @RequestBody TreinoModel treino){
       return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(treino));
   }

    @PutMapping
    public ResponseEntity<TreinoModel> put (@RequestBody @Valid TreinoModel treinoModel){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(treinoModel));
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        return repository.findById(id).map(resposta -> {repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();})
                .orElse(ResponseEntity.notFound().build());
    }


}

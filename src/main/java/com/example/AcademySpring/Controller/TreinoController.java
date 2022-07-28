package com.example.AcademySpring.Controller;

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
/*@CrossOrigin*/
public class TreinoController {

    @Autowired
    private TreinoRepository repositorio;

    public TreinoController(TreinoRepository repositorio) {
        this.repositorio = repositorio;
    }


    @PostMapping
    public ResponseEntity<TreinoModel> post (@Valid @RequestBody TreinoModel treino){
       return ResponseEntity.status(HttpStatus.CREATED).body(repositorio.save(treino));
   }

   @GetMapping()
    public ResponseEntity<List<TreinoModel>> getAll () {
       return ResponseEntity.ok(repositorio.findAll());
   }

/*   @GetMapping("/treino/{modalidade}")
    public ResponseEntity<List<TreinoModel>> getModalidade (@PathVariable String modalidade){
       return ResponseEntity.ok(repositorio.findAllModalidade(modalidade));
   }*/

}

package com.Dio.live.controller;

import com.Dio.live.Sevice.JornadaService;
import com.Dio.live.model.JornadaTrabalho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaService jornadaService;

    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
      return jornadaService.SaveJornada(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> getJornadaList(){
        return  jornadaService.FindAll();
    }

    @GetMapping("{idJornada}")
    public ResponseEntity<JornadaTrabalho> getJornadaById(@PathVariable("idJornada") Long idJornada) throws Exception {
        return ResponseEntity.ok(jornadaService.GetById(idJornada).orElseThrow(()->new NoSuchElementException("Jornada não encontrada")));
    }

    @PutMapping
    public JornadaTrabalho UpdateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.UpdateJornada(jornadaTrabalho);
    }

    @DeleteMapping("/{idJornada}")
    public void deleteJornadaById(@PathVariable("idJornada") Long idJornada) throws Exception {
        try{
            jornadaService.DeleteById(idJornada);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


}

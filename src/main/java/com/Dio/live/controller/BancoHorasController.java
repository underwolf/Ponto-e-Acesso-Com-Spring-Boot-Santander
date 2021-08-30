package com.Dio.live.controller;

import com.Dio.live.Sevice.BancoHorasService;
import com.Dio.live.Sevice.JornadaService;
import com.Dio.live.model.BancoHoras;
import com.Dio.live.model.JornadaTrabalho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/bancoHoras")
public class BancoHorasController {
    @Autowired
    BancoHorasService bancoHorasService;

    @PostMapping
    public BancoHoras createBancoHoras(@RequestBody BancoHoras bancoHoras){
        return bancoHorasService.SaveJornada(bancoHoras);
    }

    @GetMapping
    public List<BancoHoras> getBancoHorasList(){
        return  bancoHorasService.FindAll();
    }

    @GetMapping("/{idBancoHoras}-{idMovimento}-{idUsuario}")
    public ResponseEntity<BancoHoras> getBancoHorasById(@PathVariable("idBancoHoras") long idBancoHoras,
                                                        @PathVariable("idMovimento") long idMovimento,
                                                        @PathVariable("idUsuario") long idUsuario) throws Exception {

        BancoHoras.BancoHorasId id= new BancoHoras().new BancoHorasId(idBancoHoras,idMovimento,idUsuario);
        return ResponseEntity.ok(bancoHorasService.GetById(id).orElseThrow(()->new NoSuchElementException("Jornada não encontrada")));
    }

    @PutMapping
    public BancoHoras UpdateBancoHoras(@RequestBody BancoHoras bancoHoras){
        return bancoHorasService.UpdateJornada(bancoHoras);
    }

    @DeleteMapping("/{idBancoHoras}-{idMovimento}-{idUsuario}")
    public void deleteJornadaById(@PathVariable("idBancoHoras") long idBancoHoras,
                                  @PathVariable("idMovimento") long idMovimento,
                                  @PathVariable("idUsuario") long idUsuario) throws Exception {
        BancoHoras.BancoHorasId id= new BancoHoras().new BancoHorasId(idBancoHoras,idMovimento,idUsuario);
        try{
            bancoHorasService.DeleteById(id);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}

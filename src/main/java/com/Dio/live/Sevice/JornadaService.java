package com.Dio.live.Sevice;

import com.Dio.live.Repository.JornadaRepository;
import com.Dio.live.model.JornadaTrabalho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JornadaService {
    JornadaRepository jornadaRepository;

    @Autowired
    public JornadaService(JornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }

    public JornadaTrabalho SaveJornada(JornadaTrabalho jornadaTrabalho){
        return jornadaRepository.save(jornadaTrabalho);
    }

    public JornadaTrabalho UpdateJornada(JornadaTrabalho jornadaTrabalho){
        return jornadaRepository.save(jornadaTrabalho);
    }

    public List<JornadaTrabalho> FindAll() {
        return jornadaRepository.findAll();
    }

    public Optional<JornadaTrabalho> GetById(Long id) {
        return jornadaRepository.findById(id);
    }

    public void DeleteById(Long id) {
        jornadaRepository.deleteById(id);
    }
}

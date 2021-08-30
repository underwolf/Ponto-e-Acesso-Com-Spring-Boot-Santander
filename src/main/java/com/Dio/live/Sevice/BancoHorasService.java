package com.Dio.live.Sevice;

import com.Dio.live.Repository.BancoHorasRepository;
import com.Dio.live.model.BancoHoras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoHorasService {
    BancoHorasRepository bancoHorasRepository;

    @Autowired
    public BancoHorasService(BancoHorasRepository bancoHorasRepository) {
        this.bancoHorasRepository = bancoHorasRepository;
    }

    public BancoHoras SaveJornada(BancoHoras bancoHoras){
        return  bancoHorasRepository.save(bancoHoras);
    }

    public BancoHoras UpdateJornada(BancoHoras bancoHoras){
        return bancoHorasRepository.save(bancoHoras);
    }

    public List<BancoHoras> FindAll() {
        return bancoHorasRepository.findAll();
    }

    public Optional<BancoHoras> GetById(BancoHoras.BancoHorasId id) {
        return bancoHorasRepository.findById(id);
    }

    public void DeleteById(BancoHoras.BancoHorasId id) {
        bancoHorasRepository.deleteById(id);
    }
}

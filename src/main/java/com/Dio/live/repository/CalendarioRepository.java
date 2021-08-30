package com.Dio.live.Repository;

import com.Dio.live.model.Calendario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarioRepository  extends JpaRepository<Calendario, Long>{
}

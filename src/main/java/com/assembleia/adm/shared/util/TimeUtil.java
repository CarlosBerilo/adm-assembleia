package com.assembleia.adm.shared.util;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TimeUtil {
    public static LocalDate dataSessaoVotacao(){
        return LocalDate.now();
    }

    public static LocalDateTime dataHoraSessaoVotacao(){
        return LocalDateTime.now();
    }

    public static LocalDateTime previsaoTerminoSessaoVotacao(Integer tempoDeSessao, LocalDateTime dataHoraInicio){
        return dataHoraInicio.plusMinutes(tempoDeSessao);
    }
}

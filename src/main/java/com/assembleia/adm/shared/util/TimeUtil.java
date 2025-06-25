package com.assembleia.adm.shared.util;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TimeUtil {
    public static LocalDate horaSessaoVotacao(){
        return LocalDate.now();
    }

    public static Timestamp previsaoTerminoSessaoVotacao(Integer tempoDeSessao, LocalDateTime dataHoraInicio, String horaInicio){
        //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(simpleDateFormat.format(dataHoraInicio), formater);
        LocalDateTime localDateTimePrevisto = localDateTime.plusMinutes(tempoDeSessao);
        return Timestamp.valueOf(localDateTimePrevisto);
    }
}

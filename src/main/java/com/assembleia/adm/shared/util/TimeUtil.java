package com.assembleia.adm.shared.util;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TimeUtil {
    public static Timestamp horaSessaoVotacao(){
        return new Timestamp(System.currentTimeMillis());
    }

    public static Timestamp previsaoTerminoSessaoVotacao(Integer tempoDeSessao){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(simpleDateFormat.format(timestamp), formater);
        LocalDateTime localDateTimePrevisto = localDateTime.plusMinutes(tempoDeSessao);
        return Timestamp.valueOf(localDateTimePrevisto);
    }
}

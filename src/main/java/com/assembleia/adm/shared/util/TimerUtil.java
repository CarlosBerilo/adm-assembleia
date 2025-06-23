package com.assembleia.adm.shared.util;

import org.springframework.stereotype.Component;

import java.util.TimerTask;

@Component
public class TimerUtil extends TimerTask {
    @Override
    public void run() {
        System.out.println("TESTE TimerUtil ----- FinalizarSessaoVotacao -----------------");
    }
}

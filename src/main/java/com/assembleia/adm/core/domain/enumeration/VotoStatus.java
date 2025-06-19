package com.assembleia.adm.core.domain.enumeration;

public enum VotoStatus {
    SIM("SIM"), NAO("NAO");

    private String resultado;

    VotoStatus(String resultado) {
        this.resultado = resultado;

    }
}

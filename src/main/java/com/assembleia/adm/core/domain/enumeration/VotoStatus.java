package com.assembleia.adm.core.domain.enumeration;

public enum VotoStatus {

    SIM("SIM"), NAO("NAO");

    private String votoSelecionado;

    private VotoStatus(String votoSelecionado) {
        this.votoSelecionado = votoSelecionado;
    }

    public String getVotoSelecionado(){
        return votoSelecionado;
    }
}

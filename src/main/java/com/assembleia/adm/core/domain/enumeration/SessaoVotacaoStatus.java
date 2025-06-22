package com.assembleia.adm.core.domain.enumeration;

public enum SessaoVotacaoStatus {

    ABERTA("ABERTA"), FECHADA("FECHADA");

    private String status;

    private SessaoVotacaoStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}

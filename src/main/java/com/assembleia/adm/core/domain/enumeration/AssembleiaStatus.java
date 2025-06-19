package com.assembleia.adm.core.domain.enumeration;

public enum AssembleiaStatus {
    MARCADA("MARCADA"), INICIADA("INICIADA"), FINALIZADA("FINALIZADA");

    private String status;

    private AssembleiaStatus(String status) {
        this.status = status;
    }

}

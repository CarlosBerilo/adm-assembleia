package com.assembleia.adm.shared.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
public class ErrorResponseDTO {

    private int statusCode;
    private String message;
    public ErrorResponseDTO(String message){
        super();
        this.message = message;
    }
}

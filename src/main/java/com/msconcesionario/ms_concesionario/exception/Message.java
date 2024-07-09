package com.msconcesionario.ms_concesionario.exception;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private Meta meta;
    private int status;
    private String title;
    private List<?> errors;
}

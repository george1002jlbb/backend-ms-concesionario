package com.msconcesionario.ms_concesionario.exception;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Meta {
    private String _messageId;
    private String _requestDateTime;
    private String _applicationId;
    private String _service;
}

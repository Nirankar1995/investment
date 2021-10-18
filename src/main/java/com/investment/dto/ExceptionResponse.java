package com.investment.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ExceptionResponse {
    private String errorMessage;
    private String requestedURI;
}

package com.space.spacetourist.ui.model.response;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorMessage {

    private Date timestamp;
    private String message;

}

package com.space.spacetourist.responses;

/**
 * Created by damiass on Dec, 2019
 */
public class SuccessResponse extends AppResponse {

    public SuccessResponse(String successMessage) {
        super(true);
        addFullMessage(successMessage);
    }


}

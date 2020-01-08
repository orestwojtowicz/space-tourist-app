package com.space.spacetourist.ui.model.response.operation_status;


public enum ErrorMessages {

    MISSING_REQUIRED_FIELD("Missing required field."),
    RECORD_ALREADY_EXISTS("Record already exists"),
    INTERNAL_SERVER_ERROR("Internal server error"),
    NO_RECORD_FOUND("No record found"),
    ERROR_WHILE_UPDATING_RECORD("Error while updating record"),
    ERROR_WHILE_DELETING_RECORD("Error while deleting record");

    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @return the error message
     *
     *  * */

    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage error message to set, lombok support only class @Setter annotation
     * */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

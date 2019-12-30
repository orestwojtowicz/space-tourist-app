package com.space.spacetourist.responses;

/** https://github.com/melardev/JavaSpringBootRxApiCrudRxMongoCrudPagination/blob/master/src/main/java/com/melardev/spring/mongo/dtos/responses/ErrorResponse.java
 * Created by damiass on Dec, 2019
 */
public class ErrorResponse extends AppResponse{


    public ErrorResponse(String errorMessage) {
        super(false);
        addFullMessage(errorMessage);
    }


}

package co.com.poli.taller.tallerapp.helpers;

import static org.springframework.http.HttpStatus.*;

public class ResponseBuild {

    public Response succes(){
        return Response.builder()
                .code(OK.value())
                .data(OK.value())
                .build();
    }

    public Response succes(Object data){
        return Response.builder()
                .code(OK.value())
                .data(data)
                .build();
    }

    public Response failed(Object data){
        return Response.builder()
                .code(INTERNAL_SERVER_ERROR.ordinal())
                .data(data)
                .build();
    }
}

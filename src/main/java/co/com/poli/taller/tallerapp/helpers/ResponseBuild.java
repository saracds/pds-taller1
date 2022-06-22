package co.com.poli.taller.tallerapp.helpers;

import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.*;

@Component
public class ResponseBuild {

    public Response success(){
        return Response.builder()
                .code(OK.value())
                .data(OK.value())
                .build();
    }

    public Response success(Object data){
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

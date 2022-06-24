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

    public Response created(){
        return Response.builder()
                .code(CREATED.value())
                .data(CREATED.value())
                .build();
    }

    public Response created(Object data){
        return Response.builder()
                .code(CREATED.value())
                .data(data)
                .build();
    }

    public Response failed(Object data){
        return Response.builder()
                .code(BAD_REQUEST.ordinal())
                .data(data)
                .build();
    }

    public Response notFound(Object data){
        return Response.builder()
                .code(NOT_FOUND.ordinal())
                .data(data)
                .build();
    }
}

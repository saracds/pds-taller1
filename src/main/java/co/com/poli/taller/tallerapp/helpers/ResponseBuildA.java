package co.com.poli.taller.tallerapp.helpers;

import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.*;

@Component
public class ResponseBuildA {

    public ResponseA success(){
        return ResponseA.builder()
                .code(OK.value())
                .data(OK.value())
                .build();
    }

    public ResponseA success(Object data){
        return ResponseA.builder()
                .code(OK.value())
                .data(data)
                .build();
    }

    public ResponseA created(){
        return ResponseA.builder()
                .code(CREATED.value())
                .data(CREATED.value())
                .build();
    }

    public ResponseA created(Object data){
        return ResponseA.builder()
                .code(CREATED.value())
                .data(data)
                .build();
    }

    public ResponseA failed(Object data){
        return ResponseA.builder()
                .code(BAD_REQUEST.ordinal())
                .data(data)
                .build();
    }

    public ResponseA notFound(Object data){
        return ResponseA.builder()
                .code(NOT_FOUND.ordinal())
                .data(data)
                .build();
    }
}

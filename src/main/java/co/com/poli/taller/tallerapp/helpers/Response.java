package co.com.poli.taller.tallerapp.helpers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private Integer code;
    private Object data;

}

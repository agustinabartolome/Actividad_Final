package exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResourceNotFoundException extends IllegalArgumentException {

    private String resourceName;

    private String fieldName;

    private  Long value;

    public ResourceNotFoundException(String message){
        super(message);
    }

    public ResourceNotFoundException(){

    }

}


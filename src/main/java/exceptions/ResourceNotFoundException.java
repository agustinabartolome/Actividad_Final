package exceptions;

public class ResourceNotFoundException extends Throwable {

    private String resourceName;

    private String fieldName;

    private  Long value;

    public ResourceNotFoundException(String message){
        super(message);
    }

    public ResourceNotFoundException(){

    }

}


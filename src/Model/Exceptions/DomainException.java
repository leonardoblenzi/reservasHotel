//exceção personalizada
package Model.Exceptions;

public class DomainException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public DomainException(String msg){
        super(msg);
    }

}

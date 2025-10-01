package MS_Inventarios.Inventarios.exception;

public class Excepciones {
    public static class itemNotFound extends RuntimeException{
        public  itemNotFound(int id){
            super("item not found "+id);
        }

    }
    public static class DataBaseException extends RuntimeException{
        public  DataBaseException(String msg){
            super(msg);
        }
    }
    public static class AuthException extends RuntimeException {
        public AuthException(String mensaje) {
            super(mensaje);
        }
    }
}

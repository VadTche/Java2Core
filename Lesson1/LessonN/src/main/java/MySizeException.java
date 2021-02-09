public class MySizeException extends RuntimeException{
    public MySizeException(String message) {
        super("Некорректные данные: "+message);
    }
}

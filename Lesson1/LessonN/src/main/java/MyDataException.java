public class MyDataException extends RuntimeException {
    public MyDataException(String message) {
        super("Некорректные данные: "+message);
    }
}

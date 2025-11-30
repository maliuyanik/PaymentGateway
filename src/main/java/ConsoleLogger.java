import java.time.LocalDateTime;

public class ConsoleLogger implements ILogger{
    @Override
    public void log(String message) {
        System.out.println("[LOG]" + LocalDateTime.now() + message);
    }
}

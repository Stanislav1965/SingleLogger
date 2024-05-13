import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Logger {
    protected int num = 1;
    protected final String DATE_PATTERN = "dd.mm.yyyy hh:mm:ss";

    public void log(String msg) {
        DateFormat df = new SimpleDateFormat(DATE_PATTERN);
        Date today = Calendar.getInstance().getTime();

        System.out.println("[" +
                df.format(today) +
                " " +
                num++ + "] " +
                msg);
    }

    private static Logger logger;

    // Запрещаем пользователям пользоваться
    // конструктором нашего класса
    private Logger() {
    }

    // Пользователи которым нужен объект
    // нашего класса получают всегда один
    // и тот же объект, который мы храним
    // в приватном статичном поле, которое
    // мы заполняем в этом методе если оно
    // до того не было заполнено
    public static Logger getInstance() {
        if (logger == null) {
            Logger.logger = new Logger();
        }
        return logger;
    }
}

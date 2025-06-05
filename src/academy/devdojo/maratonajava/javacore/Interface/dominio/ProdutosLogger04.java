package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.awt.desktop.OpenFilesHandler;
import java.io.DataInput;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.*;

public class ProdutosLogger04 {

    private static final String LOG_DIR = "logs";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    public static Logger getLogger(Class<?> clazz){
        Logger logger = Logger.getLogger(clazz.getName());
        logger.setUseParentHandlers(false);

        if (logger.getHandlers().length == 0){
            configurarLogger(logger,clazz.getSimpleName());
        }
        return logger;
    }

    public static void configurarLogger(Logger logger, String className){
        try {
            Files.createDirectories(Paths.get(LOG_DIR));
            String dataAtual = DATE_FORMAT.format(new Date());
            String logFileName = String.format("log_%s_%s.log",className,dataAtual);
            Path logFilePath = Paths.get(LOG_DIR, logFileName);
            for (Handler handler : logger.getHandlers()) {
                logger.removeHandler(handler);
            }
            FileHandler fileHandler = new FileHandler(logFilePath.toString(),true);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.ALL);

            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);

        }catch (IOException e){
            System.err.println("Erro na configuração do logger "+className+" :"+e.getMessage());
        }
    }

}
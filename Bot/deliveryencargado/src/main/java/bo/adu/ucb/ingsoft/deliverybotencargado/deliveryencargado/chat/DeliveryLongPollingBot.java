package bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeliveryLongPollingBot extends TelegramLongPollingBot{
    /**
     * Atributo que sirve para guardar el proceso actual de los diferentes usuarios.
     */
    private Logger logger = LoggerFactory.getLogger(DeliveryLongPollingBot.class);
    private Map<Long, AbstractProcess> usersSession;
    private boolean test = false;
    private List<BotApiMethod> testMessages = new ArrayList<>();
    private ApplicationContext context;

    public DeliveryLongPollingBot(ApplicationContext context) {
        this.context = context;
        usersSession = new HashMap<>();
    }

    public DeliveryLongPollingBot(ApplicationContext context,boolean test) {
        this.test = test;
        this.context = context;
        usersSession = new HashMap<>();
    }

    @Override
    public String getBotUsername() {
        return "DelyDaTes_bot";
    }

    @Override
    public String getBotToken() {
        return "5111105977:AAFaCQxCDtmJZ_q6Y87CR4AvgdUN1UQOnKE";
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    public void sendMyMessage(BotApiMethod method) throws TelegramApiException {
        logger.info("Enviando mensaje: {} " , method);

        if (test) {
            // no enviamos
            testMessages.add(method);
        } else {
            this.execute(method);
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        // Primero identifico al usuario por chat Id Long
        Long chatId = update.getMessage().getChatId();
        logger.info("\n\n===========> Recibiendo chatId: {}" , chatId);
        // Busco si ya existe Proceso en el map userSession
        AbstractProcess currentProcess = usersSession.get(chatId);

        if (currentProcess == null) { // Primera vez que se contacto con nostros.
            logger.info("Creando proceso para el  chatId: {}" ,  chatId);

            // Debo crear el proceso por defecto
            currentProcess = context.getBean(MenuProcessImpl.class);
            usersSession.put(chatId, currentProcess);
            logger.info("Derivando la conversación al proceso: {}" , currentProcess.getName());

            AbstractProcess nextProcess = currentProcess.handle(context,update, this);

            if (!nextProcess.equals(currentProcess)) { // Si el siguiente proceso es diferente lo iniciamos
                logger.info("Iniciando siguiente proceso: {}" , nextProcess.getName());
                nextProcess.handle(context,update, this);
            } else {
                logger.info("No hay cambio de proceso, así que termina conversación");

            }
            usersSession.put(chatId, nextProcess);

        } else { // Ya existe un proceso
            logger.info("Continuamos el proceso para el  chatId: {}" +
                     " proceso: {}" ,chatId, currentProcess.getName());
            AbstractProcess nextProcess = currentProcess.handle(context,update, this);

            if (!nextProcess.equals(currentProcess)) { // Si el siguiente proceso es diferente
                logger.info("Iniciando siguiente proceso: {}", nextProcess.getName());

                nextProcess = nextProcess.handle(context,update, this);
            } else {
                logger.info("No hay cambio de proceso, así que termina conversación");
            }
            usersSession.put(chatId, nextProcess);
        }

    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    public List<BotApiMethod> getTestMessages() {
        return testMessages;
    }


}

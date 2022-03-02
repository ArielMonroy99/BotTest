package bo.edu.ucb.ingsoft.foodgonow.foodgonowTest.util.BotUtil

import javax.management.Notification

class NotificationBot(
    private val botBl: BotBl,
    private val variables: Variables
    ): TelegramLongPollingBot(){

    companion object{
        private val LOGGER = LoggerFactory.getLogger(NotificationBot::class.java)
    }
    override fun getBotToken(): String{
        return variables.telegramToken
    }
    override fun getBotUsername(): String{
        return variables.telegramUsername
    }
    override fun getBotReceived(): String{
        LOGGER.info("Recibir mensaje:{}",p0)
    }
}
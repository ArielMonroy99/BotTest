package bo.edu.ucb.ingsoft.foodgonow.foodgonowTest.util.BotUtil

import bo.edu.ucb.ingsoft.foodgonow.foodgonowTest.bl.BotBl
import bo.edu.ucb.ingsoft.foodgonow.foodgonowTest.util.Variables
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.lang.Exception
import javax.management.Notification

@Component
class Botinitialization
@Autowired constructor(
    private val botBl: BotBl,
    private val variables: Variables
){
    companion object{
        private val LOGGER: Logger = LoggerFactory.getLogger(Botinitialization::class.java)
    }
    @PostConstructor
    fun initBot(){
        LOGGER.info("BOT UTIL: Iniciando bot")
        try {
            val telegramBotsApi = TelegramBotsApi(DefaultBotSession::class.java)
            telegramBotsApi.registerBot(NotificationBot(botBl,variables))
        }catch (ex: Exception){
            LOGGER.error("BOT UTIL ERROR: Error al iniciar el bot,{}",ex)
        }
    }
}
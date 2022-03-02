package bo.edu.ucb.ingsoft.foodgonow.foodgonowTest.util

import org.springframework.stereotype.Component

class Variables{
    @value("\${bot.telegram.username}")
    lateinit var telegramUsername: String
    @Value("\${bot.telegram.token}")
    lateinit var telegramToken: String
}
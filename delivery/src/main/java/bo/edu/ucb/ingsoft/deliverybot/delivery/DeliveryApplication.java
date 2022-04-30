package bo.edu.ucb.ingsoft.deliverybot.delivery;

import bo.edu.ucb.ingsoft.deliverybot.delivery.chat.DeliveryLongPollingBot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("bo.edu.ucb.ingsoft.deliverybot.delivery.dao")
public class DeliveryApplication {

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
		return factoryBean.getObject();
	}
	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(DeliveryApplication.class, args);
		try {
			// Inicializamos libreria de bots
			TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
			// Registramos la implementación de nuestro BOT
			telegramBotsApi.registerBot(new DeliveryLongPollingBot(context));
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

}

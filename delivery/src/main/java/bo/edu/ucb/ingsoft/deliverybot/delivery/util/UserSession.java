package bo.edu.ucb.ingsoft.deliverybot.delivery.util;

import java.util.HashMap;
import java.util.Map;

public class UserSession {
    private final static Map<Long,Map<String,Object>> SESSION = new HashMap<>();

    public static Object get(Long chatId, String key) {
        if (SESSION.get(chatId) == null) { // NO hay session
            SESSION.put(chatId, new HashMap<>());
        }
        return SESSION.get(chatId).get(key);
    }

    public static void put(Long chatId, String key, Object value) {
        if (SESSION.get(chatId) == null) { // NO hay session
            SESSION.put(chatId, new HashMap<>());
        }
        SESSION.get(chatId).put(key,value);
    }

    // Para guardar una variable:
    // Date ahora = new Date();
    // UserSession.put(chatId,  "mi_fecha",  ahora);

    // En otra clases:
    //  Date laFeacha = (Date)  UserSession.get(chatId,"mi_fecha");
    // if (laFecha != null)

    // Para eliminar la variable
    // UserSession.put(chatId,  "mi_fecha",  null);
}

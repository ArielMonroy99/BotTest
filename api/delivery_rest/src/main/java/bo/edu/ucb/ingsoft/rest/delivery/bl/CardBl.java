package bo.edu.ucb.ingsoft.rest.delivery.bl;

import bo.edu.ucb.ingsoft.rest.delivery.dao.CardDao;
import bo.edu.ucb.ingsoft.rest.delivery.dao.SequenceDao;
import bo.edu.ucb.ingsoft.rest.delivery.dto.api.CardApiDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.CardDbDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CardBl {
    private CardDao cardDao;
    private SequenceDao sequenceDao;
    public static final Logger LOGGER = LoggerFactory.getLogger(CardBl.class);
    public CardBl(CardDao cardDao, SequenceDao sequenceDao) {
        this.cardDao = cardDao;
        this.sequenceDao = sequenceDao;
    }

    CardApiDto getCardById(Integer cardId){
        LOGGER.info("tarjetaID:{}",cardId);
        CardDbDto card = cardDao.getCardById(cardId);
        LOGGER.info("tarjeta: {}",card.toString() );
        CardApiDto newCard = new CardApiDto();
        newCard.setId(card.getTarjetaId());
        newCard.setNombre(card.getNombre());
        newCard.setNro(card.getNro());
        newCard.setVencimiento(card.getVencimiento());
        return newCard;
    }

}

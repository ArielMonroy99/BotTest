package bo.edu.ucb.ingsoft.rest.delivery.bl;

import bo.edu.ucb.ingsoft.rest.delivery.dao.CardDao;
import bo.edu.ucb.ingsoft.rest.delivery.dao.SequenceDao;
import bo.edu.ucb.ingsoft.rest.delivery.dto.api.CardApiDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.CardDbDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Transactional(propagation = Propagation.REQUIRED)
    public CardApiDto saveCard(CardApiDto card,Integer clientId){
        CardDbDto newCard = new CardDbDto();
        newCard.setTarjetaId(sequenceDao.getSequence(CardDbDto.SEQUENCE));
        card.setId(newCard.getTarjetaId());
        newCard.setNombre(card.getNombre());
        newCard.setNro(card.getNro());
        newCard.setVencimiento(card.getVencimiento());
        newCard.setClientId(clientId);
        newCard.setStatus(1);
        newCard.setTxDate(new Date());
        newCard.setTxHost("localhost");
        newCard.setTxId(1);
        cardDao.createNewCard(newCard);
        return card;
    }
    public List<CardApiDto> getCardsByClient(Integer clientId){
        List<CardApiDto> newList = new ArrayList<>();
        List<CardDbDto>  list = cardDao.getCardsByClient(clientId);
        for(CardDbDto card : list ){
            CardApiDto newCard = new CardApiDto();
            newCard.setId(card.getTarjetaId());
            newCard.setNombre(card.getNombre());
            newCard.setNro(card.getNro());
            newCard.setVencimiento(card.getVencimiento());
            newList.add(newCard);
        }
        return newList;
    }


}

package VampireMadeByAlastor31415926.helpers;

import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;

import static VampireMadeByAlastor31415926.characters.MyCharacter.PlayerColorEnum.COLOR_BLOOD;
import basemod.abstracts.CustomCard;

public abstract class MyCard extends CustomCard {
    public MyCard(String SIMPLE_NAME,CardStrings CARD_STRINGS,int COST,CardRarity RARITY,CardType TYPE,CardTarget TARGET){  
        super(STRING.makeID(SIMPLE_NAME)
                , CARD_STRINGS.NAME, STRING.makeIMG_PATH(SIMPLE_NAME)
                , COST, CARD_STRINGS.DESCRIPTION, TYPE, COLOR_BLOOD, RARITY, TARGET);
    }

    public MyCard(String SIMPLE_NAME, CardStrings CARD_STRINGS, int COST, CardRarity RARITY, CardType TYPE) {
        this(SIMPLE_NAME, CARD_STRINGS, COST, RARITY, TYPE, getDefaultTarget(TYPE));
    }

    protected static String getID(Class<?> clazz) {
        return STRING.makeID(clazz.getSimpleName());
    }

    protected static CardStrings getCardString(Class<?> clazz) {
        return CardCrawlGame.languagePack.getCardStrings(clazz.getSimpleName());
    }
    
    private static CardTarget getDefaultTarget(CardType TYPE) {
        switch (TYPE) {
            case ATTACK:
                return CardTarget.ENEMY;
            case SKILL:
                return CardTarget.SELF;
            case POWER:
                return CardTarget.SELF;
            case CURSE:
                return CardTarget.NONE;
            default:
                return CardTarget.NONE;
        }
    }
}

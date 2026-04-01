package VampireMadeByAlastor31415926.cards;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import VampireMadeByAlastor31415926.helpers.MyCard;
import VampireMadeByAlastor31415926.modcore.core;

public class ThickBlood extends MyCard {

    static private final CardStrings CARD_STRINGS = getCardString(ThickBlood.class);
    static public final String ID = getID(ThickBlood.class);

    public ThickBlood() {
        super(ThickBlood.class.getSimpleName(), CARD_STRINGS, -2, CardRarity.COMMON, CardType.SKILL);
        this.tags.add(core.CardTagsEnum.BLOOD_FEAST);
        this.retain = true;
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.rawDescription = CARD_STRINGS.UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
    }

    @Override
    public void triggerOnExhaust() {
        if (this.upgraded) {
            this.addToBot(new DrawCardAction(1));
        }
    }

    @Override
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        this.cantUseMessage = CARD_STRINGS.EXTENDED_DESCRIPTION[0];
        return false;
    }
}

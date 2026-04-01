package VampireMadeByAlastor31415926.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;

import VampireMadeByAlastor31415926.helpers.MyCard;
import VampireMadeByAlastor31415926.powers.DelayedVulnerable;

public class Indiscretion extends MyCard {

    private static final int VULNERABLENUMBER = 1;
    private static final int DRAWCARDSNUMBER = 3;
    private static final CardStrings CARD_STRINGS = getCardString(Indiscretion.class);
    public static final String ID = getID(Indiscretion.class);

    public Indiscretion() {
        super(Indiscretion.class.getSimpleName(), CARD_STRINGS, 0, CardRarity.UNCOMMON, CardType.SKILL);
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
        this.addToBot(new DrawCardAction(DRAWCARDSNUMBER));
        if (!this.upgraded) {
            this.addToBot(new ApplyPowerAction(p, p, new VulnerablePower(p, VULNERABLENUMBER, false)));
        } else {
            this.addToBot(new ApplyPowerAction(p, p, new DelayedVulnerable(p, VULNERABLENUMBER)));
        }
    }
}

package VampireMadeByAlastor31415926.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;

import static VampireMadeByAlastor31415926.characters.MyCharacter.PlayerColorEnum.COLOR_BLOOD;
import VampireMadeByAlastor31415926.helpers.STRING;
import VampireMadeByAlastor31415926.powers.DelayedVulnerable;
import basemod.abstracts.CustomCard;

public class Indiscretion extends CustomCard{
    private static final int VULNERABLENUMBER = 1;
    private static final int DRAWCARDSNUMBER = 3;
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(Indiscretion.class.getSimpleName());
    public static final String ID=STRING.makeID(Indiscretion.class.getSimpleName());
    private static final String NAME=CARD_STRINGS.NAME;
    private static final String IMG_PATH=STRING.makeIMG_PATH(Indiscretion.class.getSimpleName());
    private static final int COST = 0;
    private static final String DESCRIPTION = CARD_STRINGS.DESCRIPTION;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardColor COLOR = COLOR_BLOOD;
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.SELF;
    public Indiscretion() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
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
    public void use(AbstractPlayer p,AbstractMonster m) {
        this.addToBot(new DrawCardAction(DRAWCARDSNUMBER));
        if (!this.upgraded)
            this.addToBot(new ApplyPowerAction(p, p, new VulnerablePower(p, VULNERABLENUMBER, false)));
        else 
            this.addToBot(new ApplyPowerAction(p, p, new DelayedVulnerable(p, VULNERABLENUMBER)));
    }
}

package VampireMadeByAlastor31415926.cards;



import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import VampireMadeByAlastor31415926.helpers.MyCard;
import VampireMadeByAlastor31415926.helpers.STRING;

public class Defend extends MyCard {
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(Defend.class.getSimpleName());
    public static final String ID=STRING.makeID(Defend.class.getSimpleName());
    public Defend() {
        super(Defend.class.getSimpleName(),CARD_STRINGS,1,CardRarity.BASIC,CardType.SKILL);
        this.block = this.baseBlock = 5;
        this.tags.add(CardTags.STARTER_DEFEND);
    }
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBlock(3);

            this.rawDescription = CARD_STRINGS.UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }

    @Override
    public void use(AbstractPlayer p,AbstractMonster m) {
          AbstractDungeon.actionManager.addToBottom(
            new GainBlockAction(
                    p,
                    this.block
                )
            );
    }

}

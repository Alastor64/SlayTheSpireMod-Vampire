package VampireMadeByAlastor31415926.cards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import VampireMadeByAlastor31415926.helpers.MyCard;

public class Defend extends MyCard {

    private static final CardStrings CARD_STRINGS = getCardString(Defend.class);
    public static final String ID = getID(Defend.class);

    public Defend() {
        super(Defend.class.getSimpleName(), CARD_STRINGS, 1, CardRarity.BASIC, CardType.SKILL);
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
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(
                new GainBlockAction(
                        p,
                        this.block
                )
        );
    }

}

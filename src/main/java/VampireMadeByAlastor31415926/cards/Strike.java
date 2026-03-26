package VampireMadeByAlastor31415926.cards;


import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import VampireMadeByAlastor31415926.helpers.MyCard;
import VampireMadeByAlastor31415926.helpers.STRING;

public class Strike extends MyCard {
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(Strike.class.getSimpleName());
    public static final String ID=STRING.makeID(Strike.class.getSimpleName());
    public Strike() {
        super(Strike.class.getSimpleName(),CARD_STRINGS,1,CardRarity.BASIC,CardType.ATTACK);
        this.damage = this.baseDamage = 6;
        this.tags.add(CardTags.STARTER_STRIKE);
        this.tags.add(CardTags.STRIKE);
    }
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(3);

            this.rawDescription = CARD_STRINGS.UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }

    @Override
    public void use(AbstractPlayer p,AbstractMonster m) {
          AbstractDungeon.actionManager.addToBottom(
            new DamageAction(
                m,
                new DamageInfo(
                    p,
                    damage,
                    DamageType.NORMAL
                )
            )
        );
    }

}

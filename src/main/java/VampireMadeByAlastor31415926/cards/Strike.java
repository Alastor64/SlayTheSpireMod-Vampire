package VampireMadeByAlastor31415926.cards;


import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import VampireMadeByAlastor31415926.helpers.STRING;
import basemod.abstracts.CustomCard;

public class Strike extends CustomCard {
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(Strike.class.getSimpleName());
    public static final String ID=STRING.makeID(Strike.class.getSimpleName());
    private static final String NAME=CARD_STRINGS.NAME;
    private static final String IMG_PATH=STRING.makeIMG_PATH(Strike.class.getSimpleName());
    private static final int COST = 1;
    private static final String DESCRIPTION = CARD_STRINGS.DESCRIPTION;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardColor COLOR = CardColor.RED;
    private static final CardRarity RARITY = CardRarity.BASIC;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    public Strike() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.damage = this.baseDamage = 6;
        this.tags.add(CardTags.STARTER_STRIKE);
        this.tags.add(CardTags.STRIKE);
        // this.retain = true;
        // this.isEthereal = true;
        // this.isInnate = true;
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

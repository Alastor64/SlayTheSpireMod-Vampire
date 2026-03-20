package VampireMadeByAlastor31415926.relics;

import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import VampireMadeByAlastor31415926.helpers.STRING;
import basemod.abstracts.CustomRelic;

public class Teeth extends CustomRelic{
    public static final String ID = STRING.makeID(Teeth.class.getSimpleName());
    private static final String IMG_PATH = STRING.makeIMG_PATH(Teeth.class.getSimpleName(),"relics");
    private static final RelicTier RELIC_TIER = RelicTier.SHOP;
    private static final LandingSound LANDING_SOUND = LandingSound.FLAT;

    public Teeth() {
        super(ID, ImageMaster.loadImage(IMG_PATH), RELIC_TIER, LANDING_SOUND);
        // this.cost = 666;
    }
    
    @Override
    public void onMonsterDeath(AbstractMonster target) {
        if ((target.isDying || target.currentHealth <= 0) && !target.halfDead && !target.hasPower("Minion")) {
            this.flash();
            this.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
            AbstractPlayer p = AbstractDungeon.player;
            if (p.currentHealth > 0) {
                p.heal(5);
            }
        }

        // 如果该能力不会修改受到伤害的数值，按原样返回即可
    }

    @Override
    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

    @Override
    public AbstractRelic makeCopy() {
        return new Teeth(); 
    } 
}

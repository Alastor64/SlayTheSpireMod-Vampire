package VampireMadeByAlastor31415926.powers;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;

import VampireMadeByAlastor31415926.helpers.STRING;

public class DelayedVulnerable extends AbstractPower{
    
    public static final String POWER_ID = STRING.makeID(DelayedVulnerable.class.getSimpleName());
    // 能力的本地化字段
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(DelayedVulnerable.class.getSimpleName());
    // 能力的名称
    private static final String NAME = powerStrings.NAME;
    // 能力的描述
    private static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    private static final AtlasRegion R128=new AtlasRegion(ImageMaster.loadImage(STRING.makeIMG_PATH(DelayedVulnerable.class.getSimpleName()+"84","powers")), 0, 0, 84, 84);
    private static final AtlasRegion R48=new AtlasRegion(ImageMaster.loadImage(STRING.makeIMG_PATH(DelayedVulnerable.class.getSimpleName()+"32","powers")), 0, 0, 32, 32);

    public DelayedVulnerable(AbstractCreature owner, int Amount) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.type = PowerType.BUFF;

        // 如果需要不能叠加的能力，只需将上面的Amount参数删掉，并把下面的Amount改成-1就行
        this.amount = Amount;

        // 添加一大一小两张能力图
        this.region128 = R128;
        this.region48 = R48;
        // 首次添加能力更新描述
        this.updateDescription();
    }

    // 能力在更新时如何修改描述
    @Override
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }

    @Override
    public void atStartOfTurn() {
        this.flash();
        this.addToTop(new ApplyPowerAction(this.owner, this.owner, new VulnerablePower(this.owner, this.amount, false)));
        this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, ID));
    }
}

package VampireMadeByAlastor31415926.modcore;

import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;

import VampireMadeByAlastor31415926.cards.Defend;
import VampireMadeByAlastor31415926.cards.Indiscretion;
import VampireMadeByAlastor31415926.cards.Strike;
import VampireMadeByAlastor31415926.cards.ThickBlood;
import VampireMadeByAlastor31415926.characters.MyCharacter;
import static VampireMadeByAlastor31415926.characters.MyCharacter.PlayerColorEnum.COLOR_BLOOD;
import static VampireMadeByAlastor31415926.characters.MyCharacter.PlayerColorEnum.MY_CHARACTER;
import VampireMadeByAlastor31415926.helpers.STRING;
import VampireMadeByAlastor31415926.relics.Teeth;
import basemod.BaseMod;
import basemod.helpers.RelicType;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditCharactersSubscriber;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.EditStringsSubscriber;

@SpireInitializer
public class core implements EditCardsSubscriber, EditStringsSubscriber, EditCharactersSubscriber, EditRelicsSubscriber {

    public static class CardTagsEnum {

        @SpireEnum
        public static AbstractCard.CardTags BLOOD_FEAST;
    }

    public core() {
        BaseMod.subscribe(this);
        BaseMod.addColor(COLOR_BLOOD, MY_COLOR, MY_COLOR, MY_COLOR, MY_COLOR, MY_COLOR, MY_COLOR, MY_COLOR, BG_ATTACK_512, BG_SKILL_512, BG_POWER_512, ENEYGY_ORB, BG_ATTACK_1024, BG_SKILL_1024, BG_POWER_1024, BIG_ORB, SMALL_ORB);
    }

    public static void initialize() {
        new core();
    }

    @Override
    public void receiveEditCharacters() {
        // 向basemod注册人物
        BaseMod.addCharacter(new MyCharacter(CardCrawlGame.playerName), MY_CHARACTER_BUTTON, MY_CHARACTER_PORTRAIT, MY_CHARACTER);
    }

    @Override
    public void receiveEditCards() {
        BaseMod.addCard(new Strike());
        BaseMod.addCard(new Defend());
        BaseMod.addCard(new Indiscretion());
        BaseMod.addCard(new ThickBlood());
    }

    @Override
    public void receiveEditStrings() {
        String lang = "ENG";
        if (Settings.language == Settings.GameLanguage.ZHS) {
            lang = "ZHS";
        }
        BaseMod.loadCustomStringsFile(CardStrings.class,
                STRING.getModPrefix() + "/localization/" + lang + "/cards.json");
        BaseMod.loadCustomStringsFile(CharacterStrings.class,
                STRING.getModPrefix() + "/localization/" + lang + "/characters.json");
        BaseMod.loadCustomStringsFile(RelicStrings.class,
                STRING.getModPrefix() + "/localization/" + lang + "/relics.json");
        BaseMod.loadCustomStringsFile(PowerStrings.class,
                STRING.getModPrefix() + "/localization/" + lang + "/powers.json");
    }

    @Override
    public void receiveEditRelics() {
        BaseMod.addRelic(new Teeth(), RelicType.SHARED);
    }

    public static final Color MY_COLOR = new Color(136.0F / 255.0F, 0F, 21.0F / 225.0F, 0.8F);
    private static final String MY_CHARACTER_BUTTON = STRING.getModPrefix() + "/img/char/Character_Button.png";
    private static final String MY_CHARACTER_PORTRAIT = STRING.getModPrefix() + "/img/char/Character_Portrait.png";
    private static final String BG_ATTACK_512 = STRING.getModPrefix() + "/img/512/bg_attack_512.png";
    private static final String BG_POWER_512 = STRING.getModPrefix() + "/img/512/bg_power_512.png";
    private static final String BG_SKILL_512 = STRING.getModPrefix() + "/img/512/bg_skill_512.png";
    private static final String SMALL_ORB = STRING.getModPrefix() + "/img/char/small_orb.png";
    private static final String BG_ATTACK_1024 = STRING.getModPrefix() + "/img/1024/bg_attack.png";
    private static final String BG_POWER_1024 = STRING.getModPrefix() + "/img/1024/bg_power.png";
    private static final String BG_SKILL_1024 = STRING.getModPrefix() + "/img/1024/bg_skill.png";
    private static final String BIG_ORB = STRING.getModPrefix() + "/img/char/card_orb.png";
    private static final String ENEYGY_ORB = STRING.getModPrefix() + "/img/char/cost_orb.png";
}

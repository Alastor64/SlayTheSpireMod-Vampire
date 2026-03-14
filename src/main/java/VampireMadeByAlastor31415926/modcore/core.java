package VampireMadeByAlastor31415926.modcore;

import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.localization.CardStrings;

import VampireMadeByAlastor31415926.cards.Strike;
import VampireMadeByAlastor31415926.helpers.STRING;
import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditStringsSubscriber;

@SpireInitializer
public class core implements EditCardsSubscriber,EditStringsSubscriber{
    public core() {
        BaseMod.subscribe(this);
    }

    public static void initialize() {
        new core();
    }

    @Override
    public void receiveEditCards() {
        BaseMod.addCard(new Strike());
    }

    @Override
    public void receiveEditStrings() {
        String lang = "ENG";
        if (Settings.language == Settings.GameLanguage.ZHS) {
            lang = "ZHS";
        }
        BaseMod.loadCustomStringsFile(CardStrings.class, STRING.getModPrefix()+"/localization/" + lang + "/cards.json");
    }
}

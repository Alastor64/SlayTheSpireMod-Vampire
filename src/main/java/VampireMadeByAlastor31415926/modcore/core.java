package VampireMadeByAlastor31415926.modcore;

import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

import VampireMadeByAlastor31415926.cards.Strike;
import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;

@SpireInitializer
public class core implements EditCardsSubscriber{
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
}

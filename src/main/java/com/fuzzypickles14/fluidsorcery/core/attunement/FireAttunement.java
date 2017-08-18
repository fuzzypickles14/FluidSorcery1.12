package com.fuzzypickles14.fluidsorcery.core.attunement;

import com.fuzzypickles14.fluidsorcery.lib.LibModDetails;
import net.minecraft.potion.Potion;

/**
 * Created by Andrew Toomey on 8/17/2017.
 */
public class FireAttunement extends Potion {
    public FireAttunement(boolean isBadEffectIn, int liquidColorIn) {
        super(isBadEffectIn, liquidColorIn);
        this.setRegistryName(LibModDetails.MODID, "fireAttunement");
        this.setPotionName("effect." + this.getRegistryName().toString());
    }
}

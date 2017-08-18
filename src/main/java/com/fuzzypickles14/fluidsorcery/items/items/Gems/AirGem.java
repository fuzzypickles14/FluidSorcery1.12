package com.fuzzypickles14.fluidsorcery.items.items.Gems;

import com.fuzzypickles14.fluidsorcery.core.attunement.AirAttunement;
import net.minecraft.block.material.MapColor;
import net.minecraft.potion.Potion;

/**
 * Created by Andrew Toomey on 8/11/2017.
 */
public class AirGem extends BaseGem {
    public AirGem(String unlocalizedName) {
        super(unlocalizedName);
        this.attunement = new AirAttunement(false, MapColor.YELLOW.colorValue, "airattunement");
    }
}

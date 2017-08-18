package com.fuzzypickles14.fluidsorcery.items.items.Gems;

import com.fuzzypickles14.fluidsorcery.core.attunement.EarthAttunement;
import net.minecraft.block.material.MapColor;

/**
 * Created by Andrew Toomey on 8/11/2017.
 */
public class EarthGem extends BaseGem {
    public EarthGem(String unlocalizedName) {
        super(unlocalizedName);
        this.attunement = new EarthAttunement(false, MapColor.GREEN.colorValue, "earthattunement");
    }
}

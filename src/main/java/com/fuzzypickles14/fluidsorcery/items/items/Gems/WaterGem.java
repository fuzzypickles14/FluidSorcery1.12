package com.fuzzypickles14.fluidsorcery.items.items.Gems;


import com.fuzzypickles14.fluidsorcery.core.attunement.WaterAttunement;
import net.minecraft.block.material.MapColor;
import net.minecraft.potion.Potion;

/**
 * Created by Andrew Toomey on 8/11/2017.
 */
public class WaterGem extends BaseGem {
    public WaterGem(String unlocalizedName) {
        super(unlocalizedName);
        this.attunement = new WaterAttunement(false, MapColor.BLUE.colorValue);
    }
}

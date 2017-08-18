package com.fuzzypickles14.fluidsorcery.items.items.Gems;


import com.fuzzypickles14.fluidsorcery.core.attunement.FireAttunement;
import net.minecraft.block.material.MapColor;

/**
 * Created by Andrew Toomey on 8/11/2017.
 */
public class FireGem extends BaseGem {
    public FireGem(String unlocalizedName) {
        super(unlocalizedName);
        this.attunement = new FireAttunement(false, MapColor.RED.colorValue);
    }
}

package com.fuzzypickles14.fluidsorcery.core.attunement;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

/**
 * Created by Andrew Toomey on 8/17/2017.
 */
public class BaseAttunement extends PotionEffect {


    private String attunment;

    public BaseAttunement(Potion potionIn) {
        super(potionIn, 1);
    }

    @Override
    public boolean onUpdate(EntityLivingBase entityIn) {
        return true;
    }

    @Override
    public boolean doesShowParticles() {
        return false;
    }

    public String get() {
        return "Attunement";
    }

    public void setAttunement(String attunment) {
        this.attunment = attunment;
    }
}

package com.fuzzypickles14.fluidsorcery.items.items.Gems;

import com.fuzzypickles14.fluidsorcery.core.attunement.BaseAttunement;
import com.fuzzypickles14.fluidsorcery.items.ModItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/**
 * Created by Andrew Toomey on 8/11/2017.
 */
public class BaseGem extends ModItem {

    protected Potion attunement;

    public BaseGem(String unlocalizedName) {
        super(unlocalizedName);
        attunement = null;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        PotionEffect effect = new BaseAttunement(attunement);
        for (PotionEffect potion : playerIn.getActivePotionEffects()) {
            if (potion instanceof BaseAttunement) {
                playerIn.removePotionEffect(potion.getPotion());
            }
        }
        playerIn.addPotionEffect(effect);
        return new ActionResult<ItemStack>(EnumActionResult.PASS, new ItemStack(this));
    }
}

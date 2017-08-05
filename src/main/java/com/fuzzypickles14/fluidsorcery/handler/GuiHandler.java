package com.fuzzypickles14.fluidsorcery.handler;

import com.fuzzypickles14.fluidsorcery.core.gui.GuiManual;
import com.fuzzypickles14.fluidsorcery.lib.LibGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

/**
 * Created by Andrew Toomey on 7/11/2017.
 */
public class GuiHandler implements IGuiHandler {
    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == LibGui.MANUAL_GUI)
            return new GuiManual();
        return null;
    }
}

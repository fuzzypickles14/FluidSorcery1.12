package com.fuzzypickles14.fluidsorcery.lib;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;

/**
 * Created by Andrew Toomey on 8/7/2017.
 */
public interface MeshDefinitionFix extends ItemMeshDefinition {
    ModelResourceLocation getLocation(final ItemStack stack);

    // Helper method to easily create lambda instances of this class
    static ItemMeshDefinition create(final MeshDefinitionFix lambda) {
        return lambda;
    }

    @Override
    default ModelResourceLocation getModelLocation(final ItemStack stack) {
        return getLocation(stack);
    }
}

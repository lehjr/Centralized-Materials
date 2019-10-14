package com.stc.centralizedmaterials.hlh;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraftforge.common.ToolType;

public class BaseBlock extends Block {
    public final HarvestLevelHelper resource;

    public BaseBlock(String name, Properties builder, HarvestLevelHelper resource) {
        super(builder);
        this.setRegistryName("centralizedmaterials", name);
        this.resource = resource;
    }

    public ToolType getHarvestTool(BlockState state) {
        return ToolType.PICKAXE;
    }

    public int getHarvestLevel(BlockState state) {
        return this.resource.harvestLevel;
    }
}

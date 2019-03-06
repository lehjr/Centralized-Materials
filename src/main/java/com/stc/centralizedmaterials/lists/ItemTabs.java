package com.stc.centralizedmaterials.lists;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemTabs {

    public static ItemGroup tabCentralixedMaterials = new ItemGroup(ItemGroup.getGroupCountSafe(), "tabCentralixedMaterials") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemList.copper_ingot);
        }
    };
}

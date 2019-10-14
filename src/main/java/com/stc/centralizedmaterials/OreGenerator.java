package com.stc.centralizedmaterials;

import com.stc.centralizedmaterials.lists.BlockList;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Iterator;

public class OreGenerator {
    public static void setupOreGen() {
        Iterator biomeIterator = ForgeRegistries.BIOMES.iterator();

        while(biomeIterator.hasNext()) {
            Biome biome = (Biome)biomeIterator.next();
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.aluminium_ore.getDefaultState(), 8), Placement.COUNT_RANGE, new CountRangeConfig(5, 0, 40, 75)));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.copper_ore.getDefaultState(), 8), Placement.COUNT_RANGE, new CountRangeConfig(5, 0, 40, 75)));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.lead_ore.getDefaultState(), 8), Placement.COUNT_RANGE, new CountRangeConfig(5, 0, 10, 35)));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.nickel_ore.getDefaultState(), 4), Placement.COUNT_RANGE, new CountRangeConfig(5, 0, 5, 20)));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.platinum_ore.getDefaultState(), 1), Placement.COUNT_RANGE, new CountRangeConfig(10, 0, 8, 65)));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.silver_ore.getDefaultState(), 8), Placement.COUNT_RANGE, new CountRangeConfig(5, 0, 5, 30)));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.tin_ore.getDefaultState(), 8), Placement.COUNT_RANGE, new CountRangeConfig(5, 0, 20, 55)));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.uranium_ore.getDefaultState(), 4), Placement.COUNT_RANGE, new CountRangeConfig(5, 0, 16, 42)));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.zinc_ore.getDefaultState(), 7), Placement.COUNT_RANGE, new CountRangeConfig(5, 0, 1, 75)));
        }
    }
}
package com.stc.centralizedmaterials;

import com.stc.centralizedmaterials.config.Configuration;
import com.stc.centralizedmaterials.lists.BlockList;
import com.stc.centralizedmaterials.lists.ItemList;
import com.stc.centralizedmaterials.lists.ItemTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.CompositeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MinableConfig;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

@Mod(value = CentralizedMaterialsMod.modid)
public class CentralizedMaterialsMod
{

    public static Random random = new Random();

    public static CentralizedMaterialsMod instance;
    public static final String modid = "centralizedmaterials";
    private static final Logger logger = LogManager.getLogger(modid);

    public CentralizedMaterialsMod() {

        instance = this;

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

        MinecraftForge.EVENT_BUS.register(this);
        Configuration.init();
    }

    private static CompositeFeature<?, ?> getOreGenFeature(Block ore, int chance, int size, int avgHeight, int spread) {
        return Biome.createCompositeFeature(Feature.MINABLE, new MinableConfig((blockState) -> Tags.Blocks.STONE.contains(blockState.getBlock()) || Tags.Blocks.ORES.contains(blockState.getBlock()), ore.getDefaultState(), chance), Biome.DEPTH_AVERAGE, new DepthAverageConfig(size, avgHeight, spread));
    }

    private void setup(final FMLCommonSetupEvent event)
    {

        //World Generation
        //Overworld
        CompositeFeature<?, ?> copper_ore = getOreGenFeature(BlockList.copper_ore, 5, 8, 40, 75);
        CompositeFeature<?, ?> tin_ore = getOreGenFeature(BlockList.tin_ore, 5, 8, 20, 55);
        CompositeFeature<?, ?> silver_ore = getOreGenFeature(BlockList.silver_ore, 5, 8, 5, 30);
        CompositeFeature<?, ?> lead_ore = getOreGenFeature(BlockList.lead_ore, 5, 8, 10, 35);
        CompositeFeature<?, ?> platinum_ore = getOreGenFeature(BlockList.platinum_ore, 10, 1, 8, 65);
        CompositeFeature<?, ?> uranium_ore = getOreGenFeature(BlockList.uranium_ore, 5, 4, 16, 42);
        CompositeFeature<?, ?> nickel_ore = getOreGenFeature(BlockList.nickel_ore, 5, 4, 5, 20);
        CompositeFeature<?, ?> aluminium_ore = getOreGenFeature(BlockList.aluminium_ore, 5, 8, 40, 75);
        CompositeFeature<?, ?> zinc_ore = getOreGenFeature(BlockList.zinc_ore, 5, 7, 1, 75);

        for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
            //Overworld Gen
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, copper_ore);
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, tin_ore);
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, silver_ore);
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, lead_ore);
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, platinum_ore);
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, uranium_ore);
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, nickel_ore);
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, aluminium_ore);
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, zinc_ore);

        }

        logger.info("Setup method registry.");

    }

    private void clientRegistries(final FMLClientSetupEvent event) {
        logger.info("Client registries method registered.");
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents extends Block {

        public RegistryEvents(Properties properties) {
            super(properties);
        }

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event ) {
            event.getRegistry().registerAll(

                    BlockList.copper_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)).setRegistryName(location("copper_ore")),
                    BlockList.tin_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)).setRegistryName(location("tin_ore")),
                    BlockList.lead_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)).setRegistryName(location("lead_ore")),
                    BlockList.silver_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)).setRegistryName(location("silver_ore")),
                    BlockList.platinum_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)).setRegistryName(location("platinum_ore")),
                    BlockList.uranium_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)).setRegistryName(location("uranium_ore")),
                    BlockList.nickel_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)).setRegistryName(location("nickel_ore")),
                    BlockList.aluminium_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)).setRegistryName(location("aluminium_ore")),
                    BlockList.zinc_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)).setRegistryName(location("zinc_ore")),

                    BlockList.copper_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)).setRegistryName(location("copper_block")),
                    BlockList.tin_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)).setRegistryName(location("tin_block")),
                    BlockList.lead_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)).setRegistryName(location("lead_block")),
                    BlockList.silver_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)).setRegistryName(location("silver_block")),
                    BlockList.platinum_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)).setRegistryName(location("platinum_block")),
                    BlockList.uranium_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)).setRegistryName(location("uranium_block")),
                    BlockList.steel_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)).setRegistryName(location("steel_block")),
                    BlockList.bronze_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)).setRegistryName(location("bronze_block")),
                    BlockList.nickel_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)).setRegistryName(location("nickel_block")),
                    BlockList.invar_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)).setRegistryName(location("invar_block")),
                    BlockList.aluminium_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)).setRegistryName(location("aluminium_block")),
                    BlockList.zinc_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)).setRegistryName(location("zinc_block")),
                    BlockList.electrum_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)).setRegistryName(location("electrum_block"))
            );
        }


        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event )
        {
            event.getRegistry().registerAll(

                    ItemList.copper_ore = new ItemBlock(BlockList.copper_ore, new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("copper_ore")),
                    ItemList.tin_ore = new ItemBlock(BlockList.tin_ore, new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("tin_ore")),
                    ItemList.lead_ore = new ItemBlock(BlockList.lead_ore, new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("lead_ore")),
                    ItemList.silver_ore = new ItemBlock(BlockList.silver_ore, new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("silver_ore")),
                    ItemList.platinum_ore = new ItemBlock(BlockList.platinum_ore, new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("platinum_ore")),
                    ItemList.uranium_ore = new ItemBlock(BlockList.uranium_ore, new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("uranium_ore")),
                    ItemList.nickel_ore = new ItemBlock(BlockList.nickel_ore, new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("nickel_ore")),
                    ItemList.aluminium_ore = new ItemBlock(BlockList.aluminium_ore, new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("aluminium_ore")),
                    ItemList.zinc_ore = new ItemBlock(BlockList.zinc_ore, new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("zinc_ore")),

                    ItemList.copper_block = new ItemBlock(BlockList.copper_block, new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("copper_block")),
                    ItemList.tin_block = new ItemBlock(BlockList.tin_block, new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("tin_block")),
                    ItemList.lead_block = new ItemBlock(BlockList.lead_block, new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("lead_block")),
                    ItemList.silver_block = new ItemBlock(BlockList.silver_block, new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("silver_block")),
                    ItemList.platinum_block = new ItemBlock(BlockList.platinum_block, new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("platinum_block")),
                    ItemList.uranium_block = new ItemBlock(BlockList.uranium_block, new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("uranium_block")),
                    ItemList.steel_block = new ItemBlock(BlockList.steel_block, new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("steel_block")),
                    ItemList.bronze_block = new ItemBlock(BlockList.bronze_block, new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("bronze_block")),
                    ItemList.nickel_block = new ItemBlock(BlockList.nickel_block, new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("nickel_block")),
                    ItemList.invar_block = new ItemBlock(BlockList.invar_block, new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("invar_block")),
                    ItemList.aluminium_block = new ItemBlock(BlockList.aluminium_block, new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("aluminium_block")),
                    ItemList.zinc_block = new ItemBlock(BlockList.zinc_block, new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("zinc_block")),
                    ItemList.electrum_block = new ItemBlock(BlockList.electrum_block, new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("electrum_block")),

                    ItemList.copper_ingot = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("copper_ingot")),
                    ItemList.tin_ingot = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("tin_ingot")),
                    ItemList.lead_ingot = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("lead_ingot")),
                    ItemList.silver_ingot = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("silver_ingot")),
                    ItemList.platinum_ingot = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("platinum_ingot")),
                    ItemList.uranium_ingot = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("uranium_ingot")),
                    ItemList.steel_ingot = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("steel_ingot")),
                    ItemList.bronze_ingot = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("bronze_ingot")),
                    ItemList.nickel_ingot = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("nickel_ingot")),
                    ItemList.invar_ingot = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("invar_ingot")),
                    ItemList.obsidian_ingot = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("obsidian_ingot")),
                    ItemList.aluminium_ingot = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("aluminium_ingot")),
                    ItemList.zinc_ingot = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("zinc_ingot")),
                    ItemList.electrum_ingot = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("electrum_ingot")),

                    ItemList.iron_dust = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("iron_dust")),
                    ItemList.gold_dust = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("gold_dust")),
                    ItemList.copper_dust = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("copper_dust")),
                    ItemList.tin_dust = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("tin_dust")),
                    ItemList.lead_dust = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("lead_dust")),
                    ItemList.silver_dust = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("silver_dust")),
                    ItemList.platinum_dust = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("platinum_dust")),
                    ItemList.uranium_dust = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("uranium_dust")),
                    ItemList.steel_dust = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("steel_dust")),
                    ItemList.bronze_dust = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("bronze_dust")),
                    ItemList.nickel_dust = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("nickel_dust")),
                    ItemList.invar_dust = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("invar_dust")),
                    ItemList.obsidian_dust = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("obsidian_dust")),
                    ItemList.aluminium_dust = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("aluminium_dust")),
                    ItemList.zinc_dust = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("zinc_dust")),
                    ItemList.electrum_dust = new Item(new Item.Properties().group(ItemTabs.tabCentralixedMaterials)).setRegistryName(location("electrum_dust"))

            );

            logger.info("Items registered.");
        }

        private static ResourceLocation location(String name) {
            return new ResourceLocation(modid, name);
        }
    }
}

package com.stc.centralizedmaterials;

import com.stc.centralizedmaterials.config.Configuration;
import com.stc.centralizedmaterials.hlh.BaseBlock;
import com.stc.centralizedmaterials.hlh.HarvestLevelHelper;
import com.stc.centralizedmaterials.lists.BlockList;
import com.stc.centralizedmaterials.lists.ItemList;
import com.stc.centralizedmaterials.lists.ItemTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

@Mod(value = CentralizedMaterialsMod.modid)
public class CentralizedMaterialsMod {

    public static Random random = new Random();
    public static CentralizedMaterialsMod instance;
    public static final String modid = "centralizedmaterials";
    private static final Logger logger = LogManager.getLogger("centralizedmaterials");

    public CentralizedMaterialsMod() {
        instance = this;
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

        MinecraftForge.EVENT_BUS.register(this);
        Configuration.init();
    }

    private void setup(FMLCommonSetupEvent event) {
        OreGenerator.setupOreGen();
    }

    private void clientRegistries(FMLClientSetupEvent event) {
        logger.info("Client registries method registered.");
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents extends Block {

        public RegistryEvents(Properties properties) {
            super(properties);
        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            event.getRegistry().registerAll(
                    BlockList.aluminium_ore = new BaseBlock("aluminium_ore", Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F), HarvestLevelHelper.STONE),
                    BlockList.copper_ore = new BaseBlock("copper_ore", Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F), HarvestLevelHelper.STONE),
                    BlockList.lead_ore = new BaseBlock("lead_ore", Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F), HarvestLevelHelper.IRON),
                    BlockList.nickel_ore = new BaseBlock("nickel_ore", Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F), HarvestLevelHelper.IRON),
                    BlockList.platinum_ore = new BaseBlock("platinum_ore", Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F), HarvestLevelHelper.DIAMOND),
                    BlockList.silver_ore = new BaseBlock("silver_ore", Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F), HarvestLevelHelper.IRON),
                    BlockList.tin_ore = new BaseBlock("tin_ore", Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F), HarvestLevelHelper.STONE),
                    BlockList.titanium_ore = new BaseBlock("titanium_ore", Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F), HarvestLevelHelper.STONE),
                    BlockList.tungsten_ore = new BaseBlock("tungsten_ore", Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F), HarvestLevelHelper.STONE),
                    BlockList.uranium_ore = new BaseBlock("uranium_ore", Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F), HarvestLevelHelper.DIAMOND),
                    BlockList.zinc_ore = new BaseBlock("zinc_ore", Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F), HarvestLevelHelper.IRON),


                    BlockList.aluminium_block = (new Block(Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F))).setRegistryName(location("aluminium_block")),
                    BlockList.brass_block = (new Block(Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F))).setRegistryName(location("brass_block")),
                    BlockList.bronze_block = (new Block(Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F))).setRegistryName(location("bronze_block")),
                    BlockList.copper_block = (new Block(Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F))).setRegistryName(location("copper_block")),
                    BlockList.electrum_block = (new Block(Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F))).setRegistryName(location("electrum_block")),
                    BlockList.invar_block = (new Block(Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F))).setRegistryName(location("invar_block")),
                    BlockList.lead_block = (new Block(Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F))).setRegistryName(location("lead_block")),
                    BlockList.platinum_block = (new Block(Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F))).setRegistryName(location("platinum_block")),
                    BlockList.refined_iron_block = (new Block(Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F))).setRegistryName(location("refined_iron_block")),
                    BlockList.silver_block = (new Block(Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F))).setRegistryName(location("silver_block")),
                    BlockList.steel_block = (new Block(Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F))).setRegistryName(location("steel_block")),
                    BlockList.tin_block = (new Block(Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F))).setRegistryName(location("tin_block")),
                    BlockList.titanium_block = (new Block(Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F))).setRegistryName(location("titanium_block")),
                    BlockList.tungsten_block = (new Block(Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F))).setRegistryName(location("tungsten_block")),
                    BlockList.uranium_block = (new Block(Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F))).setRegistryName(location("uranium_block")),
                    BlockList.nickel_block = (new Block(Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F))).setRegistryName(location("nickel_block")),
                    BlockList.zinc_block = (new Block(Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F))).setRegistryName(location("zinc_block")));
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            event.getRegistry().registerAll(
                    ItemList.aluminium_ore = (new BlockItem(BlockList.aluminium_ore, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("aluminium_ore")),
                    ItemList.copper_ore = (new BlockItem(BlockList.copper_ore, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("copper_ore")),
                    ItemList.lead_ore = (new BlockItem(BlockList.lead_ore, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("lead_ore")),
                    ItemList.nickel_ore = (new BlockItem(BlockList.nickel_ore, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("nickel_ore")),
                    ItemList.platinum_ore = (new BlockItem(BlockList.platinum_ore, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("platinum_ore")),
                    ItemList.silver_ore = (new BlockItem(BlockList.silver_ore, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("silver_ore")),
                    ItemList.tin_ore = (new BlockItem(BlockList.tin_ore, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("tin_ore")),
                    ItemList.titanium_ore = (new BlockItem(BlockList.titanium_ore, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("titanium_ore")),
                    ItemList.tungsten_ore = (new BlockItem(BlockList.tungsten_ore, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("tungsten_ore")),
                    ItemList.uranium_ore = (new BlockItem(BlockList.uranium_ore, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("uranium_ore")),
                    ItemList.zinc_ore = (new BlockItem(BlockList.zinc_ore, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("zinc_ore")),


                    ItemList.aluminium_block = (new BlockItem(BlockList.aluminium_block, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("aluminium_block")),
                    ItemList.brass_block = (new BlockItem(BlockList.brass_block, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("brass_block")),
                    ItemList.bronze_block = (new BlockItem(BlockList.bronze_block, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("bronze_block")),
                    ItemList.copper_block = (new BlockItem(BlockList.copper_block, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("copper_block")),
                    ItemList.electrum_block = (new BlockItem(BlockList.electrum_block, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("electrum_block")),
                    ItemList.invar_block = (new BlockItem(BlockList.invar_block, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("invar_block")),
                    ItemList.lead_block = (new BlockItem(BlockList.lead_block, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("lead_block")),
                    ItemList.nickel_block = (new BlockItem(BlockList.nickel_block, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("nickel_block")),
                    ItemList.platinum_block = (new BlockItem(BlockList.platinum_block, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("platinum_block")),
                    ItemList.refined_iron_block = (new BlockItem(BlockList.refined_iron_block, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("refined_iron_block")),
                    ItemList.silver_block = (new BlockItem(BlockList.silver_block, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("silver_block")),
                    ItemList.steel_block = (new BlockItem(BlockList.steel_block, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("steel_block")),
                    ItemList.tin_block = (new BlockItem(BlockList.tin_block, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("tin_block")),
                    ItemList.titanium_block = (new BlockItem(BlockList.titanium_block, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("titanium_block")),
                    ItemList.tungsten_block = (new BlockItem(BlockList.tungsten_block, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("tungsten_block")),
                    ItemList.uranium_block = (new BlockItem(BlockList.uranium_block, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("uranium_block")),
                    ItemList.zinc_block = (new BlockItem(BlockList.zinc_block, (new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("zinc_block")),


                    ItemList.aluminium_ingot = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("aluminium_ingot")),
                    ItemList.brass_ingot = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("brass_ingot")),
                    ItemList.bronze_ingot = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("bronze_ingot")),
                    ItemList.copper_ingot = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("copper_ingot")),
                    ItemList.electrum_ingot = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("electrum_ingot")),
                    ItemList.invar_ingot = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("invar_ingot")),
                    ItemList.lead_ingot = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("lead_ingot")),
                    ItemList.nickel_ingot = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("nickel_ingot")),
                    ItemList.obsidian_ingot = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("obsidian_ingot")),
                    ItemList.platinum_ingot = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("platinum_ingot")),
                    ItemList.refined_iron_ingot = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("refined_iron_ingot")),
                    ItemList.silver_ingot = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("silver_ingot")),
                    ItemList.steel_ingot = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("steel_ingot")),
                    ItemList.tin_ingot = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("tin_ingot")),
                    ItemList.titanium_ingot = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("titanium_ingot")),
                    ItemList.tungsten_ingot = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("tungsten_ingot")),
                    ItemList.uranium_ingot = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("uranium_ingot")),
                    ItemList.zinc_ingot = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("zinc_ingot")),



                    ItemList.aluminium_dust = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("aluminium_dust")),
                    ItemList.brass_dust = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("brass_dust")),
                    ItemList.bronze_dust = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("bronze_dust")),
                    ItemList.copper_dust = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("copper_dust")),
                    ItemList.diamond_dust = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("diamond_dust")),
                    ItemList.electrum_dust = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("electrum_dust")),
                    ItemList.gold_dust = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("gold_dust")),
                    ItemList.iron_dust = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("iron_dust")),
                    ItemList.invar_dust = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("invar_dust")),
                    ItemList.lead_dust = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("lead_dust")),
                    ItemList.nickel_dust = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("nickel_dust")),
                    ItemList.platinum_dust = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("platinum_dust")),
                    ItemList.obsidian_dust = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("obsidian_dust")),
                    ItemList.refined_iron_dust = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("refined_iron_dust")),
                    ItemList.silver_dust = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("silver_dust")),
                    ItemList.steel_dust = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("steel_dust")),
                    ItemList.tin_dust = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("tin_dust")),
                    ItemList.titanium_dust = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("titanium_dust")),
                    ItemList.tungsten_dust = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("tungsten_dust")),
                    ItemList.uranium_dust = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("uranium_dust")),
                    ItemList.zinc_dust = (new Item((new Item.Properties()).group(ItemTabs.tabCentralixedMaterials))).setRegistryName(location("zinc_dust")));
            CentralizedMaterialsMod.logger.info("Items registered.");
        }

        private static ResourceLocation location(String name) {
            return new ResourceLocation(modid, name);
        }
    }
}

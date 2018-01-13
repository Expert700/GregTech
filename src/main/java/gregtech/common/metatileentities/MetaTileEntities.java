package gregtech.common.metatileentities;

import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.GregtechTileEntity;
import gregtech.api.metatileentity.factory.TieredMetaTileEntityFactory;
import gregtech.api.metatileentity.factory.WorkableMetaTileEntityFactory;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.GTResourceLocation;
import gregtech.common.blocks.BlockMachine;
import gregtech.common.blocks.properties.PropertyString;
import gregtech.common.blocks.tileentity.TileEntityCableEmitter;
import gregtech.common.metatileentities.steam.SteamCompressor;
import gregtech.common.metatileentities.steam.SteamExtractor;
import gregtech.common.metatileentities.steam.SteamMacerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MetaTileEntities {

    public static void init() {
//        GTLog.logger.info("Registering TileEntities.");

        GameRegistry.registerTileEntity(GregtechTileEntity.class, "gregtech_tile_entity");
        GameRegistry.registerTileEntity(TileEntityCableEmitter.class, "gregtech_cable_emitter");

        GregTechAPI.METATILEENTITY_REGISTRY.register(1, "mte_test", new WorkableMetaTileEntityFactory<>(BlockMachine.ToolClass.WRENCH, 1, new String[]{"test_desc"}, TestMTE.class, new GTResourceLocation("mte_test"), 1, RecipeMap.FURNACE_RECIPES));
        GregTechAPI.METATILEENTITY_REGISTRY.register(2, "mte_test_generator", new TieredMetaTileEntityFactory<>(BlockMachine.ToolClass.WRENCH, 1, new String[]{"test_desc_generator"}, TestGeneratorMTE.class, new GTResourceLocation("mte_test_generator"), 1));
        GregTechAPI.METATILEENTITY_REGISTRY.register(3, "steam_extractor", new WorkableMetaTileEntityFactory<>(BlockMachine.ToolClass.WRENCH, 1, new String[]{"Extractoring the good stuff"}, SteamExtractor.class, new GTResourceLocation("steam_extractor"), 1,RecipeMap.EXTRACTOR_RECIPES));
        GregTechAPI.METATILEENTITY_REGISTRY.register(4, "steam_macerator", new WorkableMetaTileEntityFactory<>(BlockMachine.ToolClass.WRENCH, 1, new String[]{"Don't stick your fingers in"}, SteamMacerator.class, new GTResourceLocation("steam_macerator"), 1,RecipeMap.MACERATOR_RECIPES));
        GregTechAPI.METATILEENTITY_REGISTRY.register(5, "steam_compressor", new WorkableMetaTileEntityFactory<>(BlockMachine.ToolClass.WRENCH, 1, new String[]{"Squeeze it together"}, SteamCompressor.class, new GTResourceLocation("steam_compressor"), 1,RecipeMap.COMPRESSOR_RECIPES));

        BlockMachine.META_TYPE = PropertyString.create("meta_type", GregTechAPI.METATILEENTITY_REGISTRY.getKeys());
    }
}

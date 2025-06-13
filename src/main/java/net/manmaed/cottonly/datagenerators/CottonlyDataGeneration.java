package net.manmaed.cottonly.datagenerators;

import net.manmaed.cottonly.Cottonly;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Cottonly.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class CottonlyDataGeneration {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator =  event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        generator.addProvider(true, new CottonRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(true,  new CottonItemModelProvider(packOutput, fileHelper));
        generator.addProvider(true, new CottonBlockModelProvider(packOutput, fileHelper));
        CottonTagsProvider.addTags(event);
        generator.addProvider(true, new CottonGlobalLootModifierProvider(packOutput,  lookupProvider));
        generator.addProvider(true, new CottonLootTables(packOutput, lookupProvider));
        generator.addProvider(true, new CottonBlockStateProvider(packOutput, fileHelper));
        CottonLanguageProvider.addTranslations(generator);
        generator.addProvider(true, new CottonDataMaps(packOutput, lookupProvider));
    }
}

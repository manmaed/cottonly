package net.manmaed.cottonly.datagenerators;

import net.manmaed.cottonly.Cottonly;
import net.manmaed.cottonly.blocks.CBlocks;
import net.manmaed.cottonly.items.CItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CottonTagsProvider {
    public static void addTags(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> completableFuture = event.getLookupProvider();
        CottonBlockTags blockTag = new CottonBlockTags(packOutput, completableFuture, fileHelper);
        generator.addProvider(true, blockTag);
        generator.addProvider(true, new CottonItemTags(packOutput, completableFuture, blockTag.contentsGetter(), fileHelper));

    }

    static class CottonItemTags extends ItemTagsProvider {

        public CottonItemTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture, CompletableFuture<TagLookup<Block>> blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(packOutput, completableFuture, blockTagProvider, Cottonly.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider lookup) {
            //Own Tags

            //Minecraft Tags
            tag(ItemTags.DYEABLE).add(CItems.COTTON_HAT.get());
            tag(ItemTags.DYEABLE).add(CItems.COTTON_SHIRT.get());
            tag(ItemTags.DYEABLE).add(CItems.COTTON_TROUSERS.get());
            tag(ItemTags.DYEABLE).add(CItems.COTTON_SOCKS.get());
            tag(ItemTags.VILLAGER_PLANTABLE_SEEDS).add(CItems.COTTON_SEED.get());

            //Common Tags
            tag(Tags.Items.SEEDS).add(CItems.COTTON_SEED.get());
            tag(Tags.Items.CROPS).add(CItems.COTTON_BALL.get());
        }
    }

    static class CottonBlockTags extends BlockTagsProvider {

        public CottonBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, Cottonly.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider lookup) {
            tag(BlockTags.CROPS).add(CBlocks.COTTON_PLANT.get());
        }
    }
}

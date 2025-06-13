package net.manmaed.cottonly.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.SpecialPlantable;
import org.jetbrains.annotations.Nullable;

public class CottonSeedItem extends ItemNameBlockItem implements SpecialPlantable {
    public CottonSeedItem(Block block) {
        super(block, new Item.Properties());
    }

    @Override
    public boolean canPlacePlantAtPosition(ItemStack itemStack, LevelReader level, BlockPos pos, @Nullable Direction direction) {
        return true;
    }

    @Override
    public void spawnPlantAtPosition(ItemStack itemStack, LevelAccessor level, BlockPos pos, @Nullable Direction direction) {
        level.setBlock(pos, getBlock().defaultBlockState(), 2);
    }

    @Override
    public boolean villagerCanPlantItem(Villager villager) {
        return true;
    }
}

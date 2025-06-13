package net.manmaed.cottonly;

import net.manmaed.cottonly.blocks.CBlocks;
import net.manmaed.cottonly.items.CItems;
import net.manmaed.cottonly.loot.CLoots;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Arrays;
import java.util.List;


/**
 * Created by manmaed on 16/05/2021.
 */

@Mod(Cottonly.MOD_ID)
public class Cottonly {
    public static final String MOD_ID = "cottonly";
    /*
     * TODO:
     * Fix Default Color on cotton armor
     */
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> cottonlyTab = CREATIVE_MODE_TABS.register(MOD_ID, () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(Items.WITHER_ROSE))
            .title(Component.translatable("itemGroup." + MOD_ID))
            .displayItems((parms, output) -> {
                List<DeferredRegister<Item>> myItems  = Arrays.asList(
                        CItems.ITEMS
                );
                for (DeferredRegister<Item> register : myItems) {
                    register.getEntries().forEach(entry -> output.accept(entry.get()));
                }
            })
            .build());


    public Cottonly(IEventBus eventBus) {
        CItems.ITEMS.register(eventBus);
        CBlocks.BLOCKS.register(eventBus);
        CLoots.LOOT_MODIFIERS.register(eventBus);
        CREATIVE_MODE_TABS.register(eventBus);

    }


}

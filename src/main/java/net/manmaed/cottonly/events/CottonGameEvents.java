package net.manmaed.cottonly.events;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.manmaed.cottonly.Cottonly;
import net.manmaed.cottonly.items.CItems;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import java.util.List;

@EventBusSubscriber(modid = Cottonly.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class CottonGameEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //Emerald -> Item
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(CItems.COTTON_BALL.get(), 16), 6,3, 0.05F)
            );

            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(CItems.COTTON_SEED.get(), 16), 6,3, 0.05F)
            );

            //Item -> Emerald
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(CItems.COTTON_BALL.get(), 64),
                    new ItemStack(Items.EMERALD, 1), 6,3, 0.05F)
            );

            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(CItems.COTTON_SEED.get(), 64),
                    new ItemStack(Items.EMERALD, 1), 6,3, 0.05F)
            );
        }
    }

    @SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 3),
                new ItemStack(CItems.COTTON_BALL.get(), 64), 1,0, 0.02F)
        );
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 3),
                new ItemStack(CItems.COTTON_SEED.get(), 64), 1,0, 0.02F)
        );
    }
}

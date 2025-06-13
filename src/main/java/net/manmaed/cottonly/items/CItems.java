package net.manmaed.cottonly.items;


import net.manmaed.cottonly.Cottonly;
import net.manmaed.cottonly.blocks.CBlocks;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Created by manmaed on 16/05/2021.
 */
public class CItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Cottonly.MOD_ID);

    public static final DeferredItem<Item> COTTON_SEED = ITEMS.register("cotton_seeds", () -> new CottonSeedItem(CBlocks.COTTON_PLANT.get()));
    public static final DeferredItem<Item> COTTON_BALL = ITEMS.register("cotton_ball", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> COTTON_HAT = ITEMS.register("cotton_hat", () -> new ArmorItem(ArmorMaterialCotton.COTTON, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(5))));
    public static final DeferredItem<Item> COTTON_SHIRT = ITEMS.register("cotton_shirt", () -> new ArmorItem(ArmorMaterialCotton.COTTON, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(5))));
    public static final DeferredItem<Item> COTTON_TROUSERS = ITEMS.register("cotton_trousers", () -> new ArmorItem(ArmorMaterialCotton.COTTON, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(5))));
    public static final DeferredItem<Item> COTTON_SOCKS = ITEMS.register("cotton_socks", () -> new ArmorItem(ArmorMaterialCotton.COTTON, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(5))));
}

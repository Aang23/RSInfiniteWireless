package com.aang23.rsinfinitewireless;

import com.refinedmods.refinedstorage.RS;
import com.refinedmods.refinedstorage.block.BaseBlock;
import com.refinedmods.refinedstorage.item.blockitem.BaseBlockItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RSInfiniteWirelessItems {
  public static final DeferredRegister<Item> ITEMS;
  public RSInfiniteWirelessItems() {
  }

  private static <T extends BaseBlock> RegistryObject<BlockItem> registerBlockItemFor(RegistryObject<T> block) {
    return ITEMS.register(block.getId().getPath(), () -> {
      return new BaseBlockItem(block.get(), (new Item.Properties()).group(RS.MAIN_GROUP));
    });
  }

  public static void register() {
    ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
  }

  static {
    ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "rsinfinitewireless");
    registerBlockItemFor(RSInfiniteWirelessBlocks.INFINITE_WIRELESS_TRANSMITTER);
  }
}

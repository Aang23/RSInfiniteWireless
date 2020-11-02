package com.aang23.rsinfinitewireless;

import com.aang23.rsinfinitewireless.block.InfiniteWirelessTransmitterBlock;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class RSInfiniteWirelessBlocks {
    private static final DeferredRegister<Block> BLOCKS;
    public static final RegistryObject<InfiniteWirelessTransmitterBlock> INFINITE_WIRELESS_TRANSMITTER;

    private RSInfiniteWirelessBlocks() {
    }

    public static void register() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    static {
        BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "rsinfinitewireless");
        INFINITE_WIRELESS_TRANSMITTER = BLOCKS.register("infinite_wireless_transmitter", InfiniteWirelessTransmitterBlock::new);
    }
}
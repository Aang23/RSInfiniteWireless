package com.aang23.rsinfinitewireless;

import com.aang23.rsinfinitewireless.config.ServerConfig;
import com.aang23.rsinfinitewireless.setup.ClientSetup;
import com.aang23.rsinfinitewireless.setup.CommonSetup;
import com.refinedmods.refinedstorage.api.IRSAPI;
import com.refinedmods.refinedstorage.api.RSAPIInject;
import com.refinedmods.refinedstorage.apiimpl.API;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("rsinfinitewireless")
public final class RSInfiniteWireless {
    @RSAPIInject
    public static IRSAPI RSAPI;

    public static final String ID = "rsinfinitewireless";
    public static final ServerConfig SERVER_CONFIG = new ServerConfig();

    public RSInfiniteWireless() {
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> {
            return ClientSetup::new;
        });
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG.getSpec());
        CommonSetup commonSetup = new CommonSetup();
        RSInfiniteWirelessBlocks.register();
        RSInfiniteWirelessItems.register();
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(TileEntityType.class, commonSetup::onRegisterTiles);
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(ContainerType.class, commonSetup::onRegisterContainers);
        API.deliver();
    }
}

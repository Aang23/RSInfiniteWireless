package com.aang23.rsinfinitewireless.setup;

import com.aang23.rsinfinitewireless.RSInfiniteWireless;
import com.aang23.rsinfinitewireless.RSInfiniteWirelessBlocks;
import com.aang23.rsinfinitewireless.RSInfiniteWirelessContainers;
import com.aang23.rsinfinitewireless.screen.InfiniteWirelessTransmitterScreen;
import com.refinedmods.refinedstorage.render.BakedModelOverrideRegistry;
import com.refinedmods.refinedstorage.render.ExperimentalLightingPipelineNagger;
import com.refinedmods.refinedstorage.render.model.FullbrightBakedModel;
import com.refinedmods.refinedstorage.render.resourcepack.ResourcePackListener;
import com.refinedmods.refinedstorage.screen.KeyInputListener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.resources.IReloadableResourceManager;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ClientSetup {

  private final BakedModelOverrideRegistry bakedModelOverrideRegistry = new BakedModelOverrideRegistry();

  public ClientSetup() {
    Minecraft minecraft = Minecraft.getInstance();
    if (minecraft != null) {
      IResourceManager resourceManager = minecraft.getResourceManager();
      if (resourceManager instanceof IReloadableResourceManager) {
        ((IReloadableResourceManager) resourceManager).addReloadListener(new ResourcePackListener());
      }
    }

    bakedModelOverrideRegistry.add(new ResourceLocation(RSInfiniteWireless.ID, "infinite_wireless_transmitter"), (base, registry) -> new FullbrightBakedModel(base, true, new ResourceLocation(RSInfiniteWireless.ID,"block/infinite_wireless_transmitter/cutouts/disconnected")));
    bakedModelOverrideRegistry.add(new ResourceLocation(RSInfiniteWireless.ID, "infinite_wireless_transmitter"), (base, registry) -> new FullbrightBakedModel(base, true, new ResourceLocation(RSInfiniteWireless.ID,"block/infinite_wireless_transmitter/cutouts/connected")));

    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onModelBake);
    MinecraftForge.EVENT_BUS.addListener(new ExperimentalLightingPipelineNagger()::onPlayerLoggedIn);
  }

  @SubscribeEvent
  public void onClientSetup(FMLClientSetupEvent e) {
    MinecraftForge.EVENT_BUS.register(new KeyInputListener());
    ScreenManager.registerFactory(RSInfiniteWirelessContainers.INFINITE_WIRELESS_TRANSMITTER, InfiniteWirelessTransmitterScreen::new);
    RenderTypeLookup.setRenderLayer(RSInfiniteWirelessBlocks.INFINITE_WIRELESS_TRANSMITTER.get(), RenderType.getCutout());
  }

  @SubscribeEvent
  public void onModelBake(ModelBakeEvent e) {
    for (ResourceLocation id : e.getModelRegistry().keySet()) {
      BakedModelOverrideRegistry.BakedModelOverrideFactory factory = this.bakedModelOverrideRegistry.get(new ResourceLocation(id.getNamespace(), id.getPath()));

      if (factory != null) {
        e.getModelRegistry().put(id, factory.create(e.getModelRegistry().get(id), e.getModelRegistry()));
      }
    }
  }
}

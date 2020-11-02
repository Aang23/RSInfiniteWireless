package com.aang23.rsinfinitewireless.setup;

import com.aang23.rsinfinitewireless.RSInfiniteWirelessBlocks;
import com.aang23.rsinfinitewireless.apiimpl.network.node.InfiniteWirelessTransmitterNetworkNode;
import com.aang23.rsinfinitewireless.container.InfiniteWirelessTransmitterContainer;
import com.aang23.rsinfinitewireless.tile.InfiniteWirelessTransmitterTile;
import com.refinedmods.refinedstorage.api.network.node.INetworkNode;
import com.refinedmods.refinedstorage.apiimpl.API;
import com.refinedmods.refinedstorage.apiimpl.network.node.NetworkNode;
import com.refinedmods.refinedstorage.container.factory.PositionalTileContainerFactory;
import com.refinedmods.refinedstorage.tile.BaseTile;
import com.refinedmods.refinedstorage.tile.data.TileDataManager;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonSetup {
  public CommonSetup() {
  }

  @SubscribeEvent
  public void onCommonSetup(FMLCommonSetupEvent e) {
    API.instance().getNetworkNodeRegistry().add(InfiniteWirelessTransmitterNetworkNode.ID, (tag, world, pos) -> {
      return this.readAndReturn(tag, new InfiniteWirelessTransmitterNetworkNode(world, pos));
    });
  }

  private INetworkNode readAndReturn(CompoundNBT tag, NetworkNode node) {
    node.read(tag);
    return node;
  }

  @SubscribeEvent
  public void onRegisterTiles(RegistryEvent.Register<TileEntityType<?>> e) {
    e.getRegistry().register(this.registerTileDataParameters(TileEntityType.Builder.create(InfiniteWirelessTransmitterTile::new, new Block[]{RSInfiniteWirelessBlocks.INFINITE_WIRELESS_TRANSMITTER.get()}).build(null).setRegistryName("rsinfinitewireless", "infinite_wireless_transmitter")));
  }

  private <T extends TileEntity> TileEntityType<T> registerTileDataParameters(TileEntityType<T> t) {
    BaseTile tile = (BaseTile)t.create();
    assert tile != null;
    tile.getDataManager().getParameters().forEach(TileDataManager::registerParameter);
    return t;
  }

  @SubscribeEvent
  public void onRegisterContainers(RegistryEvent.Register<ContainerType<?>> e) {
    e.getRegistry().register(IForgeContainerType.create(new PositionalTileContainerFactory<InfiniteWirelessTransmitterContainer, InfiniteWirelessTransmitterTile>((windowId, inv, tile) -> {
      return new InfiniteWirelessTransmitterContainer(tile, inv.player, windowId);
    })).setRegistryName("rsinfinitewireless", "infinite_wireless_transmitter"));
  }
}

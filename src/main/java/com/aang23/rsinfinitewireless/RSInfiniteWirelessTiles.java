package com.aang23.rsinfinitewireless;

import com.aang23.rsinfinitewireless.tile.InfiniteWirelessTransmitterTile;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("rsinfinitewireless")
public class RSInfiniteWirelessTiles {
  @ObjectHolder("infinite_wireless_transmitter")
  public static final TileEntityType<InfiniteWirelessTransmitterTile> INFINITE_WIRELESS_TRANSMITTER = null;

  private RSInfiniteWirelessTiles() {
  }
}
package com.aang23.rsinfinitewireless;

import com.aang23.rsinfinitewireless.container.InfiniteWirelessTransmitterContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(RSInfiniteWireless.ID)
public final class RSInfiniteWirelessContainers {
  @ObjectHolder("infinite_wireless_transmitter")
  public static final ContainerType<InfiniteWirelessTransmitterContainer> INFINITE_WIRELESS_TRANSMITTER = null;

  private RSInfiniteWirelessContainers() {
  }
}

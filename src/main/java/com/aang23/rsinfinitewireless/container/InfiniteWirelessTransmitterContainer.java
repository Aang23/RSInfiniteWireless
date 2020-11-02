package com.aang23.rsinfinitewireless.container;

import com.aang23.rsinfinitewireless.RSInfiniteWirelessContainers;
import com.aang23.rsinfinitewireless.tile.InfiniteWirelessTransmitterTile;
import com.refinedmods.refinedstorage.container.BaseContainer;
import net.minecraft.entity.player.PlayerEntity;

public class InfiniteWirelessTransmitterContainer extends BaseContainer {
    public InfiniteWirelessTransmitterContainer(InfiniteWirelessTransmitterTile infiniteWirelessTransmitter, PlayerEntity player, int windowId) {
        super(RSInfiniteWirelessContainers.INFINITE_WIRELESS_TRANSMITTER, infiniteWirelessTransmitter, player, windowId);

        this.addPlayerInventory(8, 50);
    }
}
package com.aang23.rsinfinitewireless.tile;

import com.aang23.rsinfinitewireless.RSInfiniteWirelessTiles;
import com.aang23.rsinfinitewireless.apiimpl.network.node.InfiniteWirelessTransmitterNetworkNode;
import com.refinedmods.refinedstorage.tile.NetworkNodeTile;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class InfiniteWirelessTransmitterTile extends NetworkNodeTile<InfiniteWirelessTransmitterNetworkNode> {
    public InfiniteWirelessTransmitterTile() {
        super(RSInfiniteWirelessTiles.INFINITE_WIRELESS_TRANSMITTER);
    }

    @Override
    @Nonnull
    public InfiniteWirelessTransmitterNetworkNode createNode(World world, BlockPos pos) {
        return new InfiniteWirelessTransmitterNetworkNode(world, pos);
    }
}
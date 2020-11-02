package com.aang23.rsinfinitewireless.apiimpl.network.node;

import com.aang23.rsinfinitewireless.RSInfiniteWireless;
import com.refinedmods.refinedstorage.api.network.IWirelessTransmitter;
import com.refinedmods.refinedstorage.apiimpl.network.node.NetworkNode;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class InfiniteWirelessTransmitterNetworkNode extends NetworkNode implements IWirelessTransmitter {
    public static final ResourceLocation ID = new ResourceLocation(RSInfiniteWireless.ID,"infinite_wireless_transmitter");

    public InfiniteWirelessTransmitterNetworkNode(World world, BlockPos pos) {
        super(world, pos);
    }

    @Override
    public int getEnergyUsage() {
        return RSInfiniteWireless.SERVER_CONFIG.getInfiniteWirelessTransmitter().getUsage();
    }

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public boolean canConduct(@Nullable Direction direction) {
        return Direction.DOWN.equals(direction);
    }

    @Override
    public void visit(Operator operator) {
        operator.apply(world, pos.offset(Direction.DOWN), Direction.UP);
    }

    @Override
    public int getRange() {
        return RSInfiniteWireless.SERVER_CONFIG.getInfiniteWirelessTransmitter().getRange();
    }

    @Override
    public BlockPos getOrigin() {
        return pos;
    }

    @Override
    public RegistryKey<World> getDimension() {
        return world.func_234923_W_();
    }
}

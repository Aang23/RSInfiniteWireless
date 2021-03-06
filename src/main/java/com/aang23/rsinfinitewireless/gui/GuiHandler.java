package com.aang23.rsinfinitewireless.gui;

import com.aang23.rsinfinitewireless.RSInfiniteWirelessGui;
import com.aang23.rsinfinitewireless.container.ContainerInfiniteWirelessTransmitter;
import com.aang23.rsinfinitewireless.tile.TileInfiniteWirelessTransmitter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {
    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
        switch (ID) {
        case RSInfiniteWirelessGui.INFINITE_WIRELESS_TRANSMITTER:
            return new ContainerInfiniteWirelessTransmitter((TileInfiniteWirelessTransmitter) tile, player);
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
        case RSInfiniteWirelessGui.INFINITE_WIRELESS_TRANSMITTER:
            return new GuiInfiniteWirelessTransmitter(
                    (ContainerInfiniteWirelessTransmitter) getServerGuiElement(ID, player, world, x, y, z));
        }
        return null;
    }
}

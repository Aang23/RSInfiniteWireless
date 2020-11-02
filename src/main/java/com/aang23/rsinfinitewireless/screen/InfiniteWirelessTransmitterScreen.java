package com.aang23.rsinfinitewireless.screen;

import com.aang23.rsinfinitewireless.RSInfiniteWireless;
import com.aang23.rsinfinitewireless.container.InfiniteWirelessTransmitterContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.refinedmods.refinedstorage.screen.BaseScreen;
import com.refinedmods.refinedstorage.screen.widget.sidebutton.RedstoneModeSideButton;
import com.refinedmods.refinedstorage.tile.NetworkNodeTile;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;

public class InfiniteWirelessTransmitterScreen extends BaseScreen<InfiniteWirelessTransmitterContainer> {
    public InfiniteWirelessTransmitterScreen(InfiniteWirelessTransmitterContainer container, PlayerInventory inventory, ITextComponent title) {
        super(container, 176, 131, inventory, title);
    }

    @Override
    public void onPostInit(int x, int y) {
        addSideButton(new RedstoneModeSideButton(this, NetworkNodeTile.REDSTONE_MODE));
    }

    public void tick(int x, int y) {
    }

    @Override
    public void renderBackground(MatrixStack matrixStack, int x, int y, int mouseX, int mouseY) {
        bindTexture(RSInfiniteWireless.ID, "gui/infinite_wireless_transmitter.png");

        blit(matrixStack, x, y, 0, 0, xSize, ySize);
    }

    @Override
    public void renderForeground(MatrixStack matrixStack, int mouseX, int mouseY) {
        renderString(matrixStack, 7, 7, title.getString());
        renderString(matrixStack, 7, 39, I18n.format("container.inventory"));
        //drawString(matrixStack, 7, 7, t("gui.rsinfinitewireless:infinite_wireless_transmitter"));
        //drawString(matrixStack, 7, 39, t("container.inventory"));
    }
}
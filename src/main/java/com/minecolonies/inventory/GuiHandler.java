package com.minecolonies.inventory;

import com.minecolonies.colony.Colony;
import com.minecolonies.colony.ColonyManager;
import com.minecolonies.colony.Field;
import com.minecolonies.tileentities.ScarecrowTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player,
                                      World world, int x, int y, int z)
    {
        BlockPos            pos        = new BlockPos(x,y,z);
        ScarecrowTileEntity tileEntity = (ScarecrowTileEntity) world.getTileEntity(pos);
        return new Field(tileEntity.inventoryField, player.inventory);
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        BlockPos            pos        = new BlockPos(x,y,z);
        ScarecrowTileEntity tileEntity = (ScarecrowTileEntity) world.getTileEntity(pos);
        return new GuiField(player.inventory, tileEntity.inventoryField);

    }
}

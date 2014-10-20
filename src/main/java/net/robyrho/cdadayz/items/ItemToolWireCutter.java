package net.robyrho.cdadayz.items;

import java.util.Set;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.robyrho.cdadayz.CdADayZ;
import net.robyrho.cdadayz.blocks.BlockBarbedWire;

import com.google.common.collect.Sets;

public class ItemToolWireCutter extends ItemTool {
	
	private static final Set set = Sets.newHashSet();
	public ItemToolWireCutter() {
		super(20, ToolMaterial.STONE, set);
	}
	
	 public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		 MovingObjectPosition block = getMovingObjectPositionFromPlayer(world, player, true);
		 if(block != null) {
			 int x = block.blockX;
			 int y = block.blockY;
			 int z = block.blockZ;
			 if(world.getBlock(x, y, z) instanceof BlockBarbedWire) {
				 world.setBlock(x, y, z, Blocks.air);
				itemstack.damageItem(5, player);
			 }
		 }
		 return itemstack;
	 }
}

package net.robyrho.cdadayz.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.robyrho.cdadayz.CdADayZ;

public class ItemSplint extends Item {
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if(CdADayZ.isLegsBroken) {
			itemstack.splitStack(1);
			CdADayZ.isLegsBroken = false;
			player.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_GREEN + "You repaired your legs!"));
			return itemstack.splitStack(--itemstack.stackSize);
		}
		return itemstack;
    }
	
	public void addInformation(ItemStack ItemStack, EntityPlayer p_77624_2_, List lore, boolean p_77624_4_) {
		lore.add("Used for repair broken legs.");
	}
}

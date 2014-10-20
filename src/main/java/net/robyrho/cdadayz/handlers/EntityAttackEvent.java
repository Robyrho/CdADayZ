package net.robyrho.cdadayz.handlers;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.robyrho.cdadayz.CdADayZ;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityAttackEvent {
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onAttacked(LivingAttackEvent e) {
		if(e.entityLiving != null && e.entityLiving instanceof EntityPlayer && e.source.getSourceOfDamage() instanceof EntityZombie) {
			final EntityPlayer p = (EntityPlayer) e.entityLiving;
			Random r = new Random();
			int i = r.nextInt(6) + 1;
			if(i == 2) {
				CdADayZ.isInfected = true;
				p.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + "A zombie infected you, find Antibiotics quickly!"));
				new Timer().scheduleAtFixedRate(new TimerTask() {
					@Override
					public void run() {
						if(CdADayZ.isInfected) {
							p.addPotionEffect(new PotionEffect(19, 144, 0));
						} else {
							this.cancel();
						}
					}
				}, 1, 5000);
			}
		}
	}
}

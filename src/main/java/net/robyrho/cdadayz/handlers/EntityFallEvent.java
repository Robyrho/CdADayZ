package net.robyrho.cdadayz.handlers;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.robyrho.cdadayz.CdADayZ;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityFallEvent {
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onFall(LivingFallEvent e) {
		if(e.entity instanceof EntityPlayer) {
			if(!CdADayZ.isLegsBroken) {
				float d = e.distance;
				final EntityPlayer p = (EntityPlayer) e.entityLiving;
				Random r = new Random();
				
				if(d > 5.5) {
					int rg = r.nextInt(6) + 1;
					if(rg == 3) {
						CdADayZ.isLegsBroken = true;
						p.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + "You broke your legs, find a Splint!"));
						Timer t = new Timer();
						t.scheduleAtFixedRate(new TimerTask() {
							@Override
							public void run() {
								if(CdADayZ.isLegsBroken) {
									p.addPotionEffect(new PotionEffect(2, 75, 3));
								} else {
									this.cancel();
								}
							}
						}, 1, 2000);
					}
				}
			}
		}	
	}
}

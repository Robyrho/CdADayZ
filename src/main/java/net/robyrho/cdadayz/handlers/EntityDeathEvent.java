package net.robyrho.cdadayz.handlers;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.robyrho.cdadayz.CdADayZ;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityDeathEvent {
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onDeath(LivingDeathEvent e) {
		if(e.entityLiving != null && e.entityLiving instanceof EntityPlayer) {
			if(CdADayZ.isLegsBroken) CdADayZ.isLegsBroken = false;
			if(CdADayZ.isInfected) CdADayZ.isInfected = false;
			if(CdADayZ.isBleeding) CdADayZ.isBleeding = false;
		}
	}
}

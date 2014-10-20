package net.robyrho.cdadayz.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.robyrho.cdadayz.CdADayZ;

public class BlockBarbedWire extends Block {

	    public BlockBarbedWire() {
	    	super(Material.iron);
	    	float f = 0.2F;
	    }
	    
	    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
	    	entity.attackEntityFrom(CdADayZ.barbedWireDamageSource, 1.0F);
	    	if(entity instanceof EntityLiving) {
	    		EntityLiving l = (EntityLiving) entity;
	    		l.addPotionEffect(new PotionEffect(2, 10, 3));
	    	} else if(entity instanceof EntityPlayer) {
	    		EntityPlayer p = (EntityPlayer) entity;
	    		p.addPotionEffect(new PotionEffect(2, 5, 3));
	    	}
	    }
	    
	    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
	    {
	        return null;
	    }
	    
	    public boolean isOpaqueCube()
	    {
	        return false;
	    }
	    
	    public boolean renderAsNormalBlock()
	    {
	        return false;
	    }
	    
	    public int getRenderType()
	    {
	        return 1;
	    }
}

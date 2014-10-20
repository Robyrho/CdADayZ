package net.robyrho.cdadayz;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.robyrho.cdadayz.blocks.BlockBarbedWire;
import net.robyrho.cdadayz.handlers.EntityAttackEvent;
import net.robyrho.cdadayz.handlers.EntityDeathEvent;
import net.robyrho.cdadayz.handlers.EntityFallEvent;
import net.robyrho.cdadayz.items.ItemAntibiotics;
import net.robyrho.cdadayz.items.ItemBandage;
import net.robyrho.cdadayz.items.ItemSplint;
import net.robyrho.cdadayz.items.ItemToolWireCutter;
import net.robyrho.cdadayz.registers.CommonProxy;
import net.robyrho.cdadayz.utils.BarbedWireDamageSource;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = CdADayZ.MODID, version = CdADayZ.VERSION)
public class CdADayZ
{
    public static final String MODID = "cdadayz";
    public static final String VERSION = "1.0";
    
    public static boolean isBleeding = false;
    public static boolean isLegsBroken = false;
    public static boolean isInfected = false;
    
    //Proxies
    @SidedProxy(clientSide="net.robyrho.cdadayz.registers.ClientProxy", serverSide="net.robyrho.cdadayz.registers.CommonProxy")
    public static CommonProxy proxy;
    
    //CreativeTab
    public static CreativeTabs dayzTab = new CreativeTabs("cdadayztab") {
		@Override
		public Item getTabIconItem() {
			return itemBandage;
		}
    	
    };
    
    public static DamageSource barbedWireDamageSource;
    
    //Items
    public static Item itemBandage;
    public static Item itemSplint;
    public static Item itemAntibiotics;
    public static Item itemWireCutter;
    
    //Blocks
    public static Block blockBarbedWire;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	initializeItemsAndBlocks();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent e) {
		registerItemsAndBlocks();
		
		MinecraftForge.EVENT_BUS.register(new EntityFallEvent());
		MinecraftForge.EVENT_BUS.register(new EntityAttackEvent());
		MinecraftForge.EVENT_BUS.register(new EntityDeathEvent());
    }
   
	private void initializeItemsAndBlocks() {
		barbedWireDamageSource = new BarbedWireDamageSource();
		
		//Items
    	itemBandage = new ItemBandage().setUnlocalizedName("bandage").setCreativeTab(dayzTab).setTextureName(MODID + ":bandage");
    	itemSplint = new ItemSplint().setUnlocalizedName("splint").setCreativeTab(dayzTab).setTextureName(MODID + ":splint");
    	itemAntibiotics = new ItemAntibiotics().setUnlocalizedName("antibiotics").setCreativeTab(dayzTab).setTextureName(MODID + ":antibiotics");
    	itemWireCutter = new ItemToolWireCutter().setUnlocalizedName("wirecutter").setCreativeTab(dayzTab).setMaxStackSize(1).setTextureName(MODID + ":wirecutter");
    	
    	//Blocks
    	blockBarbedWire = new BlockBarbedWire().setBlockUnbreakable().setBlockName("barbed_wire").setCreativeTab(dayzTab).setBlockTextureName(MODID + ":barbed_wire");
    }
	 
    private void registerItemsAndBlocks() {
    	
    	//Items
    	GameRegistry.registerItem(itemBandage, itemBandage.getUnlocalizedName());
    	GameRegistry.registerItem(itemSplint, itemSplint.getUnlocalizedName());
    	GameRegistry.registerItem(itemAntibiotics, itemAntibiotics.getUnlocalizedName());
    	GameRegistry.registerItem(itemWireCutter, itemWireCutter.getUnlocalizedName());
    	
    	//Blocks
    	GameRegistry.registerBlock(blockBarbedWire, blockBarbedWire.getUnlocalizedName());
	}
}

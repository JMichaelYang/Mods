package com.jgames.bigguns.common;

import com.jgames.bigguns.guns.GunType;
import com.jgames.bigguns.guns.GunType.GunClass;
import com.jgames.bigguns.guns.ItemGun;
import com.jgames.bigguns.minecraft.EventHook;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = BigGuns.MODID, name = "Big Guns", version = BigGuns.VERSION)
public class BigGuns
{
    public static final String MODID = "bigguns";
    public static final String VERSION = "0.0.1";
    
    @SidedProxy(clientSide = "com.jgames.bigguns.minecraft.ClientProxy", serverSide = "com.jgames.bigguns.common.CommonProxy")
    public static CommonProxy PROXY = new CommonProxy();
    
    public static final CreativeTabs TAB = new CreativeTab(CreativeTabs.getNextID(), "Big Guns");
    public static final NetworkHelper NETWORK_HELPER = new NetworkHelper("bigguns", PacketHandler.class);
    
    //assault
    public static ItemGun j16 = new ItemGun(new GunType(
    		"J16", GunClass.assault,
    		true, 3, 3
    		));
    
    @EventHandler
	public void preInitialization(FMLPreInitializationEvent event)
	{
    	BigGuns.PROXY.addRenders();
    	FMLCommonHandler.instance().bus().register(new EventHook());
    	MinecraftForge.EVENT_BUS.register(new EventHook());
	}
    
    @EventHandler
	public void initialization(FMLInitializationEvent event)
	{
    	
	}
}
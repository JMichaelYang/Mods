package com.jgames.bigguns.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
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
    
    @EventHandler
	public void preInitialization(FMLPreInitializationEvent event)
	{
    	BigGuns.PROXY.addRenders();
	}
    
    @EventHandler
	public void initialization(FMLInitializationEvent event)
	{
    	
	}
}
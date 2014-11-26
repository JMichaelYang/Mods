package com.jgames.skiing.minecraft;

import net.minecraft.client.Minecraft;

import com.jgames.bigguns.data.Settings;
import com.jgames.skiing.common.CommonProxy;
import com.jgames.skiing.skis.EntitySkis;
import com.jgames.skiing.skis.RenderSkis;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerKeys()
	{
		KeyBindings.init();
	}
	
	@Override
	public void addRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntitySkis.class, new RenderSkis());
	}
	
	@Override
	public void renderHitMarker()
	{
		
	}
	
	@Override
	public void renderSight()
	{
		
	}
}

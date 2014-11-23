package com.jgames.bigguns.minecraft;

import com.jgames.bigguns.common.BigGuns;
import com.jgames.bigguns.data.Settings;
import com.jgames.bigguns.guns.ItemGun;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class EventHook
{
	@SubscribeEvent
	public void onBreak(BreakEvent event)
	{
		EntityPlayer entityPlayer = event.getPlayer();
		if (entityPlayer != null && !(entityPlayer instanceof FakePlayer))
		{
			ItemStack itemStack = entityPlayer.getCurrentEquippedItem();
			
			if (itemStack != null && itemStack.getItem() instanceof ItemGun)
			{
				event.setCanceled(true);
			}
		}
	}

	@SubscribeEvent
	public void onTick(TickEvent event)
	{
		if (event.type == TickEvent.Type.CLIENT && event.phase == TickEvent.Phase.START)
		{
			if (Settings.shootTime > 0)
			{
				Settings.shootTime --;
			}
		}
		else if (event.type == TickEvent.Type.RENDER && event.phase == TickEvent.Phase.END)
		{
			BigGuns.PROXY.renderHitMarker();
			BigGuns.PROXY.renderSight();
		}
	}
}
package com.jgames.bigguns.guns;

import org.lwjgl.input.Mouse;

import com.jgames.bigguns.common.BigGuns;
import com.jgames.bigguns.data.Settings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGun extends Item
{
	public GunType gunType;
	
	public ItemGun(GunType type)
	{
		super();
		this.setMaxStackSize(1);
		this.setCreativeTab(BigGuns.TAB);
		this.gunType = type;
		
		GameRegistry.registerItem(this, this.gunType.name);
	}
	
	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int inventoryIndex, boolean flag)
	{
		if(world.isRemote && !Mouse.isButtonDown(1))
		{
			Settings.hasShot = false;
		}
	}
	
	@Override
	public float getDigSpeed(ItemStack itemstack, Block block, int metadata)
	{
		return 0;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public String getItemStackDisplayName(ItemStack itemStack)
	{
		return this.gunType.name;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon("bigguns:" + this.gunType.name);
	}
}
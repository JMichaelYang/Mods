package com.jgames.bigguns.common;

import com.jgames.bigguns.common.NetworkHelper.IPacket;
import com.jgames.bigguns.data.Settings;
import com.jgames.bigguns.guns.ItemGun;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class PacketHandler implements IPacket
{
	private String username;
	private int packetType;

	public PacketHandler()
	{
		
	}

	public PacketHandler(String username, int packetType)
	{
		this.username = username;
		this.packetType = packetType;
	}

	@Override
	public void writeBytes(ChannelHandlerContext channelHandlerContext, ByteBuf data)
	{
		data.writeShort(this.username.length());
		for (char character : this.username.toCharArray())
		{
			data.writeChar(character);
		}
		data.writeByte(this.packetType);
	}

	@Override
	public void readBytes(ChannelHandlerContext channelHandlerContext, ByteBuf data)
	{
		short length = data.readShort();
		char[] characters = new char[length];
		for (int i = 0; i < length; i ++)
		{
			characters[i] = data.readChar();
		}
		
		this.username = String.valueOf(characters);
		this.packetType = data.readByte();
		
		if (this.packetType == 1)
		{
			EntityPlayer entityPlayer = MinecraftServer.getServer().getConfigurationManager().func_152612_a(this.username);
			InventoryPlayer inventory = entityPlayer.inventory;
			World world = entityPlayer.worldObj;
			int color = inventory.getCurrentItem().getItemDamage();
			
			if (inventory.getCurrentItem() != null && inventory.getCurrentItem().getItem() instanceof ItemGun)
			{
				ItemGun gun = (ItemGun) inventory.getCurrentItem().getItem();
				//ItemStack pelletItemStack = new ItemStack(Paintball.pellet, 1, color);
				
				//if (gun.type != "Launcher" && inventory.hasItemStack(pelletItemStack))
				//{
					//if (!entityPlayer.capabilities.isCreativeMode)
					//{
					//	Paintball.consumeInventoryItemStack(inventory, pelletItemStack, 1);
					//}
					//world.playSoundAtEntity(entityPlayer, Paintball.GUN_SHOOT, 1.0F, 1.0F / (world.rand.nextFloat() * 0.4F + 0.8F));
					//for (int i = 0; i < (gun.type != "Shotgun" ? 1 : 6); i ++)
					//{
						System.out.println("Shot");
						//world.spawnEntityInWorld(new EntityPellet(world, entityPlayer, gun.damage, gun.distance, color));
					//}
				//}
			}
		}
		else if (this.packetType == 2)
		{
			Settings.hitMarker = 6;
		}
	}
}
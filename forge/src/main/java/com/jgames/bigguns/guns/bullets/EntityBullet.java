package com.jgames.bigguns.guns.bullets;

import java.util.Random;

import com.jgames.bigguns.guns.GunType;

import cpw.mods.fml.common.registry.IThrowableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityBullet extends Entity
{
	private static int bulletLife = 800;
	private int ticksAlive = 0;
	
	public GunType Type;
	public Entity Owner;
	public static Random random = new Random();
	public Entity LockedEntity;

	public EntityBullet(World world) 
	{
		super(world);
		this.ticksAlive = 0;
		this.renderDistanceWeight = 10d;
		this.setSize(0.5f, 0.5f);
	}
	
	private EntityBullet(World world, EntityLivingBase shooter, GunType type)
	{
		this(world);
		
		this.Owner = shooter;
		this.Type = type;
		
		this.setLocationAndAngles(shooter.posX, shooter.posY + shooter.getEyeHeight(), shooter.posZ, shooter.rotationYaw, shooter.rotationPitch);
		this.posX -= (double)(MathHelper.cos(this.rotationYaw / 180.0f * (float)Math.PI) * 0.16f);
        this.posY -= 0.1d;
        this.posZ -= (double)(MathHelper.sin(this.rotationYaw / 180.0f * (float)Math.PI) * 0.16f);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0;
        this.motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0f * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0f * (float)Math.PI));
        this.motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0f * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0f * (float)Math.PI));
        this.motionY = (double)(-MathHelper.sin(this.rotationPitch / 180.0f * (float)Math.PI));
        
        this.setBulletHeading(this.motionX, this.motionY, this.motionZ);
	}
	
	public void setBulletHeading(double motionX, double motionY, double motionZ)
	{
		float totalSpeed = MathHelper.sqrt_double((motionX * motionX) + (motionY * motionY) + (motionZ * motionZ));
		
		motionX /= totalSpeed;
		motionY /= totalSpeed;
		motionZ /= totalSpeed;
		
		motionX *= this.Type.bulletSpeed;
		motionY *= this.Type.bulletSpeed;
		motionZ *= this.Type.bulletSpeed;
		
		motionX += this.random.nextGaussian() * 0.005D * this.Type.accuracy * this.Type.bulletSpeed;
		motionY += this.random.nextGaussian() * 0.005D * this.Type.accuracy * this.Type.bulletSpeed;
		motionZ += this.random.nextGaussian() * 0.005D * this.Type.accuracy * this.Type.bulletSpeed;
		
		this.motionX = motionX;
		this.motionY = motionY;
		this.motionZ = motionZ;
		
		float horizontalSpeed = MathHelper.sqrt_double((motionX * motionX) + (motionZ * motionZ));
		this.prevRotationYaw = this.rotationYaw = (float) ((Math.atan2(motionX, motionY) * 180d) / Math.PI);
		this.prevRotationPitch = this.rotationPitch = (float) ((Math.atan2(motionX, horizontalSpeed) * 180d) / Math.PI);
	}
	
	@Override
	public void setVelocity(double d, double d1, double d2)
	{
		this.motionX = d;
		this.motionY = d1;
		this.motionZ = d2;
		
		if (this.prevRotationPitch == 0f && this.prevRotationYaw == 0f)
		{
			float f = MathHelper.sqrt_double(d * d + d2 * d2);
			this.prevRotationYaw = rotationYaw = (float) ((Math.atan2(d, d2) * 180d) / Math.PI);
			this.prevRotationPitch = rotationPitch = (float) ((Math.atan2(d1, f) * 180d) / Math.PI);
			this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
		}
	}

	@Override
	protected void entityInit() 
	{
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound p_70037_1_) 
	{
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound p_70014_1_) 
	{
		
	}

}

package com.jgames.skiing.skis;

import org.lwjgl.opengl.GL11;

import com.jgames.skiing.models.ModelSkis;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class RenderSkis extends Render
{
	protected ModelBase modelSkis;
	
	public RenderSkis()
	{
		this.shadowSize = 0f;
		this.modelSkis = new ModelSkis();
	}
	
	@Override
	public void doRender(Entity entity, double x, double y, double z, float r1, float r2) 
	{/*
		System.out.println(entity);
		System.out.println((EntitySkis)entity);
		System.out.println(((EntitySkis)entity).type);
		System.out.println(((EntitySkis)entity).getType());
		System.out.println(((EntitySkis)entity).getType().name);
		System.out.println("textures/entities/Skis" + ((EntitySkis)entity).getType().name + ".png");*/
		this.render((EntitySkis)entity, x, y, z, r1, r2);
	}
	
	public void render(EntitySkis p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
	{
		GL11.glPushMatrix();
        GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
        GL11.glRotatef(90.0F - p_76986_8_, 0.0F, 1.0F, 0.0F);
        float f2 = (float)p_76986_1_.getTimeSinceHit() - p_76986_9_;
        float f3 = p_76986_1_.getDamageTaken() - p_76986_9_;

        if (f3 < 0.0F)
        {
            f3 = 0.0F;
        }

        if (f2 > 0.0F)
        {
            GL11.glRotatef(MathHelper.sin(f2) * f2 * f3 / 10.0F * (float)p_76986_1_.getForwardDirection(), 1.0F, 0.0F, 0.0F);
        }

        float f4 = 0.75F;
        GL11.glScalef(f4, f4, f4);
        GL11.glScalef(1.0F / f4, 1.0F / f4, 1.0F / f4);
        this.bindEntityTexture(p_76986_1_);
        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        this.modelSkis.render(p_76986_1_, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return new ResourceLocation("skimod", "textures/entities/Skis" + ((EntitySkis)entity).getType().name + ".png");
	}
}

package com.jgames.skiing.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSkis extends ModelBase 
{
	ModelRenderer SkiBase1;
	ModelRenderer SkiBase2;
	ModelRenderer SkiTip1;
	ModelRenderer SkiTip2;

	public ModelSkis() 
	{
		textureWidth = 128;
		textureHeight = 64;

		SkiBase1 = new ModelRenderer(this, 0, 0);
		SkiBase1.addBox(0F, 0F, 0F, 3, 1, 38);
		SkiBase1.setRotationPoint(2F, 23F, -18F);
		SkiBase1.setTextureSize(128, 64);
		SkiBase1.mirror = true;
		setRotation(SkiBase1, 0F, 0F, 0F);
		SkiBase2 = new ModelRenderer(this, 0, 0);
		SkiBase2.addBox(0F, 0F, 0F, 3, 1, 38);
		SkiBase2.setRotationPoint(-5F, 23F, -18F);
		SkiBase2.setTextureSize(128, 64);
		SkiBase2.mirror = true;
		setRotation(SkiBase2, 0F, 0F, 0F);
		SkiTip1 = new ModelRenderer(this, 0, 0);
		SkiTip1.addBox(0F, 0F, 0F, 3, 1, 4);
		SkiTip1.setRotationPoint(2F, 21F, -21F);
		SkiTip1.setTextureSize(128, 64);
		SkiTip1.mirror = true;
		setRotation(SkiTip1, -0.5235988F, 0F, 0F);
		SkiTip2 = new ModelRenderer(this, 0, 0);
		SkiTip2.addBox(0F, 0F, 0F, 3, 1, 4);
		SkiTip2.setRotationPoint(-5F, 21F, -21F);
		SkiTip2.setTextureSize(128, 64);
		SkiTip2.mirror = true;
		setRotation(SkiTip2, -0.5235988F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		SkiBase1.render(f5);
		SkiBase2.render(f5);
		SkiTip1.render(f5);
		SkiTip2.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) 
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) 
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}

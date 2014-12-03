package com.jgames.skiing.skis;

import java.util.ArrayList;

public class TypeSkis 
{
	public String name;
	
	public double maxSpeed;
	public double breakSpeed;
	public float rotationSpeed;
	public boolean twinTips;
	
	public static ArrayList<TypeSkis> skis = new ArrayList<TypeSkis>();
	
	public TypeSkis(String name,
			double breakSpeed, double maxSpeed, float rotationSpeed, boolean twinTips)
	{
		this.name = name;
		
		this.breakSpeed = breakSpeed;
		this.maxSpeed = maxSpeed;
		this.rotationSpeed = rotationSpeed;
		this.twinTips = twinTips;
		
		TypeSkis.skis.add(this);
	}
	
	public static TypeSkis getType(String name)
	{
		for(TypeSkis type : TypeSkis.skis)
		{
			if(type.name.equals(name))
			{
				return type;
			}
		}
		
		return null;
	}
	
	public static TypeSkis wood = new TypeSkis("Wood",
		0.2d, 0.35d, 20f, false);
}
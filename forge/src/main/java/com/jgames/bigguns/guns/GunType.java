package com.jgames.bigguns.guns;

import java.util.ArrayList;

public class GunType 
{
	public enum GunClass
	{
		assault,
		smg,
		sniper,
		shotgun,
		pistol,
		special
	}
	
	public String name;
	public GunClass gunClass;
	
	public boolean fullAuto;
	public int damage;
	public int rof;
	
	public float accuracy;
	public float bulletSpeed;
	
	public ArrayList<GunType> guns = new ArrayList<GunType>();
	
	public GunType(String name, GunClass gunClass,
			boolean fullAuto, int damage, int rof)
	{
		this.name = name;
		this.gunClass = gunClass;
		
		this.fullAuto = fullAuto;
		this.damage = damage;
		this.rof = rof;
	}
}

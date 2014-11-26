package com.jgames.skiing.minecraft;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;

public class KeyBindings 
{
	public static KeyBinding leftKey;
	public static KeyBinding rightKey;
	public static KeyBinding upKey;
	public static KeyBinding downKey;
	
	public static void init()
	{
		KeyBindings.leftKey = new KeyBinding("key.leftKey", Keyboard.KEY_LEFT, "key.categories.skiing");
		ClientRegistry.registerKeyBinding(KeyBindings.leftKey);
		KeyBindings.rightKey = new KeyBinding("key.rightKey", Keyboard.KEY_RIGHT, "key.categories.skiing");
		ClientRegistry.registerKeyBinding(KeyBindings.rightKey);
		KeyBindings.upKey = new KeyBinding("key.upKey", Keyboard.KEY_UP, "key.categories.skiing");
		ClientRegistry.registerKeyBinding(KeyBindings.upKey);
		KeyBindings.downKey = new KeyBinding("key.downKey", Keyboard.KEY_DOWN, "key.categories.skiing");
		ClientRegistry.registerKeyBinding(KeyBindings.downKey);
	}
}

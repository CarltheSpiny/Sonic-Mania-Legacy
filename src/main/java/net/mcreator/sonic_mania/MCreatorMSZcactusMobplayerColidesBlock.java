package net.mcreator.sonic_mania;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

@Elementssonic_mania.ModElement.Tag
public class MCreatorMSZcactusMobplayerColidesBlock extends Elementssonic_mania.ModElement {
	public MCreatorMSZcactusMobplayerColidesBlock(Elementssonic_mania instance) {
		super(instance, 240);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorMSZcactusMobplayerColidesBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
	}
}

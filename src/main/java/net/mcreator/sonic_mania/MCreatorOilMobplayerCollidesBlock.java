package net.mcreator.sonic_mania;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

@Elementssonic_mania.ModElement.Tag
public class MCreatorOilMobplayerCollidesBlock extends Elementssonic_mania.ModElement {
	public MCreatorOilMobplayerCollidesBlock(Elementssonic_mania instance) {
		super(instance, 233);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorOilMobplayerCollidesBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 3, (int) 3));
	}
}

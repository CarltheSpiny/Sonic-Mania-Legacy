package net.mcreator.sonic_mania;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;

@Elementssonic_mania.ModElement.Tag
public class MCreatorMirageSaloonAct1knuxRightClicked extends Elementssonic_mania.ModElement {
	public MCreatorMirageSaloonAct1knuxRightClicked(Elementssonic_mania instance) {
		super(instance, 233);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorMirageSaloonAct1knuxRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorMirageSaloonAct1knuxRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorMirageSaloonAct1knuxRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorMirageSaloonAct1knuxRightClicked!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		world.playSound((PlayerEntity) null, x, y, z, (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(
				"sonic_mania:mirage_saloon_zone_act_1_knuckles")), SoundCategory.NEUTRAL, (float) 1, (float) 1);
	}
}

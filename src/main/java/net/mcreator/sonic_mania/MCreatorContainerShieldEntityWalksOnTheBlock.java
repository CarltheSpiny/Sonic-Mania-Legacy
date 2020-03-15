package net.mcreator.sonic_mania;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

@Elementssonic_mania.ModElement.Tag
public class MCreatorContainerShieldEntityWalksOnTheBlock extends Elementssonic_mania.ModElement {
	public MCreatorContainerShieldEntityWalksOnTheBlock(Elementssonic_mania instance) {
		super(instance, 267);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorContainerShieldEntityWalksOnTheBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorContainerShieldEntityWalksOnTheBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorContainerShieldEntityWalksOnTheBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorContainerShieldEntityWalksOnTheBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorContainerShieldEntityWalksOnTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
		world.playSound((PlayerEntity) null, x, y, z,
				(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("sonic_mania:destroy")),
				SoundCategory.NEUTRAL, (float) 2, (float) 1);
		if (entity instanceof PlayerEntity)
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), new ItemStack(MCreatorSheild.body, (int) (1)));
	}
}
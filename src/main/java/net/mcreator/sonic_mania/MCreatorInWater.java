package net.mcreator.sonic_mania;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.Difficulty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.block.Blocks;

@Elementssonic_mania.ModElement.Tag
public class MCreatorInWater extends Elementssonic_mania.ModElement {
	public MCreatorInWater(Elementssonic_mania instance) {
		super(instance, 221);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorInWater!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorInWater!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorInWater!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorInWater!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorInWater!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double CurrentX = 0;
		double CurrentY = 0;
		double CurrentZ = 0;
		boolean isSoundactive = false;
		CurrentX = (double) x;
		CurrentY = (double) y;
		CurrentZ = (double) z;
		if (((isSoundactive) == (false))) {
			if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) < 20) && ((entity instanceof PlayerEntity) && (((world
					.getBlockState(new BlockPos((int) (CurrentX), (int) ((CurrentY) - 1), (int) (CurrentZ)))).getBlock() == Blocks.WATER
					.getDefaultState().getBlock()) || ((world.getBlockState(new BlockPos((int) (CurrentX), (int) ((CurrentY) + 1), (int) (CurrentZ))))
					.getBlock() == Blocks.WATER.getDefaultState().getBlock()))))) {
				if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) < 10) && ((((EnchantmentHelper
						.getEnchantmentLevel(Enchantments.RESPIRATION, ((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.armorInventory.get(0)
								: ItemStack.EMPTY))) >= 0) || ((EnchantmentHelper.getEnchantmentLevel(Enchantments.RESPIRATION,
						((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(1) : ItemStack.EMPTY))) >= 0)) || (((EnchantmentHelper
						.getEnchantmentLevel(Enchantments.RESPIRATION, ((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.armorInventory.get(2)
								: ItemStack.EMPTY))) >= 0) || ((EnchantmentHelper.getEnchantmentLevel(Enchantments.RESPIRATION,
						((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(3) : ItemStack.EMPTY))) >= 0))))) {
					world.playSound((PlayerEntity) null, (CurrentX), (CurrentY), (CurrentZ),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("sonic_mania:drown")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
					isSoundactive = (boolean) (true);
				} else if (((world.getDifficulty() == Difficulty.PEACEFUL) && (((entity instanceof LivingEntity) ? ((LivingEntity) entity)
						.getHealth() : -1) < 10))) {
					world.playSound((PlayerEntity) null, (CurrentX), (CurrentY), (CurrentZ),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("sonic_mania:drown")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
					isSoundactive = (boolean) (true);
				}
			}
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) == 0)) {
				isSoundactive = (boolean) (false);
			}
		}
	}
}

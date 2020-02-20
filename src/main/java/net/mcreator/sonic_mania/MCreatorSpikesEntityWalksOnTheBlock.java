package net.mcreator.sonic_mania;

import net.minecraft.world.World;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Collection;

@Elementssonic_mania.ModElement.Tag
public class MCreatorSpikesEntityWalksOnTheBlock extends Elementssonic_mania.ModElement {
	public MCreatorSpikesEntityWalksOnTheBlock(Elementssonic_mania instance) {
		super(instance, 211);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorSpikesEntityWalksOnTheBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorSpikesEntityWalksOnTheBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorSpikesEntityWalksOnTheBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorSpikesEntityWalksOnTheBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorSpikesEntityWalksOnTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((new Object() {
			boolean check() {
				if (entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == Effects.RESISTANCE)
							return true;
					}
				}
				return false;
			}
		}.check()) || ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory
				.hasItemStack(new ItemStack(MCreatorRing.block, (int) (1))) : false))) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 2);
			if (((entity instanceof PlayerEntity)
					? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(MCreatorRing.block, (int) (1)))
					: false)) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(MCreatorRing.block, (int) (1)).getItem() == p.getItem(),
							(int) 1);
				if (!world.isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorRing.block, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 30, (int) 1));
			}
		} else if ((((new Object() {
			boolean check() {
				if (entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == Effects.RESISTANCE)
							return true;
					}
				}
				return false;
			}
		}.check()) || ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory
				.hasItemStack(new ItemStack(MCreatorRing.block, (int) (1))) : false)) == (false))) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 40);
		}
	}
}

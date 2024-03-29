package net.mcreator.sonic_mania;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

@Elementssonic_mania.ModElement.Tag
public class MCreatorMirageDeluxe extends Elementssonic_mania.ModElement {
	@ObjectHolder("sonic_mania:miragedeluxe")
	public static final Item block = null;

	public MCreatorMirageDeluxe(Elementssonic_mania instance) {
		super(instance, 293);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).food((new Food.Builder()).hunger(4).saturation(0.5f).build()));
			setRegistryName("miragedeluxe");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 25;
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemStack, world, entity);
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				MCreatorMirageDeluxeFoodEaten.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}

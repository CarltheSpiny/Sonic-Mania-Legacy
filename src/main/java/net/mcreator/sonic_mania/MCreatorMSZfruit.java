package net.mcreator.sonic_mania;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

@Elementssonic_mania.ModElement.Tag
public class MCreatorMSZfruit extends Elementssonic_mania.ModElement {
	@ObjectHolder("sonic_mania:mszfruit")
	public static final Item block = null;

	public MCreatorMSZfruit(Elementssonic_mania instance) {
		super(instance, 163);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(MCreatorItems.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(3).saturation(0.300000011920929f).setAlwaysEdible().build()));
			setRegistryName("mszfruit");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}
	}
}

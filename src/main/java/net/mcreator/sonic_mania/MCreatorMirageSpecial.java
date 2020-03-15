package net.mcreator.sonic_mania;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

@Elementssonic_mania.ModElement.Tag
public class MCreatorMirageSpecial extends Elementssonic_mania.ModElement {
	@ObjectHolder("sonic_mania:miragespecial")
	public static final Item block = null;

	public MCreatorMirageSpecial(Elementssonic_mania instance) {
		super(instance, 292);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).food((new Food.Builder()).hunger(5).saturation(0.8f).build()));
			setRegistryName("miragespecial");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 25;
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.DRINK;
		}
	}
}

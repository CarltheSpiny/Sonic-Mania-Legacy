package net.mcreator.sonic_mania;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@Elementssonic_mania.ModElement.Tag
public class MCreatorGreenTimeStone extends Elementssonic_mania.ModElement {
	@ObjectHolder("sonic_mania:greentimestone")
	public static final Item block = null;

	public MCreatorGreenTimeStone(Elementssonic_mania instance) {
		super(instance, 183);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(MCreatorItems.tab).maxStackSize(1));
			setRegistryName("greentimestone");
		}

		@Override
		public boolean hasContainerItem() {
			return true;
		}

		@Override
		public ItemStack getContainerItem(ItemStack itemStack) {
			return new ItemStack(this);
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}

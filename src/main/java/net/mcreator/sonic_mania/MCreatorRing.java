package net.mcreator.sonic_mania;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@Elementssonic_mania.ModElement.Tag
public class MCreatorRing extends Elementssonic_mania.ModElement {
	@ObjectHolder("sonic_mania:ring")
	public static final Item block = null;

	public MCreatorRing(Elementssonic_mania instance) {
		super(instance, 174);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(MCreatorItems.tab).maxStackSize(64));
			setRegistryName("ring");
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

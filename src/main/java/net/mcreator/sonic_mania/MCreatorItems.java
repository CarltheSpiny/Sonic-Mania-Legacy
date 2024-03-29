package net.mcreator.sonic_mania;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@Elementssonic_mania.ModElement.Tag
public class MCreatorItems extends Elementssonic_mania.ModElement {
	public MCreatorItems(Elementssonic_mania instance) {
		super(instance, 234);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabitems") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MCreatorItemsTabIcon.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}

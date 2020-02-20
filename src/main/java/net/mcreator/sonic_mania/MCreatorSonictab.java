package net.mcreator.sonic_mania;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@Elementssonic_mania.ModElement.Tag
public class MCreatorSonictab extends Elementssonic_mania.ModElement {
	public MCreatorSonictab(Elementssonic_mania instance) {
		super(instance, 187);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabsonictab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MCreatorSonicIcon.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}

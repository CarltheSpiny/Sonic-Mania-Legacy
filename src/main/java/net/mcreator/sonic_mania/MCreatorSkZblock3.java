package net.mcreator.sonic_mania;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockItem;
import net.minecraft.fluid.IFluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.WallBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.List;
import java.util.Collections;

@Elementssonic_mania.ModElement.Tag
public class MCreatorSkZblock3 extends Elementssonic_mania.ModElement {
	@ObjectHolder("sonic_mania:skzblock3")
	public static final Block block = null;

	public MCreatorSkZblock3(Elementssonic_mania instance) {
		super(instance, 152);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(MCreatorSonictab.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends WallBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1f, 10f).lightValue(0).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE));
			setRegistryName("skzblock3");
		}

		private boolean func_220113_a(BlockState state, boolean checkattach, Direction face) {
			boolean flag = state.getBlock() instanceof WallBlock || state.getBlock() instanceof FenceGateBlock
					&& FenceGateBlock.isParallel(state, face);
			return !cannotAttach(state.getBlock()) && checkattach || flag;
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			IWorldReader iworldreader = context.getWorld();
			BlockPos blockpos = context.getPos();
			IFluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
			BlockPos blockpos1 = blockpos.north();
			BlockPos blockpos2 = blockpos.east();
			BlockPos blockpos3 = blockpos.south();
			BlockPos blockpos4 = blockpos.west();
			BlockState blockstate = iworldreader.getBlockState(blockpos1);
			BlockState blockstate1 = iworldreader.getBlockState(blockpos2);
			BlockState blockstate2 = iworldreader.getBlockState(blockpos3);
			BlockState blockstate3 = iworldreader.getBlockState(blockpos4);
			boolean flag = this.func_220113_a(blockstate, blockstate.func_224755_d(iworldreader, blockpos1, Direction.SOUTH), Direction.SOUTH);
			boolean flag1 = this.func_220113_a(blockstate1, blockstate1.func_224755_d(iworldreader, blockpos2, Direction.WEST), Direction.WEST);
			boolean flag2 = this.func_220113_a(blockstate2, blockstate2.func_224755_d(iworldreader, blockpos3, Direction.NORTH), Direction.NORTH);
			boolean flag3 = this.func_220113_a(blockstate3, blockstate3.func_224755_d(iworldreader, blockpos4, Direction.EAST), Direction.EAST);
			boolean flag4 = (!flag || flag1 || !flag2 || flag3) && (flag || !flag1 || flag2 || !flag3);
			return this.getDefaultState().with(UP, Boolean.valueOf(flag4 || !iworldreader.isAirBlock(blockpos.up())))
					.with(NORTH, Boolean.valueOf(flag)).with(EAST, Boolean.valueOf(flag1)).with(SOUTH, Boolean.valueOf(flag2))
					.with(WEST, Boolean.valueOf(flag3)).with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
		}

		@Override
		/** 
		 * Update the provided state given the provided neighbor facing and neighbor state, returning a new state. For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately returns its solidified counterpart. Note that this method should ideally consider only the specific face passed in.
		 */
		public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos,
				BlockPos facingPos) {
			if (stateIn.get(WATERLOGGED)) {
				worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
			}
			if (facing == Direction.DOWN) {
				return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
			} else {
				Direction direction = facing.getOpposite();
				boolean flag = facing == Direction.NORTH ? this.func_220113_a(facingState, facingState.func_224755_d(worldIn, facingPos, direction),
						direction) : stateIn.get(NORTH);
				boolean flag1 = facing == Direction.EAST ? this.func_220113_a(facingState, facingState.func_224755_d(worldIn, facingPos, direction),
						direction) : stateIn.get(EAST);
				boolean flag2 = facing == Direction.SOUTH ? this.func_220113_a(facingState, facingState.func_224755_d(worldIn, facingPos, direction),
						direction) : stateIn.get(SOUTH);
				boolean flag3 = facing == Direction.WEST ? this.func_220113_a(facingState, facingState.func_224755_d(worldIn, facingPos, direction),
						direction) : stateIn.get(WEST);
				boolean flag4 = (!flag || flag1 || !flag2 || flag3) && (flag || !flag1 || flag2 || !flag3);
				return stateIn.with(UP, Boolean.valueOf(flag4 || !worldIn.isAirBlock(currentPos.up()))).with(NORTH, Boolean.valueOf(flag))
						.with(EAST, Boolean.valueOf(flag1)).with(SOUTH, Boolean.valueOf(flag2)).with(WEST, Boolean.valueOf(flag3));
			}
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public BlockRenderLayer getRenderLayer() {
			return BlockRenderLayer.CUTOUT;
		}

		@Override
		public MaterialColor getMaterialColor(BlockState state, IBlockReader blockAccess, BlockPos pos) {
			return MaterialColor.QUARTZ;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}

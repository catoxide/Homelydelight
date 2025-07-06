package com.catoxide.homelydelight;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SoyBeanBlock extends CropBlock
{
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
			Block.box(1.0D, 0.0D, 1.0D, 15.0D, 5.0D, 15.0D),
			Block.box(1.0D, 0.0D, 1.0D, 15.0D, 5.0D, 15.0D),
			Block.box(1.0D, 0.0D, 1.0D, 15.0D, 11.0D, 15.0D),
			Block.box(1.0D, 0.0D, 1.0D, 15.0D, 11.0D, 15.0D),
			Block.box(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D),
			Block.box(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D),
			Block.box(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D),
			Block.box(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D)
	};

	public SoyBeanBlock(Properties properties) {
		super(properties);
	}

	@Override
	public BlockState getPlant(BlockGetter level, BlockPos pos) {
		return Homely_Delight.soybeans_crop.get().defaultBlockState();
	}

	@Override
	protected ItemLike getBaseSeedId() {
		return Homely_Delight.soybeans.get();
	}
	@Override
	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
	}
}

package rox.customblocks.foliage;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import rox.customblocks.AvarielTabs;

public class HangingVines extends Block {

	public static final PropertyBool UP = PropertyBool.create("up");
	public static final PropertyBool DOWN = PropertyBool.create("down");
	protected static final AxisAlignedBB hitbox = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 1.0D, 0.9375D);
	
	public HangingVines() {
		super(Material.leaves);
		this.setRegistryName("hanging_vines");
		this.setUnlocalizedName(this.getRegistryName().toString());
		this.setCreativeTab(AvarielTabs.tabAvarielFoliage);
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return hitbox;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	private boolean canBlockStay(World world, BlockPos pos) {
		return !(world.isAirBlock(pos.up()) || !world.isSideSolid(pos.up(), EnumFacing.DOWN));
	}
	
	@Override
	public void onEntityCollidedWithBlock (World world, BlockPos pos, IBlockState state, Entity entity) {
		if (entity.isSneaking()) entity.motionY += 0.2D;
	}

}

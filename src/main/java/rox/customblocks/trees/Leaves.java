package rox.customblocks.trees;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import rox.customblocks.AvarielTabs;

public class Leaves extends Block {
	
	public Leaves(String name) {
		super(Material.leaves);
		this.setRegistryName(name);
		this.setUnlocalizedName(this.getRegistryName().toString());
		this.setCreativeTab(AvarielTabs.tabAvarielTrees);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return blockAccess.getBlockState(pos.offset(side)).getBlock() == this ? false : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }
	
	public static Block leavesOne = new Leaves("leaves_one");
	public static Block leavesTwo = new Leaves("leaves_two");
	public static Block leavesThree = new Leaves("leaves_three");
	public static Block leavesFour = new Leaves("leaves_four");
	public static Block leavesFive = new Leaves("leaves_five");
	public static Block leavesSix = new Leaves("leaves_six");
	public static Block leavesSeven = new Leaves("leaves_seven");
	public static Block leavesEight = new Leaves("leaves_eight");
	public static Block leavesNine = new Leaves("leaves_nine");
	public static Block leavesTen = new Leaves("leaves_ten");
	public static Block leavesEleven = new Leaves("leaves_eleven");
	public static Block leavesTwelve = new Leaves("leaves_twelve");
	public static Block leavesThirteen = new Leaves("leaves_thirteen");
	public static Block leavesFourteen = new Leaves("leaves_fourteen");
	public static Block leavesFifteen = new Leaves("leaves_fifteen");
	public static Block leavesSixteen = new Leaves("leaves_sixteen");
	
	public static ItemBlock leavesOneItem = (ItemBlock) new ItemBlock(leavesOne).setRegistryName("leaves_one");
	public static ItemBlock leavesTwoItem = (ItemBlock) new ItemBlock(leavesTwo).setRegistryName("leaves_two");
	public static ItemBlock leavesThreeItem = (ItemBlock) new ItemBlock(leavesThree).setRegistryName("leaves_three");
	public static ItemBlock leavesFourItem = (ItemBlock) new ItemBlock(leavesFour).setRegistryName("leaves_four");
	public static ItemBlock leavesFiveItem = (ItemBlock) new ItemBlock(leavesFive).setRegistryName("leaves_five");
	public static ItemBlock leavesSixItem = (ItemBlock) new ItemBlock(leavesSix).setRegistryName("leaves_six");
	public static ItemBlock leavesSevenItem = (ItemBlock) new ItemBlock(leavesSeven).setRegistryName("leaves_seven");
	public static ItemBlock leavesEightItem = (ItemBlock) new ItemBlock(leavesEight).setRegistryName("leaves_eight");
	public static ItemBlock leavesNineItem = (ItemBlock) new ItemBlock(leavesNine).setRegistryName("leaves_nine");
	public static ItemBlock leavesTenItem = (ItemBlock) new ItemBlock(leavesTen).setRegistryName("leaves_ten");
	public static ItemBlock leavesElevenItem = (ItemBlock) new ItemBlock(leavesEleven).setRegistryName("leaves_eleven");
	public static ItemBlock leavesTwelveItem = (ItemBlock) new ItemBlock(leavesTwelve).setRegistryName("leaves_twelve");
	public static ItemBlock leavesThirteenItem = (ItemBlock) new ItemBlock(leavesThirteen).setRegistryName("leaves_thirteen");
	public static ItemBlock leavesFourteenItem = (ItemBlock) new ItemBlock(leavesFourteen).setRegistryName("leaves_fourteen");
	public static ItemBlock leavesFifteenItem = (ItemBlock) new ItemBlock(leavesFifteen).setRegistryName("leaves_fifteen");
	public static ItemBlock leavesSixteenItem = (ItemBlock) new ItemBlock(leavesSixteen).setRegistryName("leaves_sixteen");
	
	public static void serverInit() {
		register(leavesOne, leavesOneItem);
		register(leavesTwo, leavesTwoItem);
		register(leavesThree, leavesThreeItem);
		register(leavesFour, leavesFourItem);
		register(leavesFive, leavesFiveItem);
		register(leavesSix, leavesSixItem);
		register(leavesSeven, leavesSevenItem);
		register(leavesEight, leavesEightItem);
		register(leavesNine, leavesNineItem);
		register(leavesTen, leavesTenItem);
		register(leavesEleven, leavesElevenItem);
		register(leavesTwelve, leavesTwelveItem);
		register(leavesThirteen, leavesThirteenItem);
		register(leavesFourteen, leavesFourteenItem);
		register(leavesFifteen, leavesFifteenItem);
		register(leavesSixteen, leavesSixteenItem);
	}
	
	public static void clientInit() {
		render(leavesOne);
		render(leavesTwo);
		render(leavesThree);
		render(leavesFour);
		render(leavesFive);
		render(leavesSix);
		render(leavesSeven);
		render(leavesEight);
		render(leavesNine);
		render(leavesTen);
		render(leavesEleven);
		render(leavesTwelve);
		render(leavesThirteen);
		render(leavesFourteen);
		render(leavesFifteen);
		render(leavesSixteen);
	}

	//Applies textures and models to a given block and it's item form.
	public static void render(Block block) {
		Item item = Item.getItemFromBlock(block);
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
		
	//Registers a block and itemblock pair. This exists for the sake of compactness.
	public static void register(Block block, ItemBlock itemBlock) {
		GameRegistry.register(block);
		GameRegistry.register(itemBlock);
	}

}

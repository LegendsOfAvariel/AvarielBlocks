package rox.customblocks.trees;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rox.customblocks.AvarielTabs;

public class Logs extends BlockLog {
	public Logs(String name) {
		//Registry name set at initialization
		this.setRegistryName(name);
		//Gets unlocalized name from registry name
		this.setUnlocalizedName(this.getRegistryName().toString());
		//All logs should go under the tree tab
		this.setCreativeTab(AvarielTabs.tabAvarielTrees);
		
		//Sets the default state to up and down
		this.setDefaultState(blockState.getBaseState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		IBlockState blockstate = getDefaultState();
		
		switch(meta & 3) {
		case 0: blockstate = blockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y); break;
		case 1: blockstate = blockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.X); break;
		case 2: blockstate = blockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z); break;
		default: blockstate = blockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
		}
		
		return blockstate;
	}
	
	@Override
	@SuppressWarnings("incomplete-switch")
	public int getMetaFromState(IBlockState state) {
		int meta = 0;
		
		switch(state.getValue(LOG_AXIS)) {
		case X: meta |= 1; break;
		case Z: meta |= 2; break;
		case NONE: meta |= 3;
		}
		
		return meta;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {LOG_AXIS});
	}
	
	public static Block logOne = new Logs("log_one");
	public static Block logTwo = new Logs("log_two");
	public static Block logThree = new Logs("log_three");
	public static Block logFour = new Logs("log_four");
	public static Block logFive = new Logs("log_five");
	public static Block logSix = new Logs("log_six");
	public static Block logSeven = new Logs("log_seven");
	public static Block logEight = new Logs("log_eight");
	public static Block logNine = new Logs("log_nine");
	public static Block logTen = new Logs("log_ten");
	public static Block logEleven = new Logs("log_eleven");
	public static Block logTwelve = new Logs("log_twelve");
	public static Block logThirteen = new Logs("log_thirteen");
	public static Block logFourteen = new Logs("log_fourteen");
	public static Block logFifteen = new Logs("log_fifteen");
	public static Block logSixteen = new Logs("log_sixteen");
	
	public static ItemBlock logOneItem = (ItemBlock) new ItemBlock(logOne).setRegistryName("log_one");
	public static ItemBlock logTwoItem = (ItemBlock) new ItemBlock(logTwo).setRegistryName("log_two");
	public static ItemBlock logThreeItem = (ItemBlock) new ItemBlock(logThree).setRegistryName("log_three");
	public static ItemBlock logFourItem = (ItemBlock) new ItemBlock(logFour).setRegistryName("log_four");
	public static ItemBlock logFiveItem = (ItemBlock) new ItemBlock(logFive).setRegistryName("log_five");
	public static ItemBlock logSixItem = (ItemBlock) new ItemBlock(logSix).setRegistryName("log_six");
	public static ItemBlock logSevenItem = (ItemBlock) new ItemBlock(logSeven).setRegistryName("log_seven");
	public static ItemBlock logEightItem = (ItemBlock) new ItemBlock(logEight).setRegistryName("log_eight");
	public static ItemBlock logNineItem = (ItemBlock) new ItemBlock(logNine).setRegistryName("log_nine");
	public static ItemBlock logTenItem = (ItemBlock) new ItemBlock(logTen).setRegistryName("log_ten");
	public static ItemBlock logElevenItem = (ItemBlock) new ItemBlock(logEleven).setRegistryName("log_eleven");
	public static ItemBlock logTwelveItem = (ItemBlock) new ItemBlock(logTwelve).setRegistryName("log_twelve");
	public static ItemBlock logThirteenItem = (ItemBlock) new ItemBlock(logThirteen).setRegistryName("log_thirteen");
	public static ItemBlock logFourteenItem = (ItemBlock) new ItemBlock(logFourteen).setRegistryName("log_fourteen");
	public static ItemBlock logFifteenItem = (ItemBlock) new ItemBlock(logFifteen).setRegistryName("log_fifteen");
	public static ItemBlock logSixteenItem = (ItemBlock) new ItemBlock(logSixteen).setRegistryName("log_sixteen");
	
	public static void serverInit() {
		register(logOne, logOneItem);
		register(logTwo, logTwoItem);
		register(logThree, logThreeItem);
		register(logFour, logFourItem);
		register(logFive, logFiveItem);
		register(logSix, logSixItem);
		register(logSeven, logSevenItem);
		register(logEight, logEightItem);
		register(logNine, logNineItem);
		register(logTen, logTenItem);
		register(logEleven, logElevenItem);
		register(logTwelve, logTwelveItem);
		register(logThirteen, logThirteenItem);
		register(logFourteen, logFourteenItem);
		register(logFifteen, logFifteenItem);
		register(logSixteen, logSixteenItem);
	}
	
	public static void clientInit() {
		render(logOne);
		render(logTwo);
		render(logThree);
		render(logFour);
		render(logFive);
		render(logSix);
		render(logSeven);
		render(logEight);
		render(logNine);
		render(logTen);
		render(logEleven);
		render(logTwelve);
		render(logThirteen);
		render(logFourteen);
		render(logFifteen);
		render(logSixteen);
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

package rox.customblocks.trees;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
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
	
	//Unnecessary override? TODO: check if useful
	@Override
	public int quantityDropped(Random rand) {
		return 1;
	}
	
	//Unnecessary override? TODO: check if useful
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
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
	
	private static Block logOne = new Logs("log_one");
	private static Block logTwo = new Logs("log_two");
	private static Block logThree = new Logs("log_three");
	private static Block logFour = new Logs("log_four");
	private static Block logFive = new Logs("log_five");
	private static Block logSix = new Logs("log_six");
	private static Block logSeven = new Logs("log_seven");
	private static Block logEight = new Logs("log_eight");
	private static Block logNine = new Logs("log_nine");
	private static Block logTen = new Logs("log_ten");
	private static Block logEleven = new Logs("log_eleven");
	private static Block logTwelve = new Logs("log_twelve");
	private static Block logThirteen = new Logs("log_thirteen");
	private static Block logFourteen = new Logs("log_fourteen");
	private static Block logFifteen = new Logs("log_fifteen");
	private static Block logSixteen = new Logs("log_sixteen");
	
	private static ItemBlock logOneItem = (ItemBlock) new ItemBlock(logOne).setRegistryName("log_one");
	private static ItemBlock logTwoItem = (ItemBlock) new ItemBlock(logTwo).setRegistryName("log_two");
	private static ItemBlock logThreeItem = (ItemBlock) new ItemBlock(logThree).setRegistryName("log_three");
	private static ItemBlock logFourItem = (ItemBlock) new ItemBlock(logFour).setRegistryName("log_four");
	private static ItemBlock logFiveItem = (ItemBlock) new ItemBlock(logFive).setRegistryName("log_five");
	private static ItemBlock logSixItem = (ItemBlock) new ItemBlock(logSix).setRegistryName("log_six");
	private static ItemBlock logSevenItem = (ItemBlock) new ItemBlock(logSeven).setRegistryName("log_seven");
	private static ItemBlock logEightItem = (ItemBlock) new ItemBlock(logEight).setRegistryName("log_eight");
	private static ItemBlock logNineItem = (ItemBlock) new ItemBlock(logNine).setRegistryName("log_nine");
	private static ItemBlock logTenItem = (ItemBlock) new ItemBlock(logTen).setRegistryName("log_ten");
	private static ItemBlock logElevenItem = (ItemBlock) new ItemBlock(logEleven).setRegistryName("log_eleven");
	private static ItemBlock logTwelveItem = (ItemBlock) new ItemBlock(logTwelve).setRegistryName("log_twelve");
	private static ItemBlock logThirteenItem = (ItemBlock) new ItemBlock(logThirteen).setRegistryName("log_thirteen");
	private static ItemBlock logFourteenItem = (ItemBlock) new ItemBlock(logFourteen).setRegistryName("log_fourteen");
	private static ItemBlock logFifteenItem = (ItemBlock) new ItemBlock(logFifteen).setRegistryName("log_fifteen");
	private static ItemBlock logSixteenItem = (ItemBlock) new ItemBlock(logSixteen).setRegistryName("log_sixteen");
	
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

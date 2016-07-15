package rox.customblocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import rox.customblocks.trees.Logs;

public class AvarielTabs {
	
	//Tree tab
	public static final CreativeTabs tabAvarielTrees = new CreativeTabs("AvarielTrees") {
		@Override
		public Item getTabIconItem() {
			//Sets an icon for the tab; Change this to change the icon. Will crash if null.
			return Item.getItemFromBlock(Logs.logOne);
		}
	};
	
	public static final CreativeTabs tabAvarielFoliage = new CreativeTabs("AvarielFoliage") {
		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.vine);
		}
	};
	
}

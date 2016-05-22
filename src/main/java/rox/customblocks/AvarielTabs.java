package rox.customblocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class AvarielTabs {
	
	//Tree tab
	public static final CreativeTabs tabAvarielTrees = new CreativeTabs("AvarielTrees") {
		@Override
		public Item getTabIconItem() {
			//Sets an icon for the tab; Change this to change the icon. Will crash if null.
			return Item.getItemFromBlock(Blocks.sapling);
		}
	};
	
}

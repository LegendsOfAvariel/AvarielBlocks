package rox.customblocks;

import org.apache.logging.log4j.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import rox.customblocks.proxy.ServerProxy;

@Mod(name = Info.name, modid = Info.modid, version = Info.version)

public class AvarielBlocks {
	
	//Proxy setup
	@SidedProxy(clientSide = Info.client, serverSide = Info.server)
	public static ServerProxy proxy; //Needs to be static
	
	//Creates a mod instance for interaction with other mods
	@Instance
	public static AvarielBlocks instance; //Needs to be static
	
	public static Logger logger; //Blank logger for use in preinit, needs to be static
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		logger = e.getModLog(); //Forge recommends that this is used
		proxy.preInit(e);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}
	
}

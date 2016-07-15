package rox.customblocks.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import rox.customblocks.trees.Leaves;
import rox.customblocks.trees.Logs;
import rox.customblocks.trees.Planks;

public class ServerProxy {
	
	public void preInit(FMLPreInitializationEvent e) {
		Planks.serverInit(); //Initialize planks serverside
		Logs.serverInit();
		//Leaves.serverInit();
	}
	
	public void init(FMLInitializationEvent e) {
		
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		
	}
	
}

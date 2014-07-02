package com.aesireanempire.eplus

import com.aesireanempire.eplus.blocks.EplusBlocks
import com.aesireanempire.eplus.items.EplusItems
import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.event._

@Mod(name = EnchantingPlus.MODNAME, modid = EnchantingPlus.MODID, modLanguage = "scala")
object EnchantingPlus {
  final val MODNAME = "Enchanting Plus"
  final val MODID = "eplus"

  @Mod.EventHandler
  def preInit(event: FMLPreInitializationEvent) {
    ConfigHandler.init(event.getSuggestedConfigurationFile)

    EplusItems.preInit()
    EplusBlocks.preInit()
  }

  @Mod.EventHandler
  def init(event: FMLInitializationEvent) {
    //Register WorldGen
    //Register Recipes

    EplusItems.init()
    EplusBlocks.init()

    //Register Events
  }

  @Mod.EventHandler
  def postInit(event: FMLPostInitializationEvent) {

  }
}
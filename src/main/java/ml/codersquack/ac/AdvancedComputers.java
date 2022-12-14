package ml.codersquack.ac;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.RegistryObject;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import ml.codersquack.ac.init.BlockInit;
import ml.codersquack.ac.init.ItemInit;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("advancedcomputers")
public class AdvancedComputers
{
  // Directly reference a log4j logger.
  //private static final Logger LOGGER = LogManager.getLogger();
  public static final String MOD_ID = "advancedcomputers";
  // public static final ItemGroup ACITEMS = new Tab("ACItems", ItemInit.ACIG);
  public AdvancedComputers() {
      IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
      FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

      ItemInit.ITEMS.register(bus);
      // BlockInit.BLOCKS.register(bus);

      MinecraftForge.EVENT_BUS.register(this);
  }

  private void setup(final FMLCommonSetupEvent event)
  {
  }

  public static class Tab extends ItemGroup {
    private RegistryObject<Item> icon;

    public Tab(String label, RegistryObject<Item> icon){
      super(label);
      this.icon = icon;
    }

    @Override
    public ItemStack makeIcon(){
      return this.icon.get().getDefaultInstance();
    }
  }
}

package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemSediAggregates extends ItemBlock
{
       public ItemSediAggregates(int par1)
       {
             super(par1);
             setHasSubtypes(true);
       }
      
      public String getUnlocalizedName(ItemStack itemstack)
       {
             String name = "";
             switch(itemstack.getItemDamage())
             {
                    case 0:
                    {
                           name = "gassand";
                           break;
                    }
                    case 1:
                    {
                           name = "greensand";
                           break;
                    }
                    case 2:
                    {
                           name = "bitumen";
                           break;
                    }
                    case 3:
                    {
                           name = "quartzpebble";
                           break;
                    }
                    case 4:
                    {
                           name = "redsand";
                           break;
                    }
                    case 5:
                    {
                           name = "peatcoal";
                           break;
                    }
                    case 6:
                    {
                           name = "blacksand";
                           break;
                    }
                    case 7:
                    {
                           name = "rocks";
                           break;
                    }
                    case 8:
                    {
                           name = "blackrocks";
                           break;
                    }
                    case 9:
                    {
                           name = "geodes";
                           break;
                    }
                    case 10:
                    {
                           name = "silt";
                           break;
                    }
                    case 11:
                    {
                           name = "placersilt";
                           break;
                    }
                    case 12:
                    {
                           name = "volcanicash";
                           break;
                    }
                    case 13:
                    {
                           name = "forestash";
                           break;
                    }
                    case 14:
                    {
                           name = "grassash";
                           break;
                    }
                    case 15:
                    {
                           name = "pebbles";
                           break;
                    }
                    default: name = "broken";
             }
             return getUnlocalizedName() + "." + name;
       } 
      
       public int getMetadata(int par1)
       {
             return par1;
       } 
}
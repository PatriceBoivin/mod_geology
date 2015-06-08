package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemSediAggregatesB extends ItemBlock
{
       public ItemSediAggregatesB(int par1)
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
                           name = "bankgravel";
                           break;
                    }
                    case 1:
                    {
                           name = "benchgravel";
                           break;
                    }
                    case 2:
                    {
                           name = "creekrock";
                           break;
                    }
                    case 3:
                    {
                           name = "crushedrock";
                           break;
                    }
                    case 4:
                    {
                           name = "peagravel";
                           break;
                    }
                    case 5:
                    {
                           name = "riverrungravel";
                           break;
                    }
                    case 6:
                    {
                           name = "crushedstone";
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
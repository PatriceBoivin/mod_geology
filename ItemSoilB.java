package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemSoilB extends ItemBlock
{
       public ItemSoilB(int par1)
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
                           name = "niter";
                           break;
                    }
                    case 1:
                    {
                           name = "swampgrass";
                           break;
                    }
                    case 2:
                    {
                           name = "fielddrygrass";
                           break;
                    }
                    case 3:
                    {
                           name = "fieldgrass";
                           break;
                    }
                    case 4:
                    {
                           name = "fieldgrassflowers";
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
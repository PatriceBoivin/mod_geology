package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMetalOreC extends ItemBlock
{
       public ItemMetalOreC(int par1)
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
                           name = "covellite";
                           break;
                    }
                    case 1:
                    {
                           name = "bornite";
                           break;
                    }
                    case 2:
                    {
                           name = "tetrahedrite";
                           break;
                    }
                    case 3:
                    {
                           name = "azurite";
                           break;
                    }
                    case 4:
                    {
                           name = "cuprite";
                           break;
                    }
                    case 5:
                    {
                           name = "chrysocolla";
                           break;
                    }
                    case 6:
                    {
                           name = "tennantite";
                           break;
                    }
                    case 7:
                    {
                           name = "cassiterite";
                           break;
                    }
                    case 8:
                    {
                           name = "stannite";
                           break;
                    }
                    case 9:
                    {
                           name = "cylindrite";
                           break;
                    }
                    case 10:
                    {
                           name = "franckeite";
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
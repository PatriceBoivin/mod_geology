package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMetalOreE extends ItemBlock
{
       public ItemMetalOreE(int par1)
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
                           name = "sphalerite";
                           break;
                    }
                    case 1:
                    {
                           name = "smithsonite";
                           break;
                    }
                    case 2:
                    {
                           name = "hemimorphite";
                           break;
                    }
                    case 3:
                    {
                           name = "wurtzite";
                           break;
                    }
                    case 4:
                    {
                           name = "hydrozincite";
                           break;
                    }
                    case 5:
                    {
                           name = "bismuthinite";
                           break;
                    }
                    case 6:
                    {
                           name = "frohbergite";
                           break;
                    }
                    case 7:
                    {
                           name = "leucite";
                           break;
                    }
                    case 8:
                    {
                           name = "pollucite";
                           break;
                    }
                    case 9:
                    {
                           name = "carnallite";
                           break;
                    }
                    case 10:
                    {
                           name = "zinnwaldite";
                           break;
                    }
                    case 11:
                    {
                           name = "lepidolite";
                           break;
                    }
                    case 12:
                    {
                           name = "rinneite";
                           break;
                    }
                    case 13:
                    {
                           name = "rokuhnite";
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
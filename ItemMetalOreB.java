package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMetalOreB extends ItemBlock
{
       public ItemMetalOreB(int par1)
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
                           name = "argentite";
                           break;
                    }
                    case 1:
                    {
                           name = "chlorargyrite";
                           break;
                    }
                    case 2:
                    {
                           name = "petzite";
                           break;
                    }
                    case 3:
                    {
                           name = "pentlandite";
                           break;
                    }
                    case 4:
                    {
                           name = "millerite";
                           break;
                    }
                    case 5:
                    {
                           name = "nickeline";
                           break;
                    }
                    case 6:
                    {
                           name = "galena";
                           break;
                    }
                    case 7:
                    {
                           name = "kamacite";
                           break;
                    }
                    case 8:
                    {
                           name = "taenite";
                           break;
                    }
                    case 9:
                    {
                           name = "klockmannite";
                           break;
                    }
                    case 10:
                    {
                           name = "chalcopyrite";
                           break;
                    }
                    case 11:
                    {
                           name = "chalcocite";
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
package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMetalOreD extends ItemBlock
{
       public ItemMetalOreD(int par1)
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
                           name = "canfieldite";
                           break;
                    }
                    case 1:
                    {
                           name = "teallite";
                           break;
                    }
                    case 2:
                    {
                           name = "uraninite";
                           break;
                    }
                    case 3:
                    {
                           name = "carnotite";
                           break;
                    }
                    case 4:
                    {
                           name = "margaritasite";
                           break;
                    }
                    case 5:
                    {
                           name = "tyuyamunite";
                           break;
                    }
                    case 6:
                    {
                           name = "rutile";
                           break;
                    }
                    case 7:
                    {
                           name = "ilmenite";
                           break;
                    }
                    case 8:
                    {
                           name = "sperrylite";
                           break;
                    }
                    case 9:
                    {
                           name = "bertrandite";
                           break;
                    }
                    case 10:
                    {
                           name = "aikinite";
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
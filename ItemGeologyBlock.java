package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemGeologyBlock extends ItemBlock
{
       public ItemGeologyBlock(int par1)
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
                           name = "world";
                           break;
                    }
                    case 1:
                    {
                           name = "nether";
                           break;
                    }
                    case 2:
                    {
                           name = "basalt";
                           break;
                    }
                    case 3:
                    {
                           name = "andesite";
                           break;
                    }
                    case 4:
                    {
                           name = "diorite";
                           break;
                    }
                    case 5:
                    {
                           name = "world";
                           break;
                    }
                    case 6:
                    {
                           name = "nether";
                           break;
                    }
                    case 7:
                    {
                           name = "basalt";
                           break;
                    }
                    case 8:
                    {
                           name = "andesite";
                           break;
                    }
                    case 9:
                    {
                           name = "diorite";
                           break;
                    }
                    case 10:
                    {
                           name = "world";
                           break;
                    }
                    case 11:
                    {
                           name = "nether";
                           break;
                    }
                    case 12:
                    {
                           name = "basalt";
                           break;
                    }
                    case 13:
                    {
                           name = "andesite";
                           break;
                    }
                    case 14:
                    {
                           name = "diorite";
                           break;
                    }
                    case 15:
                    {
                           name = "andesite";
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
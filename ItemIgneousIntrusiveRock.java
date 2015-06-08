package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemIgneousIntrusiveRock extends ItemBlock
{
       public ItemIgneousIntrusiveRock(int par1)
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
                           name = "diorite";
                           break;
                    }
                    case 1:
                    {
                           name = "gabbro";
                           break;
                    }
                    case 2:
                    {
                           name = "granite";
                           break;
                    }
                    case 3:
                    {
                           name = "pegmatite";
                           break;
                    }
                    case 4:
                    {
                           name = "anorthosite";
                           break;
                    }
                    case 5:
                    {
                           name = "orthoclase";
                           break;
                    }
                    case 6:
                    {
                           name = "anorthoclase";
                           break;
                    }
                    case 7:
                    {
                           name = "oligoclase";
                           break;
                    }
                    case 8:
                    {
                           name = "syenite";
                           break;
                    }
                    case 9:
                    {
                           name = "labradorite";
                           break;
                    }
                    case 10:
                    {
                           name = "bytownite";
                           break;
                    }
                    case 11:
                    {
                           name = "albite";
                           break;
                    }
                    case 12:
                    {
                           name = "intrusivebreccia";
                           break;
                    }
                    case 13:
                    {
                           name = "13";
                           break;
                    }
                    case 14:
                    {
                           name = "14";
                           break;
                    }
                    case 15:
                    {
                           name = "15";
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
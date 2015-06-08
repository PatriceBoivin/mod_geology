package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemIgneousExtrusiveRock extends ItemBlock
{
       public ItemIgneousExtrusiveRock(int par1)
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
                           name = "andesite";
                           break;
                    }
                    case 1:
                    {
                           name = "basalt";
                           break;
                    }
                    case 2:
                    {
                           name = "pumice";
                           break;
                    }
                    case 3:
                    {
                           name = "rhyolite";
                           break;
                    }
                    case 4:
                    {
                           name = "scoria";
                           break;
                    }
                    case 5:
                    {
                           name = "tuff";
                           break;
                    }
                    case 6:
                    {
                           name = "sanidine";
                           break;
                    }
                    case 7:
                    {
                           name = "amazonite";
                           break;
                    }
                    case 8:
                    {
                           name = "trachyte";
                           break;
                    }
                    case 9:
                    {
                           name = "anorthite";
                           break;
                    }
                    case 10:
                    {
                           name = "extrusivebreccia";
                           break;
                    }
                    case 11:
                    {
                           name = "basaltbreccia";
                           break;
                    }
                    case 12:
                    {
                           name = "aegerine";
                           break;
                    }
                    case 13:
                    {
                           name = "salmonmicrocline";
                           break;
                    }
                    case 14:
                    {
                           name = "perthite";
                           break;
                    }
                    case 15:
                    {
                           name = "moonstone";
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
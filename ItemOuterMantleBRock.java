package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemOuterMantleBRock extends ItemBlock
{
       public ItemOuterMantleBRock(int par1)
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
                           name = "orthopyroxenite";
                           break;
                    }
                    case 1:
                    {
                           name = "obsidian";
                           break;
                    }
                    case 2:
                    {
                           name = "rhyolite";
                           break;
                    }
                    case 3:
                    {
                           name = "carbonatite";
                           break;
                    }
                    case 4:
                    {
                           name = "serpentinite";
                           break;
                    }
                    case 5:
                    {
                           name = "jadeite";
                           break;
                    }
                    case 6:
                    {
                           name = "nephrite";
                           break;
                    }
                    case 7:
                    {
                           name = "wadsleyite";
                           break;
                    }
                    case 8:
                    {
                           name = "ringwoodite";
                           break;
                    }
                    case 9:
                    {
                           name = "wehrlite";
                           break;
                    }
                    case 10:
                    {
                           name = "harzburgite";
                           break;
                    }
                    case 11:
                    {
                           name = "lherzolite";
                           break;
                    }
                    case 12:
                    {
                           name = "kimberlite";
                           break;
                    }
                    case 13:
                    {
                           name = "lamproite";
                           break;
                    }
                    case 14:
                    {
                           name = "serpentinite";
                           break;
                    }
                    case 15:
                    {
                           name = "periclase";
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
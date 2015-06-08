package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemOuterMantleRock extends ItemBlock
{
       public ItemOuterMantleRock(int par1)
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
                           name = "olivine";
                           break;
                    }
                    case 1:
                    {
                           name = "leucite";
                           break;
                    }
                    case 2:
                    {
                           name = "phlogopite";
                           break;
                    }
                    case 3:
                    {
                           name = "richterite";
                           break;
                    }
                    case 4:
                    {
                           name = "diopside";
                           break;
                    }
                    case 5:
                    {
                           name = "sanidine";
                           break;
                    }
                    case 6:
                    {
                           name = "peridotite";
                           break;
                    }
                    case 7:
                    {
                           name = "dunite";
                           break;
                    }
                    case 8:
                    {
                           name = "eclogite";
                           break;
                    }
                    case 9:
                    {
                           name = "magnesite";
                           break;
                    }
                    case 10:
                    {
                           name = "aragonite";
                           break;
                    }
                    case 11:
                    {
                           name = "lamprophyre";
                           break;
                    }
                    case 12:
                    {
                           name = "clinopyroxenite";
                           break;
                    }
                    case 13:
                    {
                           name = "orangeite";
                           break;
                    }
                    case 14:
                    {
                           name = "leucitite";
                           break;
                    }
                    case 15:
                    {
                           name = "leucogranite";
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
package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMarbleRockH extends ItemBlock
{
       public ItemMarbleRockH(int par1)
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
                           name = "marblenumidiana";
                           break;
                    }
                    case 1:
                    {
                           name = "marblepalissandro";
                           break;
                    }
                    case 2:
                    {
                           name = "marbleparos";
                           break;
                    }
                    case 3:
                    {
                           name = "marblerosaportogallo";
                           break;
                    }
                    case 4:
                    {
                           name = "marblerossoalicante";
                           break;
                    }
                    case 5:
                    {
                           name = "marblerossoerica";
                           break;
                    }
                    case 6:
                    {
                           name = "marblerossoverona";
                           break;
                    }
                    case 7:
                    {
                           name = "marblerossolevanto";
                           break;
                    }
                    case 8:
                    {
                           name = "marblesalome";
                           break;
                    }
                    case 9:
                    {
                           name = "marblepalissandro";
                           break;
                    }
                    case 10:
                    {
                           name = "marblestatuario";
                           break;
                    }
                    case 11:
                    {
                           name = "marbleromantravertine";
                           break;
                    }
                    case 12:
                    {
                           name = "marbleantiquetravertine";
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
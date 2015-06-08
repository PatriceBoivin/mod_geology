package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemSoilGrass extends ItemBlock
{
       public ItemSoilGrass(int par1)
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
                           name = "alfisol";
                           break;
                    }
                    case 1:
                    {
                           name = "andisol";
                           break;
                    }
                    case 2:
                    {
                           name = "aridisol";
                           break;
                    }
                    case 3:
                    {
                           name = "entisol";
                           break;
                    }
                    case 4:
                    {
                           name = "gelisol";
                           break;
                    }
                    case 5:
                    {
                           name = "histosol";
                           break;
                    }
                    case 6:
                    {
                           name = "inceptisol";
                           break;
                    }
                    case 7:
                    {
                           name = "molisol";
                           break;
                    }
                    case 8:
                    {
                           name = "rainforestundergrowth";
                           break;
                    }
                    case 9:
                    {
                           name = "spodosol";
                           break;
                    }
                    case 10:
                    {
                           name = "ultisol";
                           break;
                    }
                    case 11:
                    {
                           name = "vertisol";
                           break;
                    }
                    case 12:
                    {
                           name = "topsoil";
                           break;
                    }
                    case 13:
                    {
                           name = "redclay";
                           break;
                    }
                    case 14:
                    {
                           name = "drymud";
                           break;
                    }
                    case 15:
                    {
                           name = "saltflat";
                           break;
                    }
                    default: name = "default";
             }
             return getUnlocalizedName() + "." + name;
       } 
      
       public int getMetadata(int par1)
       {
             return par1;
       } 
}
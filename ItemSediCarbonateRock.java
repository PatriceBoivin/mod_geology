package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemSediCarbonateRock extends ItemBlock
{
       public ItemSediCarbonateRock(int par1)
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
                           name = "calciterock";
                           break;
                    }
                    case 1:
                    {
                           name = "encrinite";
                           break;
                    }
                    case 2:
                    {
                           name = "bauxite";
                           break;
                    }
                    case 3:
                    {
                           name = "beachrock";
                           break;
                    }
                    case 4:
                    {
                           name = "algalbindstone";
                           break;
                    }
                    case 5:
                    {
                           name = "crinoidbiomicrite";
                           break;
                    }
                    case 6:
                    {
                           name = "biosparite";
                           break;
                    }
                    case 7:
                    {
                           name = "boundstone";
                           break;
                    }
                    case 8:
                    {
                           name = "calcarenite";
                           break;
                    }
                    case 9:
                    {
                           name = "calcilutite";
                           break;
                    }
                    case 10:
                    {
                           name = "chalk";
                           break;
                    }
                    case 11:
                    {
                           name = "coquina";
                           break;
                    }
                    case 12:
                    {
                           name = "micrite";
                           break;
                    }
                    case 13:
                    {
                           name = "dolostone";
                           break;
                    }
                    case 14:
                    {
                           name = "grainstone";
                           break;
                    }
                    case 15:
                    {
                           name = "limestone";
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
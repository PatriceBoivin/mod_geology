package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemSediClasticRock extends ItemBlock
{
       public ItemSediClasticRock(int par1)
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
                           name = "alumshale";
                           break;
                    }
                    case 1:
                    {
                           name = "arenite";
                           break;
                    }
                    case 2:
                    {
                           name = "argillite";
                           break;
                    }
                    case 3:
                    {
                           name = "arkose";
                           break;
                    }
                    case 4:
                    {
                           name = "bentonite";
                           break;
                    }
                    case 5:
                    {
                           name = "blackshale";
                           break;
                    }
                    case 6:
                    {
                           name = "cinerite";
                           break;
                    }
                    case 7:
                    {
                           name = "claystone";
                           break;
                    }
                    case 8:
                    {
                           name = "conglomerate";
                           break;
                    }
                    case 9:
                    {
                           name = "diamictite";
                           break;
                    }
                    case 10:
                    {
                           name = "diatomite";
                           break;
                    }
                    case 11:
                    {
                           name = "eolianite";
                           break;
                    }
                    case 12:
                    {
                           name = "fanglomerate";
                           break;
                    }
                    case 13:
                    {
                           name = "shale";
                           break;
                    }
                    case 14:
                    {
                           name = "sedimentarybreccia";
                           break;
                    }
                    case 15:
                    {
                           name = "siltstone";
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
package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMetalOreA extends ItemBlock
{
       public ItemMetalOreA(int par1)
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
                           name = "siderite";
                           break;
                    }
                    case 1:
                    {
                           name = "ankerite";
                           break;
                    }
                    case 2:
                    {
                           name = "minnesotaite";
                           break;
                    }
                    case 3:
                    {
                           name = "greenalite";
                           break;
                    }
                    case 4:
                    {
                           name = "grunerite";
                           break;
                    }
                    case 5:
                    {
                           name = "magnetite";
                           break;
                    }
                    case 6:
                    {
                           name = "hematite";
                           break;
                    }
                    case 7:
                    {
                           name = "titanomagnetite";
                           break;
                    }
                    case 8:
                    {
                           name = "calaverite";
                           break;
                    }
                    case 9:
                    {
                           name = "sylvanite";
                           break;
                    }
                    case 10:
                    {
                           name = "nagyagite";
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
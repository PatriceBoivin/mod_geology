package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMarbleRockD extends ItemBlock
{
       public ItemMarbleRockD(int par1)
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
                           name = "marbleminggreen";
                           break;
                    }
                    case 1:
                    {
                           name = "marblenaxos";
                           break;
                    }
                    case 2:
                    {
                           name = "marblenaxosgold";
                           break;
                    }
                    case 3:
                    {
                           name = "marbleneroafricano";
                           break;
                    }
                    case 4:
                    {
                           name = "marblenewgialoantiquo";
                           break;
                    }
                    case 5:
                    {
                           name = "marblenexoswhite";
                           break;
                    }
                    case 6:
                    {
                           name = "marblenorwegianpink";
                           break;
                    }
                    case 7:
                    {
                           name = "marbleoperafantastico";
                           break;
                    }
                    case 8:
                    {
                           name = "marblepakistangreenonyx";
                           break;
                    }
                    case 9:
                    {
                           name = "marblepalissandronuvolato";
                           break;
                    }
                    case 10:
                    {
                           name = "marblepietradierfoud";
                           break;
                    }
                    case 11:
                    {
                           name = "marblepinkcipolin";
                           break;
                    }
                    case 12:
                    {
                           name = "marblepintaverde";
                           break;
                    }
                    case 13:
                    {
                           name = "marblerance";
                           break;
                    }
                    case 14:
                    {
                           name = "marbleredcampangriotte";
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
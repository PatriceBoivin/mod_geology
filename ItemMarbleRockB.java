package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMarbleRockB extends ItemBlock
{
       public ItemMarbleRockB(int par1)
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
                           name = "marblebrocatellerougetortosa";
                           break;
                    }
                    case 1:
                    {
                           name = "marblebrocatelleviolettedujura";
                           break;
                    }
                    case 2:
                    {
                           name = "marblebrocatelleviolettespain";
                           break;
                    }
                    case 3:
                    {
                           name = "marblecampan";
                           break;
                    }
                    case 4:
                    {
                           name = "marblecampanerubane";
                           break;
                    }
                    case 5:
                    {
                           name = "marblecampanverderosa";
                           break;
                    }
                    case 6:
                    {
                           name = "marblecarrare";
                           break;
                    }
                    case 7:
                    {
                           name = "marblecarrareblue";
                           break;
                    }
                    case 8:
                    {
                           name = "marblecazavet";
                           break;
                    }
                    case 9:
                    {
                           name = "marblecetteeygun";
                           break;
                    }
                    case 10:
                    {
                           name = "marblecihigeblack";
                           break;
                    }
                    case 11:
                    {
                           name = "marblecipolin";
                           break;
                    }
                    case 12:
                    {
                           name = "marblecipolinmontcenis";
                           break;
                    }
                    case 13:
                    {
                           name = "marblecoquillerdedebilbao";
                           break;
                    }
                    case 14:
                    {
                           name = "marblecremavalencia";
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
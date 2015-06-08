/**
 * 
 */
package geology;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author patriceboivin
 *
 */
	public class TabSoil extends CreativeTabs {
		public TabSoil(int id, String name) {
			super(id, name);
		}
	
    @SideOnly(Side.CLIENT)
    /**
     * the itemID for the item to be displayed on the tab
     */
	public int getTabIconItemIndex() {
		return geology.Geology.soilBlockID; 
	}

    /**
     * Gets the translated Label.
     */
    public String getTranslatedTabLabel()
    {
        return this.getTabLabel();
    }

}

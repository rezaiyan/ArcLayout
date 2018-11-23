package ir.alirezaiyan.arclayout.sample.model

import android.os.Parcel
import android.os.Parcelable
import java.util.*

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */

const val ARC_BOTTOM_NAVIGATION_ID = 1
const val ARC_TOOLBAR_ID = 2
object ListContent {

    val bnvDetails = "BottomNavigationView\n" +
            "public class BottomNavigationView \n" +
            "extends FrameLayout \n" +
            "\n" +
            "java.lang.Object\n" +
            "   ↳\tandroid.view.View\n" +
            " \t   ↳\tandroid.view.ViewGroup\n" +
            " \t \t   ↳\tandroid.widget.FrameLayout\n" +
            " \t \t \t   ↳\tcom.google.android.material.bottomnavigation.BottomNavigationView\n" +
            "\n" +
            "Represents a standard bottom navigation bar for application. It is an implementation of material design bottom navigation.\n" +
            "\n" +
            "Bottom navigation bars make it easy for users to explore and switch between top-level views in a single tap. They should be used when an application has three to five top-level destinations.\n" +
            "\n" +
            "The bar can disappear on scroll, based on HideBottomViewOnScrollBehavior, when it is placed within a CoordinatorLayout and one of the children within the CoordinatorLayout is scrolled. This behavior is only set if the layout_behavior property is set to HideBottomViewOnScrollBehavior.\n" +
            "\n" +
            "The bar contents can be populated by specifying a menu resource file. Each menu item title, icon and enabled state will be used for displaying bottom navigation bar items. Menu items can also be used for programmatically selecting which destination is currently active. "

    val toolbarDetails = "\n" +
            "Toolbar\n" +
            "public class Toolbar \n" +
            "extends ViewGroup \n" +
            "\n" +
            "java.lang.Object\n" +
            "   ↳\tandroid.view.View\n" +
            " \t   ↳\tandroid.view.ViewGroup\n" +
            " \t \t   ↳\tandroid.widget.Toolbar\n" +
            "\n" +
            "A standard toolbar for use within application content.\n" +
            "\n" +
            "A Toolbar is a generalization of action bars for use within application layouts. While an action bar is traditionally part of an Activity's opaque window decor controlled by the framework, a Toolbar may be placed at any arbitrary level of nesting within a view hierarchy. An application may choose to designate a Toolbar as the action bar for an Activity using the setActionBar() method.\n" +
            "\n" +
            "Toolbar supports a more focused feature set than ActionBar. From start to end, a toolbar may contain a combination of the following optional elements:\n" +
            "\n" +
            "A navigation button. This may be an Up arrow, navigation menu toggle, close, collapse, done or another glyph of the app's choosing. This button should always be used to access other navigational destinations within the container of the Toolbar and its signified content or otherwise leave the current context signified by the Toolbar. The navigation button is vertically aligned within the Toolbar's minimum height, if set.\n" +
            "A branded logo image. This may extend to the height of the bar and can be arbitrarily wide.\n" +
            "A title and subtitle. The title should be a signpost for the Toolbar's current position in the navigation hierarchy and the content contained there. The subtitle, if present should indicate any extended information about the current content. If an app uses a logo image it should strongly consider omitting a title and subtitle.\n" +
            "One or more custom views. The application may add arbitrary child views to the Toolbar. They will appear at this position within the layout. If a child view's Toolbar.LayoutParams indicates a Gravity value of CENTER_HORIZONTAL the view will attempt to center within the available space remaining in the Toolbar after all other elements have been measured.\n" +
            "An action menu. The menu of actions will pin to the end of the Toolbar offering a few frequent, important or typical actions along with an optional overflow menu for additional actions. Action buttons are vertically aligned within the Toolbar's minimum height, if set.\n" +
            "In modern Android UIs developers should lean more on a visually distinct color scheme for toolbars than on their application icon. The use of application icon plus title as a standard layout is discouraged on API 21 devices and newer.\n" +
            "\n"
    /**
     * An array of sample (model) items.
     */
    val ITEMS: MutableList<ListItem> = ArrayList()

    /**
     * A map of sample (model) items, by ID.
     */
    val ITEM_MAP: MutableMap<Int, ListItem> = HashMap()

    init {
        // Add some sample items.
        addItem(ListItem(id = ARC_BOTTOM_NAVIGATION_ID, content = "Arc Bottom navigation", details = bnvDetails))
        addItem(ListItem(id = ARC_TOOLBAR_ID, content = "Arc Toolbar", details = toolbarDetails))
    }

    private fun addItem(item: ListItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }


    /**
     * A model item representing a piece of content.
     */
    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    data class ListItem(val id: Int = -1, val content: String, val details: String = "") : Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readInt(),
                parcel.readString(),
                parcel.readString())

        override fun toString(): String = content
        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeInt(id)
            parcel.writeString(content)
            parcel.writeString(details)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<ListItem> {
            override fun createFromParcel(parcel: Parcel): ListItem {
                return ListItem(parcel)
            }

            override fun newArray(size: Int): Array<ListItem?> {
                return arrayOfNulls(size)
            }
        }
    }
}

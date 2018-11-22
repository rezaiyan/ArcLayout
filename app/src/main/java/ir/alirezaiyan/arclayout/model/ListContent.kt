package ir.alirezaiyan.arclayout.model

import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object ListContent {

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
        addItem(ListItem(id = 1, content = "Arc Bottom navigation"))
        addItem(ListItem(id = 2, content = "Arc Toolbar"))
    }

    private fun addItem(item: ListItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }


    /**
     * A model item representing a piece of content.
     */
    data class ListItem(val id: Int = -1, val content: String, val details: String = "") {
        override fun toString(): String = content
    }
}

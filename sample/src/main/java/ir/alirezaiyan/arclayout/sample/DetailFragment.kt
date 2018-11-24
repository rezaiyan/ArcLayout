package ir.alirezaiyan.arclayout.sample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import ir.alirezaiyan.arclayout.sample.model.ListContent
import kotlinx.android.synthetic.main.activity_detail_toolbar.*
import kotlinx.android.synthetic.main.item_detail.*

class DetailFragment : Fragment() {

    /**
     * The model content this fragment is presenting.
     */
    private var item: ListContent.ListItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                // Load the model content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
                item = ListContent.ITEM_MAP[it.getInt(ARG_ITEM_ID)]
                activity?.toolbar_layout?.title = item?.content
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?) = inflater.inflate(R.layout.item_detail, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // Show the model content as text in a TextView.
        item_detail.text = item?.details
    }


    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }
}

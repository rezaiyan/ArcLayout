package ir.alirezaiyan.arclayout.sample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import ir.alirezaiyan.arclayout.sample.model.ARC_TOOLBAR_ID
import ir.alirezaiyan.arclayout.sample.model.ListContent
import kotlinx.android.synthetic.main.activity_detail_toolbar.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listItem = intent.getParcelableExtra<ListContent.ListItem>(DetailFragment.ARG_ITEM_ID)
        val layout = if (listItem.id == ARC_TOOLBAR_ID) R.layout.activity_detail_toolbar else R.layout.activity_detail_bottom_navigation
        setContentView(layout)
        setSupportActionBar(detail_toolbar)
        title = listItem.content


        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            val fragment = DetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(DetailFragment.ARG_ITEM_ID, listItem.id)
                }
            }

            supportFragmentManager.beginTransaction()
                    .add(R.id.item_detail_container, fragment)
                    .commit()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem) =
            when (item.itemId) {
                android.R.id.home -> {
                    // This ID represents the Home or Up button. In the case of this
                    // activity, the Up button is shown. For
                    // more details, see the Navigation pattern on Android Design:
                    //
                    // http://developer.android.com/design/patterns/navigation.html#up-vs-back

                    navigateUpTo(Intent(this, MainActivity::class.java))
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }
}
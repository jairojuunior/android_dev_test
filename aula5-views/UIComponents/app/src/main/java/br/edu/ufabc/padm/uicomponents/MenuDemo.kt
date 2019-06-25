package br.edu.ufabc.padm.uicomponents

import android.os.Bundle
import android.util.Log
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.AbsListView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MenuDemo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_demo)
        setUpListView()
    }

    private fun setUpListView() {
        // retrieve the list layout
        val listView = findViewById<ListView>(R.id.cities_list)

        // register the adapter
        listView.adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_activated_1,
                resources.getStringArray(R.array.cities_list))

        // register the contextual menu
        listView.choiceMode = ListView.CHOICE_MODE_MULTIPLE_MODAL
        listView.setMultiChoiceModeListener(object : AbsListView.MultiChoiceModeListener {
            override fun onItemCheckedStateChanged(mode: ActionMode, position: Int, id: Long, checked: Boolean) {
                mode.title = getString(R.string.context_menu_selected_count,
                        listView.checkedItemCount)
            }

            override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
                val inflater = mode.menuInflater

                inflater.inflate(R.menu.menu_context_demo, menu)
                mode.title = resources.getString(R.string.context_menu_title)

                return true
            }

            override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
                return false
            }

            override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
                val count = listView.checkedItemCount

                when (item.itemId) {
                    R.id.action_context_remove -> {
                        Toast.makeText(listView.context, getString(R.string.status_context_add, count),
                                Toast.LENGTH_SHORT).show()
                        return true
                    }
                    R.id.action_context_share -> {
                        Toast.makeText(listView.context, getString(R.string.status_context_share, count),
                                Toast.LENGTH_SHORT).show()
                        Log.e("MenuDemo", "Unknown operation")
                    }
                    else -> Log.e("MenuDemo", "Unknown operation")
                }

                return false
            }

            override fun onDestroyActionMode(mode: ActionMode) {

            }
        })
    }
}

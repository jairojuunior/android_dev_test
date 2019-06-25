package br.edu.ufabc.padm.agendacontatos2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import br.edu.ufabc.padm.agendacontatos2.model.ContatoDAO


class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setupContatoList()
    }

    private fun init() {
        listView = findViewById(R.id.list_contatos)
    }


    private fun setupContatoList() {
        listView = findViewById(R.id.list_contatos)

        listView.adapter = ContatoAdapter()
        listView.choiceMode = ListView.CHOICE_MODE_MULTIPLE_MODAL
        listView.setMultiChoiceModeListener(object : AbsListView.MultiChoiceModeListener {
            override fun onItemCheckedStateChanged(mode: ActionMode, position: Int, id: Long, checked: Boolean) {
                mode.title = getString(R.string.context_menu_selected_count,
                        listView.checkedItemCount)
            }

            override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
                val inflater = mode.menuInflater

                inflater.inflate(R.menu.menu_list_cab, menu)
                mode.title = resources.getString(R.string.context_menu_title)

                return true
            }


            override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
                return false
            }

            /**
             * Obtain positions of selected items and perform their removal in batch
             * @param mode
             * @param item
             * @return
             */
            override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
                val checkedContacts = listView.checkedItemPositions
                val contatoAdapter = listView.adapter as ContatoAdapter
                val id = item.itemId

                if (id == R.id.action_context_remove) {
                    val removePositions = IntArray(checkedContacts.size())
                    var j = 0

                    for (i in 0 until contatoAdapter.count)
                        if (checkedContacts.get(i))
                            removePositions[j++] = i
                    if (ContatoDAO.instance.removeAll(removePositions)) {
                        mode.finish() // close the CAB menu
                        Toast.makeText(this@MainActivity, getString(R.string.success_remove_contact),
                                Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this@MainActivity, getString(R.string.failed_remove_contact),
                                Toast.LENGTH_LONG).show()
                    }
                    return true
                } else {
                    Log.e("MenuDemo", "Unknown operation")
                    return true
                }

                return false
            }

            override fun onDestroyActionMode(mode: ActionMode) {

            }
        })

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(parent.context, ContatoDetails::class.java)

            intent.putExtra(App.CONTACT_POSITION_EXTRA_KEY, position)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_add) {
            val intent = Intent(this, ContatoInsertEdit::class.java)

            intent.putExtra(App.CONTACT_EDIT_EXTRA_KEY, false)
            startActivity(intent)

            return true
        }

        return super.onOptionsItemSelected(item)
    }

}

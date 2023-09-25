package com.example.productive2.ui.activity
//noinspection SuspiciousImport
import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.productive2.data.model.PlanModel
import com.example.productive2.ui.adapter.AdapterProd
import com.example.productive2.databinding.ActivityMainBinding


class MainActivity : BaseActivity<ActivityMainBinding>(),AdapterProd.Result {
    private lateinit var spinner: Spinner
    private lateinit var adapterNote: AdapterProd
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapterNote = AdapterProd(this)
        binding.rvNotes.adapter = adapterNote
        spinner()
        initViewModel()
        onClick()
    }


    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)

    }
    private fun spinner(){
        val parameters :Array<String> = arrayOf("Not done","Done","Planned")
        val adb =  ArrayAdapter(this@MainActivity,R.layout.simple_spinner_dropdown_item,parameters)
        spinner = binding.spinner
        spinner.adapter = adb
        val data = ArrayList<String>()
        data.add("Not done")
        data.add("Done")
    }
    private fun initViewModel() {
        viewModel.getAllNotes()
        viewModel.liveData.observe(this) {
            adapterNote.setList(it)
            Toast.makeText(this, "getNotes", Toast.LENGTH_SHORT).show()
        }
    }
    private fun onClick(){
        binding.btnAdd.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun deleteNote(model: PlanModel) {
        viewModel.deleteNote(model)
        viewModel.getAllNotes()
        viewModel.liveData.observe(this) {
            adapterNote.setList(it)
            Toast.makeText(this, "getNotes", Toast.LENGTH_SHORT).show()
        }
    }

    override fun updateNote(model: PlanModel) {
        viewModel.updateNote(model)
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("key", model)
        startActivity(intent)
        finish()
    }

    override fun didNote(model: PlanModel) {

    }
}
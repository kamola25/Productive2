package com.example.productive2.ui.activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.productive2.data.model.PlanModel
import com.example.productive2.databinding.ActivitySecondBinding


class SecondActivity : BaseActivity<ActivitySecondBinding>() {
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onClick()
    }

    override fun getViewBinding(): ActivitySecondBinding {
        return ActivitySecondBinding.inflate(layoutInflater)
    }
    private fun onClick() {
        binding.btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }
        val model = intent.getSerializableExtra("key") as? PlanModel
        if (model != null) {
            val id = model.id
            val title = model.title
            val desc = model.description
            binding.etTitle.setText(title)
            binding.etDescription.setText(desc)
            binding.btnSave.setOnClickListener {
                val title1 = binding.etTitle.text.toString()
                val des = binding.etDescription.text.toString()

                viewModel.updateNote(PlanModel(id = id, title = title1, description = des))
                Toast.makeText(this, "setNote", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        } else {
            binding.btnSave.setOnClickListener {
                val title = binding.etTitle.text.toString()
                val des = binding.etDescription.text.toString()

                viewModel.setUser(PlanModel(title = title, description = des))
                Toast.makeText(this, "setNote", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }
}
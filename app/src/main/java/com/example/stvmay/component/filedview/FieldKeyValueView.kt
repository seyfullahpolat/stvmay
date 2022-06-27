package com.example.stvmay.component.filedview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.stvmay.databinding.FieldKeyValueViewBinding

class FieldKeyValueView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(
    context,
    attrs,
    defStyleAttr
) {
    private var binding: FieldKeyValueViewBinding =
        FieldKeyValueViewBinding.inflate(LayoutInflater.from(context), this, false)

    init {
        addView(binding.root)
    }

    fun setFieldData(fieldKey: String, fieldValue: String) {
        binding.fieldKey.text = fieldKey
        binding.fieldValue.text = fieldValue
    }
}

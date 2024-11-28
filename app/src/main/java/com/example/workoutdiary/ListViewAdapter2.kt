import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import com.example.workoutdiary.Exercise
import com.example.workoutdiary.ListViewItem2
import com.example.workoutdiary.databinding.ListviewItem2Binding

class ListViewAdapter2(private val items: MutableList<Exercise>) : BaseAdapter() {

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Exercise = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val binding: ListviewItem2Binding
        val convertView: View

        if (view == null) {
            binding = ListviewItem2Binding.inflate(LayoutInflater.from(parent?.context), parent, false)
            convertView = binding.root
            convertView.tag = binding
        } else {
            convertView = view
            binding = convertView.tag as ListviewItem2Binding
        }

        val item = items[position]
        binding.title.text = item.machine
        binding.set.text = item.count.toString()

        // 삭제 버튼 클릭 시 아이템 삭제
        binding.deleteButton.setOnClickListener {
            items.removeAt(position)
            notifyDataSetChanged()
            Toast.makeText(parent?.context, "${item.machine} 운동을 삭제했습니다", Toast.LENGTH_SHORT).show()
        }
        return convertView
    }
}

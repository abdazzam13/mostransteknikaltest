import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mostransteknikaltest.R
import com.example.mostransteknikaltest.model.Character

class CharacterAdapter() : RecyclerView.Adapter<CharacterAdapter.ListViewHolder>() {
    private val characters = ArrayList<Character>()

    fun setCharacterData(character: ArrayList<Character>) {
        characters.clear()
        characters.addAll(character)
        notifyDataSetChanged()
    }

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.image_character)
        var nameTextView: TextView = itemView.findViewById(R.id.text_name)
        var speciesTextView: TextView = itemView.findViewById(R.id.text_species)
        var genderTextView: TextView = itemView.findViewById(R.id.text_gender)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val createView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_character_detail, parent, false)
        return ListViewHolder(createView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var character = characters[position]
        // Set image
        Glide.with(holder.itemView.context)
            .load(character.imageResource)
            .into(holder.imageView);
        // Set text
        holder. nameTextView.text = "Nama: ${character.name}"
        holder.speciesTextView.text = "Spesies: ${character.species}"
        holder.genderTextView.text = "Jenis Kelamin: ${character.gender}"
    }

    override fun getItemCount(): Int = characters.size
}

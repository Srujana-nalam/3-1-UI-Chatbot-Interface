package project.uichatbotinterface

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(
    private val messages: List<ChatMessage>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {

        return messages[position].type
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {

        return if (viewType == ChatMessage.TYPE_USER) {

            val view = LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_user_message,
                    parent,
                    false
                )

            UserViewHolder(view)

        } else {

            val view = LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_bot_message,
                    parent,
                    false
                )

            BotViewHolder(view)
        }
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {

        val message = messages[position]

        if (holder is UserViewHolder) {

            holder.messageText.text = message.message

        } else if (holder is BotViewHolder) {

            holder.messageText.text = message.message
        }
    }

    override fun getItemCount(): Int {

        return messages.size
    }

    class UserViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val messageText: TextView =
            itemView.findViewById(R.id.userMessageText)
    }

    class BotViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val messageText: TextView =
            itemView.findViewById(R.id.botMessageText)
    }
}

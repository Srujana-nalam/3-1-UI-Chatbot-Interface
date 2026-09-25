package project.uichatbotinterface

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var messageInput: EditText
    private lateinit var sendButton: ImageButton
    private lateinit var typingText: TextView

    private lateinit var chatAdapter: ChatAdapter

    private val messages = mutableListOf<ChatMessage>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        messageInput = findViewById(R.id.messageInput)
        sendButton = findViewById(R.id.sendButton)
        typingText = findViewById(R.id.typingText)

        chatAdapter = ChatAdapter(messages)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = chatAdapter

        // Welcome message
        addBotMessage(
            "Hello! 👋 I am your AI Assistant. How can I help you today?"
        )

        sendButton.setOnClickListener {
            sendMessage()
        }

        messageInput.setOnEditorActionListener { _, _, _ ->
            sendMessage()
            true
        }
    }

    private fun sendMessage() {

        val userMessage = messageInput.text.toString().trim()

        if (userMessage.isEmpty()) {
            return
        }

        // Add user message
        messages.add(
            ChatMessage(
                userMessage,
                ChatMessage.TYPE_USER
            )
        )

        chatAdapter.notifyItemInserted(messages.size - 1)
        scrollToBottom()

        messageInput.text.clear()

        // Show typing indicator
        typingText.visibility = View.VISIBLE

        // Simulate AI processing
        Handler(Looper.getMainLooper()).postDelayed({

            typingText.visibility = View.GONE

            val response = ChatbotService.getResponse(userMessage)

            addBotMessage(response)

        }, 1000)
    }

    private fun addBotMessage(message: String) {

        messages.add(
            ChatMessage(
                message,
                ChatMessage.TYPE_BOT
            )
        )

        chatAdapter.notifyItemInserted(messages.size - 1)

        scrollToBottom()
    }

    private fun scrollToBottom() {

        if (messages.isNotEmpty()) {
            recyclerView.scrollToPosition(messages.size - 1)
        }
    }
}

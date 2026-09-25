package project.uichatbotinterface

object ChatbotService {

    fun getResponse(message: String): String {

        val input = message.lowercase().trim()

        return when {

            input.contains("hello") ||
                    input.contains("hi") ||
                    input.contains("hey") -> {

                "Hello! 👋 Nice to meet you. How can I help you?"
            }

            input.contains("how are you") -> {

                "I'm doing great! 😊 Thanks for asking. What would you like to know?"
            }

            input.contains("your name") -> {

                "I am your AI Assistant 🤖."
            }

            input.contains("help") -> {

                "Sure! I can answer questions and have a conversation with you."
            }

            input.contains("android") -> {

                "Android development allows you to create mobile applications using technologies such as Kotlin and XML."
            }

            input.contains("kotlin") -> {

                "Kotlin is a modern programming language widely used for Android application development."
            }

            input.contains("flutter") -> {

                "Flutter is a UI framework from Google used to build cross-platform applications."
            }

            input.contains("thank") -> {

                "You're welcome! 😊"
            }

            input.contains("bye") -> {

                "Goodbye! 👋 Have a great day!"
            }

            else -> {

                "That's an interesting question! 🤖 In the real AI version, I would process your message using an AI model and generate a suitable response."
            }
        }
    }
}

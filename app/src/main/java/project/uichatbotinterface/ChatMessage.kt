package project.uichatbotinterface

data class ChatMessage(
    val message: String,
    val type: Int
) {

    companion object {

        const val TYPE_USER = 0
        const val TYPE_BOT = 1
    }
}

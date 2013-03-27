package ingredients._04

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession

class ActionContext(
        val request: HttpServletRequest,
        val response: HttpServletResponse,
        val session: HttpSession
)

class Server() {
    fun handler(path: String, handler: ActionContext.() -> Unit) {
        // register mapping somewhere
    }
}

fun server(init: Server.()->Unit): Server {
    val answer = Server()
    answer.init()
    return answer
}

fun ActionContext.respond(body: String) {
    return response.getWriter()!!.write("""
            <html>
                <body>
                    $body
                </body>
            </html>
            """
    )
}

//--------------------------------------------------------------------------------------------------------

fun main(args: Array<String>) {
    server {
        handler("/index") {
            respond("Hi there!")
            session.setAttribute("user", "guest")
        }

        handler("/logout") {
            val user = session.getAttribute("user")
            if (user == null) {
                respond("Who's here?!")
            }
            else {
                respond("See you later, $user")
            }
        }
    }
}

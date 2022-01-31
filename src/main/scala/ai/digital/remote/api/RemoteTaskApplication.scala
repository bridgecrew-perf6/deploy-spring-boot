package ai.digital.remote.api

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration

object RemoteTaskApplication {
  def main(args: Array[String]): Unit = {
    val app = new SpringApplication(classOf[RemoteTaskApplication])
    app.run(args:_*)
  }
}

@SpringBootApplication(exclude = Array(classOf[SecurityAutoConfiguration]))
class RemoteTaskApplication {

}

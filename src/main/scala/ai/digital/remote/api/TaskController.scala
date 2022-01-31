package ai.digital.remote.api

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.web.bind.annotation.{GetMapping, RestController}

@RestController
@GetMapping(Array("/deploy/remote"))
class TaskController {

  @GetMapping(Array("/task"))
  def getTask() = {
    //new TaskSpecificationExchangeWrapper(Seq("step"), "test".getBytes, "task id", Set("file"), Seq("art"))
    readFromFile()
  }

  def readFromFile() = {
    val mapper = new ObjectMapper()
    mapper.readValue(getClass.getClassLoader.getResourceAsStream("tse.json"), classOf[TaskSpecificationExchangeWrapper])
  }
}
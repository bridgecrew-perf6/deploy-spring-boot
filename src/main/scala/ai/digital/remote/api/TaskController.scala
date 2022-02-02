package ai.digital.remote.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.xebialabs.satellite.protocol.TaskSpecificationExchange
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, RestController}

@RestController
@GetMapping(Array("/deploy/remote"))
class TaskController {

  @Autowired
  var mapper: ObjectMapper = _

  @GetMapping(Array("/task"))
  def getTask() = {
    //new TaskSpecificationExchangeWrapper(Seq("step"), "test".getBytes, "task id", Set("file"), Seq("art"))
    readFromFile()
  }

  def readFromFile() = {
    mapper.readValue(getClass.getClassLoader.getResourceAsStream("tse.json"), classOf[TaskSpecificationExchange])
  }
}